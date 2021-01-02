package name.benjaminabbitt.wwwwwh.where.url.projection.sample.opentracing

import io.jaegertracing.Configuration
import io.opentracing.Tracer

object TracerSupport {
    @JvmStatic
    val tracer: Tracer
        get() = Configuration.fromEnv("java-test").withSampler(Configuration.SamplerConfiguration().withType("const").withParam(1)).tracer
}