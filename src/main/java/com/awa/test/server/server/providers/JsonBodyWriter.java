package com.awa.test.server.server.providers;

import com.awa.test.server.rest.response.JsonResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

@Provider
@Singleton
@Produces({MediaType.APPLICATION_JSON})
public class JsonBodyWriter implements MessageBodyWriter<JsonResponse> {

    private ObjectMapper objectMapper;

    @Inject
    public JsonBodyWriter() {
        objectMapper = new ObjectMapper();
    }

    @Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return JsonResponse.class.isAssignableFrom(type);
    }

    @Override
    public long getSize(JsonResponse jsonResponse, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return -1;
    }

    @Override
    public void writeTo(JsonResponse jsonResponse, Class<?> type, Type genericType,
                        Annotation[] annotations, MediaType mediaType,
                        MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream
    ) throws IOException {
        entityStream.write(objectMapper.writeValueAsBytes(jsonResponse));
    }
}
