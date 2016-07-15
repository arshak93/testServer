package com.awa.test.server.rest.response;

public class TestResponse extends JsonResponse {

    public int testInt = 4;
    public String testString = "test";

    public TestResponse () {}

    public TestResponse (int testInt, String testString)
    {
        this.testInt = testInt;
        this.testString = testString;
    }
}
