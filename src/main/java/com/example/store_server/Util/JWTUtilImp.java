package com.example.store_server.Util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.store_server.Pojo.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.Calendar;

@Service
public class JWTUtilImp implements JWTUtil {

    @Value("${jwt.secret}")
    private String secret;

    @Override
    public String createToken(User user) {
        Calendar date = Calendar.getInstance();
        date.add(Calendar.DATE,7);
        JWTCreator.Builder builder = JWT.create();

        builder.withClaim("id",user.getId());
        builder.withClaim("password",user.getPassword());
        ///根据有效日期和私钥生成token 算法HMAC256
        String token = builder.withExpiresAt(date.getTime()).sign(Algorithm.HMAC256(secret));
        return token;
    }

    @Override
    public DecodedJWT verifyToken(String token) {
        return JWT.require(Algorithm.HMAC256(token)).build().verify(token);
    }
}
