package com.awa.test.server.rest.resources;

import com.awa.test.server.rest.response.TestResponse;

import javax.ws.rs.*;

@Path("/api/test")
public class TestResource {

    @GET
    public String getTest(@DefaultValue("World") @QueryParam("name") String name) {
        return "Hello " + name;
    }

    @GET
    @Path("test2")
    public TestResponse test2() {
        return new TestResponse();
    }

}