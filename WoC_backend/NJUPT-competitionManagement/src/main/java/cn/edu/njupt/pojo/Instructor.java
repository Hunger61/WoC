package cn.edu.njupt.pojo;

import lombok.Data;

@Data
public class Instructor {
    private Long id;
    private String name;
    private String workCode;// ⼯号
    private Long teamId;
    private Long academyId;
    private String phone;

}
