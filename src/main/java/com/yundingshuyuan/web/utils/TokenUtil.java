package com.yundingshuyuan.web.utils;

import com.yundingshuyuan.web.web.authentication.domain.Users;
import com.yundingshuyuan.web.web.homeworkSubmit.entities.User;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * jwt风格的token
 *
 * @Author cr
 * @Date 2023/7/22 15:10
 */
@Slf4j
@Component
public class TokenUtil {

    private static long time = 1000*60*60*24;
    private static String signature = "GKTbh65jgfY";

    public static String createToken(Users user){

        JwtBuilder jwtBuilder = Jwts.builder();
        String jwToken = jwtBuilder
                //header
                .setHeaderParam("typ","JWT")
                .setHeaderParam("alg","HS256")
                //payload
                .claim("userId",user.getUser_id())
                .claim("name",user.getName())
                //有效期
                .setExpiration(new Date(System.currentTimeMillis() + time))
                //signature签名
                .signWith(SignatureAlgorithm.HS256,signature)
                //拼接
                .compact();
        return jwToken;
    }



    public static boolean checkToken(String token){
        if (token == null || "".equals(token)){
            //抛出异常
        }
        try {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(signature).parseClaimsJws(token);
        }catch (Exception e){
            log.error("token解密异常");
            e.printStackTrace();
            return false;
        }
        return true;

    }


}
