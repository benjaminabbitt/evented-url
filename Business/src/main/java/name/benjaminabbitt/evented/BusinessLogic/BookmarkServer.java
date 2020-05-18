package name.benjaminabbitt.evented.BusinessLogic;

import com.google.protobuf.InvalidProtocolBufferException;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import name.benjaminabbitt.evented.BusinessLogic.Bookmarks.Bookmark;
import name.benjaminabbitt.evented.BusinessLogic.Bookmarks.NotCreatedBookmark;
import name.benjaminabbitt.evented.bookmarks.Bookmarks;
import name.benjaminabbitt.evented.business.BusinessLogicGrpc;
import name.benjaminabbitt.evented.core.Evented;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.cfg4j.provider.ConfigurationProvider;
import org.cfg4j.provider.ConfigurationProviderBuilder;
import org.cfg4j.source.ConfigurationSource;
import org.cfg4j.source.context.filesprovider.ConfigFilesProvider;
import org.cfg4j.source.files.FilesConfigurationSource;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class BookmarkServer {
    private final Server server;
    private final ConfigurationProvider configuration;
    private final Logger logger;

    public BookmarkServer(int port) {
        this(ServerBuilder.forPort(port));
    }

    public BookmarkServer(ServerBuilder<?> serverBuilder) {
        this.server = serverBuilder.addService(new BookmarkService()).build();
        configuration = setupConfiguration();
        logger = LogManager.getLogger();
    }

    private ConfigurationProvider setupConfiguration() {
        ConfigFilesProvider provider = () -> Arrays.asList(Paths.get("application.yaml"));
        ConfigurationSource source = new FilesConfigurationSource(provider);
        ConfigurationProvider configuration = new ConfigurationProviderBuilder()
                .withConfigurationSource(source)
                .build();
        return configuration;
    }


    public void start() throws IOException {
        this.server.start();
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                try {
                    BookmarkServer.this.stop();
                } catch (InterruptedException e) {
                    e.printStackTrace(System.err);
                }
                System.err.println("*** server shut down");
            }
        });
    }

    /**
     * Stop serving requests and shutdown resources.
     */
    public void stop() throws InterruptedException {
        if (server != null) {
            server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
    }

    /**
     * Await termination on the main thread since the grpc library uses daemon threads.
     */
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    private static class BookmarkService extends BusinessLogicGrpc.BusinessLogicImplBase {
        private Bookmark bookmark;

        private BookmarkService() {
            this.bookmark = new NotCreatedBookmark();
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
            throw new Exception("TODO");
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
            throw new Exception("TODO");
        }
    }

    public static void main(String[] args) throws Exception {
        BookmarkServer server = new BookmarkServer(1748);
        server.start();
        server.blockUntilShutdown();
    }
}