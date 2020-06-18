package name.benjaminabbitt.wwwwwh.url;

import io.grpc.ServerBuilder;
import io.micronaut.context.annotation.Property;
import io.micronaut.context.event.BeanCreatedEvent;
import io.micronaut.context.event.BeanCreatedEventListener;

import javax.inject.Singleton;

@Singleton
public class ServerBuilderListener implements BeanCreatedEventListener<ServerBuilder<?>> {
    @Property(name="foo")
    protected String foo;

    @Override
    public ServerBuilder<?> onCreated(BeanCreatedEvent<ServerBuilder<?>> event) {
        final ServerBuilder<?> builder = event.getBean();
        builder.maxInboundMessageSize(1024);

        return builder;
    }
}