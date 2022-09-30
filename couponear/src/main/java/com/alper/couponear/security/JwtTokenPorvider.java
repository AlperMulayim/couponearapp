package com.alper.couponear.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@AllArgsConstructor
public class JwtTokenPorvider {

    public String generate(String mail) {
        return Jwts.builder()
                .setSubject(mail)
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + (10 * 3600000)))
                .signWith(SignatureAlgorithm.HS512, "alperssecurity")
                .compact();
    }

    public boolean validate(String token){
        Jwts.parser().setSigningKey("alperssecurity").parseClaimsJws(token);
        return true;
    }

    public  String getEmailFromJwtToken(String token){
        return  Jwts.parser()
                .setSigningKey("alperssecurity")
                .parseClaimsJws(token)
                .getBody().getSubject();
    }
}
