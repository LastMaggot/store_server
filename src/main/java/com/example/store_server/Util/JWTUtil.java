package com.example.store_server.Util;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.store_server.Pojo.User;

public interface JWTUtil {

    /**
     *生成Token
     * @param user
     * @return
     */
    public String createToken(User user);

    /**
     * 验证Token
     * @param token
     * @return
     */
    public DecodedJWT verifyToken(String token);
}
