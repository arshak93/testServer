package com.awa.test.server;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceFilter;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class HelloServer {
    public static void main(String[] args) throws Exception
    {
        Injector injector = Guice.createInjector(new ApplicationModule());
        Server server = new Server(8888);
        /*ServletContextHandler handler = new ServletContextHandler(server, "/example");
        handler.addServlet(HelloWorldServlet.class, "/");*/

        ServletContextHandler handler = new ServletContextHandler();
        handler.addFilter(GuiceFilter.class, "/*", null);
        handler.addServlet(DefaultServlet.class, "/*");
        server.setHandler(handler);

        server.start();
        server.join();
    }
}