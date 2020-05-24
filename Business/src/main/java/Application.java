import name.benjaminabbitt.evented.BusinessLogic.BookmarkService;
import name.benjaminabbitt.evented.business.BusinessLogicGrpc;
import name.benjaminabbitt.evented.server.EventedServer;
import name.benjaminabbitt.evented.server.EventedService;

import java.util.Arrays;

import static name.benjaminabbitt.evented.opentracing.TracerSupport.getTracer;

public class Application {
    public static void main(String[] args) throws Exception {
        EventedServer server = new EventedServer(1748, Arrays.asList(new EventedService[]{new BookmarkService()}), getTracer());
        server.start();
        server.blockUntilShutdown();
    }
}
