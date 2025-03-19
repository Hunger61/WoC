package cn.edu.njupt.filter;

import cn.edu.njupt.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = "/*")
public class TokenFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //        1.获取请求路径
        String uri = request.getRequestURI();
        //        2.判断是否是登录请求
        if (uri.contains("login")) {
            log.info("登录请求，放行");
            filterChain.doFilter(request, response);
            return;
        }

        String token = null;
        //        3.获取token
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            token = authorizationHeader.substring(7); // 去除"Bearer "前缀
        }
        //        4.判断token是否存在
        if (token == null|| token.isEmpty()) {
            log.info("token为空，响应401状态码");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        //        5.若存在，校验token
        Claims claims =JwtUtils.decodeToken(token);
        if (claims == null) {
            log.info("token无效，响应401状态码");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        //        将角色信息放入request中，供controller层使用
        Integer role = (Integer) claims.get("role");
        request.setAttribute("userRole",role);
        //        6.通过放行
        filterChain.doFilter(request, response);
    }
}
