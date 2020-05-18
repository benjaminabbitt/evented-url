package name.benjaminabbitt.evented.BusinessLogic;

import java.io.File;

import static org.apache.logging.log4j.core.tools.picocli.CommandLine.*;

public class CLIOptions {
    @Option(names = {"-f", "--configuration-file"}, paramLabel = "CONFIG_FILE", description = "configuration file")
    File config;

    @Option(names = {"-c", "--consul"}, paramLabel = "CONSUL_HOST", description = "consul host")
    String consulHost;
}
