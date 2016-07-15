package com.awa.test.server.rest;

import com.awa.test.server.rest.resources.*;
import com.google.inject.AbstractModule;

public class RestModule extends AbstractModule{


    @Override
    protected void configure() {
        bind(TestResource.class);
    }
}
