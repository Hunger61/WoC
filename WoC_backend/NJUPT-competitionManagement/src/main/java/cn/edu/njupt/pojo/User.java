package cn.edu.njupt.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Getter
    private String userCode;
    @Getter
    private String password;
    private String name;
    private Long academyId;
    /**
     * 超级管理员可以设置为null或者默认值
     */
    private Long comId;
    /**
     * 0- Captain
     * 1- Judge
     * 2- AcademyAdmin
     * 3- SuperAdmin
     */
    private Integer role;
    private  String token;

    public User(String jwt) {
        this.token = jwt;
    }


}
