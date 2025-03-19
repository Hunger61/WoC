package cn.edu.njupt.utils;


import cn.edu.njupt.exception.BusinessException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import cn.edu.njupt.common.enums.ErrorEnum;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

@Slf4j
public class JwtUtils {

    @Value("${jwt.secret-key}")
    public static final String SECRET_KEY;//密钥
    public static final long EXPIRATION_TIME = 86400000;//过期时间24小时


    //    生成JWT令牌
    public static String generateToken(Map<String, Object> claims) {
        SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
        return Jwts.builder()
                .claims(claims)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key)
                .compact();
    }

//    解码JWT令牌
    public static Claims decodeToken(String token) {
        SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
        try {
            return Jwts.parser()
                    .verifyWith(key)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
        } catch (io.jsonwebtoken.security.SecurityException e) {
            log.error("无效签名，token被篡改");
            throw new BusinessException(ErrorEnum.TOKEN_SIGNATURE_ERROR);
        } catch (io.jsonwebtoken.ExpiredJwtException e) {
            log.error("token已过期");
            throw new BusinessException(ErrorEnum.TOKEN_EXPIRED);
        } catch (Exception e) {
            log.error("其他解码异常：" + e.getMessage());
            throw new BusinessException(ErrorEnum.TOKEN_DECODE_ERROR);
        }
    }
}
