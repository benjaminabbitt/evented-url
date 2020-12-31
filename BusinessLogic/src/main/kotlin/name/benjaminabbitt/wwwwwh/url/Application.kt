package name.benjaminabbitt.wwwwwh.url

import io.micronaut.runtime.Micronaut
import org.slf4j.LoggerFactory

object Application {
    @JvmStatic
    fun main(args: Array<String>) {
        val logger = LoggerFactory.getLogger(Application::class.java)
        val builder = Micronaut.build(*args) //.propertySources(new EnvironmentPropertySource())
                .mainClass(Application::class.java)
        logger.debug("Application Built")
        builder.start()
    }
}