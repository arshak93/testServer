package com.awa.test.server;

import com.awa.test.server.rest.RestModule;
import com.awa.test.server.server.ServerModule;
import com.google.inject.AbstractModule;

public class ApplicationModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new ServerModule());
        install(new RestModule());
    }
}
