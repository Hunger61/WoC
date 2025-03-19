package cn.edu.njupt.controller;

import cn.edu.njupt.common.enums.ErrorEnum;
import cn.edu.njupt.response.GlobalResponse;
import cn.edu.njupt.pojo.User;
import cn.edu.njupt.service.UserService;
import cn.edu.njupt.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController

public class LoginController {


    @Autowired
    private UserService userService;

    // LoginController.java
    @PostMapping("/login")
    public GlobalResponse login(@RequestBody User user) {
        log.info("登录请求：{}", user);
        User user1 = userService.login(user);
        if (user1 == null) {
            return GlobalResponse.failure(ErrorEnum.LOGIN_ERROR); // 使用枚举错误码
        }

        // 生成JWT并添加角色信息
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", user1.getRole()); // 将角色信息放入claims
        String token = JwtUtils.generateToken(claims);
        user1.setToken(token);

        return GlobalResponse.success(user1);
    }
}
