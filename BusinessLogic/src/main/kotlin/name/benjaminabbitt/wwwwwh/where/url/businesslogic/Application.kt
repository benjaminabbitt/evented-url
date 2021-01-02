package name.benjaminabbitt.wwwwwh.where.url.businesslogic

import io.micronaut.context.env.EnvironmentPropertySource
import io.micronaut.runtime.Micronaut
import org.slf4j.LoggerFactory

object Application {
    @JvmStatic
    fun main(args: Array<String>) {
        val logger = LoggerFactory.getLogger(Application::class.java)
        val builder = Micronaut.build(*args)
            .propertySources(EnvironmentPropertySource())
            .mainClass(Application::class.java)
        logger.debug("Application Built")
        builder.start()
    }
}