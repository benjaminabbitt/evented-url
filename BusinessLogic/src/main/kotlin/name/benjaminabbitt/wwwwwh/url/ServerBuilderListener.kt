package name.benjaminabbitt.wwwwwh.url

import io.grpc.ServerBuilder
import io.grpc.services.HealthStatusManager
import io.micronaut.context.event.BeanCreatedEvent
import io.micronaut.context.event.BeanCreatedEventListener
import javax.inject.Singleton

@Singleton
class ServerBuilderListener : BeanCreatedEventListener<ServerBuilder<*>> {
    override fun onCreated(event: BeanCreatedEvent<ServerBuilder<*>>): ServerBuilder<*> {
        val builder = event.bean
        val healthStatusManager = HealthStatusManager()
        builder.addService(healthStatusManager.healthService)
        // Unclear why this is not required.  Introspection?  Including this line ends up with double instantiation of BookmarkService
        ///builder.addService(ctx.getBean(BookmarkService.class));
        return builder
    }
}