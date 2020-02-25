package com.zy.microoffice.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.zy.microoffice.entity.UserEntity;
import org.springframework.stereotype.Service;

@Service("TokenService")
public class TokenServiceImpl  {
    public String getToken(UserEntity userEntity) {
        String token="";
        token= JWT.create().withAudience(String.valueOf(userEntity.getId()))
                .sign(Algorithm.HMAC256(userEntity.getPwd()));
        return token;
    }
}
