package name.benjaminabbitt.evented.server;

import org.cfg4j.provider.ConfigurationProvider;
import org.cfg4j.provider.ConfigurationProviderBuilder;
import org.cfg4j.source.ConfigurationSource;
import org.cfg4j.source.consul.ConsulConfigurationSourceBuilder;
import org.cfg4j.source.context.filesprovider.ConfigFilesProvider;
import org.cfg4j.source.files.FilesConfigurationSource;

import java.nio.file.Paths;
import java.util.Arrays;

public class EventedConfigSetup {
    public static EventedConfig setupConfiguration(CLIOptions options) {
        ConfigurationSource source = null;
        if (options.configMode.equalsIgnoreCase("file")) {
            ConfigFilesProvider provider = () -> Arrays.asList(Paths.get("application.yaml"));
            source = new FilesConfigurationSource(provider);
        } else if (options.configMode.equalsIgnoreCase("consul")) {
            String host = options.consulHost;
            if (host != null) {
                String[] split = options.consulHost.split(".*:.*");
                source = new ConsulConfigurationSourceBuilder()
                        .withHost(split[0])
                        .withPort(Integer.parseInt(split[1]))
                        .build();
            } else {
                source = new ConsulConfigurationSourceBuilder().build();
            }
        }
        ConfigurationProvider configurationProvider = new ConfigurationProviderBuilder()
                .withConfigurationSource(source)
                .build();

        return configurationProvider.bind("evented", EventedConfig.class);
    }


}
