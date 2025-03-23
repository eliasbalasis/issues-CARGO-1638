package net.upperlimit.issues.CARGO_1638;

import org.codehaus.cargo.container.configuration.LocalConfiguration;

public class CustomJetty12xEmbeddedLocalContainer extends org.codehaus.cargo.container.jetty.Jetty12xEmbeddedLocalContainer {

	@Override
	protected synchronized String getVersion() {

		return org.eclipse.jetty.server.Server.getVersion() + " Embedded (ee10)";
	}

	public CustomJetty12xEmbeddedLocalContainer(final LocalConfiguration configuration) {

		super(configuration);
	}
}
