package com.example.newsApiGateway.security;

import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Component
public class AuthorizationFilter extends AbstractGatewayFilterFactory<AuthorizationFilter.Config> {

    @Value("${jwt.secret}")
    private String secret;

    public AuthorizationFilter()
    {
        super(Config.class);
    }
    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) ->{

            ServerHttpRequest request =  exchange.getRequest();

            if(!request.getHeaders().containsKey(HttpHeaders.AUTHORIZATION))
            {
                return onError(exchange,"No Authorization Header",HttpStatus.UNAUTHORIZED);
            }
            String authHeader = request.getHeaders().get(AUTHORIZATION).get(0);
            String token = authHeader.substring("Bearer ".length());
            if(!validateToken(token))
            {
                return onError(exchange,"No Authorization Header",HttpStatus.UNAUTHORIZED);
            }
            return chain.filter(exchange);
        };
    }

    private Mono<Void> onError(ServerWebExchange exchange, String err, HttpStatus httpStatus)
    {
        ServerHttpResponse response=exchange.getResponse();
        response.setStatusCode(httpStatus);
        return response.setComplete();
    }

    public Boolean validateToken(String token) {
        String subject = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
        if(subject == null || subject.isEmpty())
            return false;
        return true;
    }

    public static class Config
    {

    }
}
