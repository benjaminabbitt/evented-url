package name.benjaminabbitt.wwwwwh.url;

import io.grpc.ServerBuilder;
import io.grpc.services.HealthStatusManager;
import io.micronaut.context.event.BeanCreatedEvent;
import io.micronaut.context.event.BeanCreatedEventListener;

import javax.inject.Singleton;

@Singleton
public class ServerBuilderListener implements BeanCreatedEventListener<ServerBuilder<?>> {
    @Override
    public ServerBuilder<?> onCreated(BeanCreatedEvent<ServerBuilder<?>> event) {
        final ServerBuilder<?> builder = event.getBean();
        HealthStatusManager healthStatusManager = new HealthStatusManager();
        builder.addService(healthStatusManager.getHealthService());
        builder.maxInboundMessageSize(1024);
        //TODO: set port
        return builder;
    }
}