package name.benjaminabbitt.evented.BusinessLogic;

import io.jaegertracing.Configuration;
import io.jaegertracing.internal.JaegerTracer;
import io.jaegertracing.spi.Reporter;
import io.opentracing.Span;
import io.opentracing.Tracer;
import name.benjaminabbitt.evented.EventedServer;
import name.benjaminabbitt.evented.EventedService;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) throws Exception {

        Tracer tracer = Configuration.fromEnv("java-test").withSampler(new Configuration.SamplerConfiguration().withType("const").withParam(1)).getTracer();
        Span span = tracer.buildSpan("java-test-test").start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        span.finish();
        tracer.close();
//        EventedServer server = new EventedServer(1748, Arrays.asList(new EventedService[]{new BookmarkService()}));
//        server.start();
//        server.blockUntilShutdown();
    }
}
