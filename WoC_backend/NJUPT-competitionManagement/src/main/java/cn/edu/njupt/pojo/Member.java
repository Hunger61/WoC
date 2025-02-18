package cn.edu.njupt.pojo;

import lombok.Data;

@Data
public class Member {
    private Long id;
    private String name;
    private String studentId;
    private Long teamId;
    private Long academyId;
    private String phone;
    private Integer isCaptain;
}
