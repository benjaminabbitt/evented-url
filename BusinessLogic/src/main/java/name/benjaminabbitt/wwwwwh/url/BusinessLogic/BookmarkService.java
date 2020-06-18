package name.benjaminabbitt.wwwwwh.url.BusinessLogic;

import com.google.protobuf.InvalidProtocolBufferException;
import io.grpc.stub.StreamObserver;
import name.benjaminabbitt.evented.bookmarks.Bookmarks;
import name.benjaminabbitt.evented.business.BusinessLogicGrpc;
import name.benjaminabbitt.evented.core.Evented;
import name.benjaminabbitt.wwwwwh.url.BusinessLogic.Bookmarks.Bookmark;
import name.benjaminabbitt.wwwwwh.url.BusinessLogic.Bookmarks.StateMachine.NotCreatedBookmark;
import org.apache.logging.log4j.Logger;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

@Singleton
public class BookmarkService extends BusinessLogicGrpc.BusinessLogicImplBase {
    private Bookmark bookmark;
    private Logger logger;

    public BookmarkService() {
        this.bookmark = new NotCreatedBookmark();
    }

    public void Configure(Logger logger) {
        this.logger = logger;
    }

    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void handle(Evented.ContextualCommand request, StreamObserver<Evented.EventBook> responseObserver) {
        assert request != null;
        request.getEvents().getPagesList().forEach(ea -> {
            try {
                this.bookmark = this.dispatchEvent(ea);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        ArrayList<Evented.EventPage> pages = new ArrayList<Evented.EventPage>();
        AtomicInteger seq = new AtomicInteger(request.getCommand().getPages(0).getSequence());
        request.getCommand().getPagesList().forEach(commandPage -> {
            try {
                Stream<Evented.EventPage.Builder> events = this.dispatchCommand(commandPage);
                events.forEach(event -> {
                    pages.add(event.setNum(seq.getAndIncrement()).build());
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        Evented.EventBook book = Evented.EventBook.newBuilder()
                .setCover(request.getCommand().getCover())
                .addAllPages(pages)
                .build();
        responseObserver.onNext(book);
        responseObserver.onCompleted();
    }


    private Bookmark dispatchEvent(Evented.EventPage page) throws Exception {
        try {
            if (page.getEvent().is(Bookmarks.BookmarkCreated.class)) {
                return this.bookmark.handle(page.getEvent().unpack(Bookmarks.BookmarkCreated.class));
            } else if (page.getEvent().is(Bookmarks.BookmarkDeleted.class)) {
                return this.bookmark.handle(page.getEvent().unpack(Bookmarks.BookmarkDeleted.class));
            } else {
                throw new Exception("TODO");
            }
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
        throw new IllegalStateException("Event didn't match anything that this application can handle.");
    }

    private Stream<Evented.EventPage.Builder> dispatchCommand(Evented.CommandPage page) throws Exception {
        try {
            if (page.getCommand().is(Bookmarks.CreateBookmark.class)) {
                return this.bookmark.handle(page.getCommand().unpack(Bookmarks.CreateBookmark.class));
            } else if (page.getCommand().is(Bookmarks.DeleteBookmark.class)) {
                return this.bookmark.handle(page.getCommand().unpack(Bookmarks.DeleteBookmark.class));
            }
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
        throw new IllegalStateException("Command didn't match anything that this application can handle");
    }
}