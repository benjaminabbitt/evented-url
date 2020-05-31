package name.benjaminabbitt.evented.server;

import java.io.File;

import static org.apache.logging.log4j.core.tools.picocli.CommandLine.*;

public class CLIOptions {
    @Option(names = {"-f", "--configuration-file"}, paramLabel = "CONFIG_FILE", description = "configuration file")
    File configFile;

    @Option(names = {"-c", "--consul"}, paramLabel = "CONSUL_HOST", description = "consul host")
    String consulHost;

    @Option(names = {"-m", "--config-mode"}, paramLabel = "CONFIGURATION_MODE", description = "configuration mode.  \"consul\" or \"file\"")
    String configMode;
}
