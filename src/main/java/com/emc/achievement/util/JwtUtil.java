package com.emc.achievement.util;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;


import java.util.Date;
import java.util.HashMap;

/**
*@author: hxq
*@date: 2020/10/7 下午4:34
*@description: token工具类
*/
@Slf4j
public class JwtUtil {

    // 过期时间一天
    private static final long EXPIRE_TIME = 24*60*60*1000;
    public static final String HEADER = "Authorization";
    private static final String JWT_SECRET_KEY = "secret";

    /**
    *@author: hxq
    *@date: 2020/10/7 下午4:35
    *@description: 根据工号和权限生成token
    */
    public static String createToken(String username,String authority){
        Date date = new Date(System.currentTimeMillis()+EXPIRE_TIME);
        Algorithm algorithm = Algorithm.HMAC256(JWT_SECRET_KEY);
        HashMap<String,Object> header = new HashMap<>();
        header.put("typ",new String("JWT"));
        header.put("alg", new String("HS256"));
        return JWT.create()
                .withHeader(header)
                .withClaim("username", username)
                .withClaim("authority", authority)
                .withExpiresAt(date)
                .sign(algorithm);
    }

    /**
     *@author: hxq
     *@date: 2020/10/7 下午4:23
     *@description: 校验token
     */
    public static boolean verity(String token){
        Algorithm algorithm = Algorithm.HMAC256(JWT_SECRET_KEY);
        JWTVerifier verifier = JWT.require(algorithm).build();
        verifier.verify(token);
        return true;
    }

    /**
    *@author: hxq
    *@date: 2020/10/7 下午4:36
    *@description: 检查token是否过期
    */
    public static boolean isExpired(String token){
        DecodedJWT jwt = JWT.decode(token);
        Date date = jwt.getExpiresAt();
        return date.before(new Date());
    }

    /**
    *@author: hxq
    *@date: 2020/10/7 下午4:36
    *@description: 获取当前用户权限
    */
    public static String getAuthority(String token){
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getClaim("authority").asString();
    }
}
