package name.benjaminabbitt.evented.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.opentracing.Tracer;
import io.opentracing.contrib.grpc.TracingServerInterceptor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.cfg4j.provider.ConfigurationProvider;
import org.cfg4j.provider.ConfigurationProviderBuilder;
import org.cfg4j.source.ConfigurationSource;
import org.cfg4j.source.consul.ConsulConfigurationSourceBuilder;
import org.cfg4j.source.context.filesprovider.ConfigFilesProvider;
import org.cfg4j.source.files.FilesConfigurationSource;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class EventedServer {
    private final Server server;
    private final Logger logger;
    private final Tracer tracer;


    public EventedServer(ServerBuilder<?> serverBuilder, List<EventedService> services, EventedConfig config, Tracer tracer) {
        this.logger = LogManager.getLogger();
        this.tracer = tracer;

        TracingServerInterceptor tracingInterceptor = TracingServerInterceptor
                .newBuilder()
                .withVerbosity()
                .withTracer(this.tracer)
                .build();

        services.forEach((service) -> {
            service.Configure(this.logger);
            serverBuilder.addService(tracingInterceptor.intercept(service));
        });
        this.server = serverBuilder.build();
    }

    public void start() throws IOException {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                try {
                    EventedServer.this.stop();
                } catch (InterruptedException e) {
                    e.printStackTrace(System.err);
                }
                System.err.println("*** server shut down");
            }
        });
        this.server.start();
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
    public void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

}