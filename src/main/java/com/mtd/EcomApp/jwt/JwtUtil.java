package com.mtd.EcomApp.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.Claims;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {

    private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private static final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 hour

    // Generate JWT token with role
    public static String generateToken(String username, String role) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuer("MyApp")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .addClaims(Map.of("role", role))
                .signWith(SECRET_KEY)
                .compact();
    }

    // ✅ Corrected method name
    public static Map<String, Object> validateToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();

        Map<String, Object> claimMap = new HashMap<>();
        claimMap.put("sub", claims.getSubject());
        claimMap.put("role", claims.get("role"));
        return claimMap;
    }
}