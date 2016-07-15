package com.awa.test.server.server;

import com.awa.test.server.server.providers.JsonBodyWriter;
import com.google.inject.Singleton;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

public class ServerModule extends JerseyServletModule {

    @Override
    protected void configureServlets() {
        bind(JsonBodyWriter.class).in(Singleton.class);

        serve("/*").with(GuiceContainer.class);
    }
}
