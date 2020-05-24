package name.benjaminabbitt.evented.opentracing;

import io.jaegertracing.Configuration;
import io.opentracing.Tracer;

public class TracerSupport {
    public static Tracer getTracer() {
        return Configuration.fromEnv("java-test").withSampler(new Configuration.SamplerConfiguration().withType("const").withParam(1)).getTracer();
    }
}
