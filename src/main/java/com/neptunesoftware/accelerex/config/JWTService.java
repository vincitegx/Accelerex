
package com.neptunesoftware.accelerex.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.neptunesoftware.accelerex.exception.CustomException;
import com.neptunesoftware.accelerex.exception.ValidationException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
//import org.springframework.security.core.userdetails.UserDetails;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.time.Instant;
import java.util.*;
import java.util.function.Function;

@Service
@Data
@Log4j2
public class JWTService {
    private static final String SECRET_KEY = "DEC897856524D80723AC9FE48DDEDA830F8F40C8FC77BDBA1E81A2B88F5A41F0";

    @Value("${jwt.expiration.time}")
    private Long jwtExpirationInMillis;

    @Value("${jwt.secret}")
    private String secret;

    public String generateJwtToken(Authentication authentication) {
        try{
            User principal = (User) authentication.getPrincipal();
            return JWT.create()
                    .withSubject(principal.getUsername())
                    .withExpiresAt(Date.from(Instant.now().plusMillis(jwtExpirationInMillis)))
                    .withIssuer("ACCELEREX")
                    .withIssuedAt(Date.from(Instant.now()))
                    .withClaim("roles", principal.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList())
                    .sign(Algorithm.HMAC256(secret.getBytes()));
        }catch (JWTCreationException | IllegalArgumentException ex){
            throw new CustomException(ex.getMessage());
        }
    }

    public boolean validateToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(secret.getBytes());
        JWTVerifier verifier = JWT.require(algorithm).withIssuer("ACCELEREX").build();
        try {
            DecodedJWT decodedJWT = verifier.verify(token);
            String email = decodedJWT.getSubject();
            String[] roles = decodedJWT.getClaim("roles").asArray(String.class);
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            Arrays.stream(roles).forEach(role -> authorities.add(new SimpleGrantedAuthority(role)));
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, null, authorities);
//            Authentication authentication2 = SecurityContextHolder.getContext().getAuthentication();
            if (authentication.isAuthenticated()) {
                SecurityContextHolder.getContext().setAuthentication(authentication);
                return true;
            } else {
                SecurityContextHolder.clearContext();
                authentication.setAuthenticated(false);
                return false;
            }
        } catch (JWTVerificationException e) {
            log.info("Invalid token passed");
            throw new ValidationException("This token is invalid !!!");
        }
    }
    public String extractUsername(String token) {

        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public Integer extractUserIdFromToken(String token){
        return extractAllClaims(trimTokenOfBearerText(token)).get("userId", Integer.class);
    }

    private String trimTokenOfBearerText(String token){
        return  token.substring(7);
    }

    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }

    public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
