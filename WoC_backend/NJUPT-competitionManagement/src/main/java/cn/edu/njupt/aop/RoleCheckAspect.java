package cn.edu.njupt.aop;


import cn.edu.njupt.annotation.RequireRole;
import cn.edu.njupt.common.enums.ErrorEnum;
import cn.edu.njupt.exception.BusinessException;
import jakarta.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class RoleCheckAspect {

    @Before("execution(* cn.edu.njupt.controller.*.*(..))")
    public void defaultCheckRole(JoinPoint joinPoint){
        //默认为超级管理员role=3
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        int userRole = (Integer) request.getAttribute("userRole");
        if (userRole != 3){
            throw new BusinessException(ErrorEnum.PERMISSION_ERROR);
        }
    }

    @Before("@annotation(cn.edu.njupt.annotation.RequireRole)")
    public void checkRole(JoinPoint joinPoint){


        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

//        获取角色要求
        RequireRole requireRole = signature.getMethod().getAnnotation(RequireRole.class);
//        获取用户角色
        int userRole = (Integer)request.getAttribute("userRole");

//        校验权限
        if (userRole != requireRole.role()){
            throw new BusinessException(ErrorEnum.PERMISSION_ERROR);
        }


    }
}
