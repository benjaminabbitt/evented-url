package name.benjaminabbitt.evented.wwwwwh.url;

import io.grpc.ServerBuilder;
import name.benjaminabbitt.evented.wwwwwh.url.BusinessLogic.BookmarkService;
import name.benjaminabbitt.evented.server.*;
import picocli.CommandLine;

import java.util.Arrays;

import static name.benjaminabbitt.evented.opentracing.TracerSupport.getTracer;


public class Business {
    public static void main(String[] args) throws Exception {
        CLIOptions options = new CLIOptions();
        new CommandLine(options).parseArgs(args);
        EventedConfig config = EventedConfigSetup.setupConfiguration(options);
        EventedServer server = new EventedServer(ServerBuilder.forPort(config.port), Arrays.asList(new EventedService[]{new BookmarkService()}), config, getTracer());

        server.start();
        server.blockUntilShutdown();
    }
}
