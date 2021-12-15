package com.ivyaz.env.endpoint.issue;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.MediaType;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import jakarta.inject.Inject;

import java.util.Map;

@MicronautTest
class EnvEndpointIssueTest {

    @Inject
    EmbeddedServer server;

    @Inject
    @Client("/")
    HttpClient client;

    @Inject
    ObjectMapper mapper;

    @Test
    void testItWorks() throws Exception {

        Map<String, String> loginResult = client.toBlocking().exchange(HttpRequest.POST("login", "{\n" +
                "  \"username\": \"user\",\n" +
                "  \"password\": \"password\"\n" +
                "}").contentType(MediaType.APPLICATION_JSON_TYPE), Map.class).body();
        Map<String, String> result = client.toBlocking().exchange(HttpRequest.GET("env").bearerAuth(loginResult.get("access_token")), Map.class).body();
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(result));
        Assertions.assertTrue(result.isEmpty());
    }

}
