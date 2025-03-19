package cn.edu.njupt.service.impl;

import cn.edu.njupt.mapper.UserMapper;
import cn.edu.njupt.pojo.User;
import cn.edu.njupt.service.UserService;
import cn.edu.njupt.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j


public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public User login(User user) {

        User u = userMapper.SelectByUserCodeAndPassword(user);
        if (u != null){
            log.info("登录成功");
//            生成jtw令牌
            Map<String, Object> claims = new HashMap<>();
            claims.put("userCode", u.getUserCode());
            claims.put("password", u.getPassword());
            String jwt = JwtUtils.generateToken(claims);
            return new User(jwt);
        }
        return null;


    }
}
