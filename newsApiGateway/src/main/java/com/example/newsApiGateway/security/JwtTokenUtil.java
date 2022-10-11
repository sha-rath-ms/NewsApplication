package com.example.newsApiGateway.security;

import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class JwtTokenUtil {
    public static final long JWT_TOKEN_VALIDITY = 5 * 60;

    @Value("${jwt.secret}")
    private String secret;

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

}
