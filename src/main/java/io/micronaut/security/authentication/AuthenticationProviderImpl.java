package io.micronaut.security.authentication;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.BlockingHttpClient;
import jakarta.inject.Singleton;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;

@Singleton
public class AuthenticationProviderImpl implements AuthenticationProvider {

    @Override
    public Publisher<AuthenticationResponse> authenticate(HttpRequest<?> httpRequest, AuthenticationRequest<?, ?> authenticationRequest) {
        return Mono.fromCallable(() -> {
            if (authenticationRequest.getIdentity().equals("user") && authenticationRequest.getSecret().equals("password")) {
                return AuthenticationResponse.success("user");
            } else {
                throw AuthenticationResponse.exception();
            }
        });
    }
}
