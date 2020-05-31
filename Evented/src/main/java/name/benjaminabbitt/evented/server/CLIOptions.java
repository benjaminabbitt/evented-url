package name.benjaminabbitt.evented.server;

import picocli.CommandLine;

import java.io.File;


public class CLIOptions {
    @CommandLine.Option(names = {"-f", "--configuration-file"}, paramLabel = "CONFIG_FILE", description = "configuration file")
    File configFile;

    @CommandLine.Option(names = {"-c", "--consul"}, paramLabel = "CONSUL_HOST", description = "consul host")
    String consulHost;

    @CommandLine.Option(names = {"-m", "--config-mode"}, paramLabel = "CONFIGURATION_MODE", description = "configuration mode.  \"consul\" or \"file\"")
    String configMode;
}
