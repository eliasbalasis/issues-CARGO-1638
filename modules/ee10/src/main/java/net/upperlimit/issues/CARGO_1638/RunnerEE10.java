package net.upperlimit.issues.CARGO_1638;

import java.nio.file.Files;
import java.nio.file.Path;

import org.codehaus.cargo.container.jetty.Jetty12xEmbeddedLocalContainer;
import org.codehaus.cargo.container.jetty.Jetty12xEmbeddedStandaloneLocalConfiguration;
import org.codehaus.cargo.container.jetty.JettyPropertySet;
import org.codehaus.cargo.container.property.ServletPropertySet;
import org.codehaus.cargo.util.log.LogLevel;
import org.codehaus.cargo.util.log.Logger;
import org.codehaus.cargo.util.log.SimpleLogger;

public class RunnerEE10 {

	public static void main(String[] args) throws Exception {

		final Path dir = Files.createTempDirectory("upperlimit-issues-CARGO-1638-");
		dir.toFile().deleteOnExit();

		final Jetty12xEmbeddedStandaloneLocalConfiguration configuration = //
				new Jetty12xEmbeddedStandaloneLocalConfiguration( //
						dir.toString() //
				);
		configuration.setProperty( //
				ServletPropertySet.PORT, //
				String.valueOf(8888) //
		);
		configuration.setProperty( //
				JettyPropertySet.USE_FILE_MAPPED_BUFFER, //
				String.valueOf(false) //
		);
		configuration.setProperty( //
				JettyPropertySet.DEPLOYER_EE_VERSION, //
				"ee10" //
		);

		final Jetty12xEmbeddedLocalContainer container = //
				new Jetty12xEmbeddedLocalContainer( //
						configuration //
				);
		final Logger containerLogger = new SimpleLogger();
		containerLogger.setLevel(LogLevel.DEBUG);
		container.setLogger(containerLogger);
		container.start();
	}
}
