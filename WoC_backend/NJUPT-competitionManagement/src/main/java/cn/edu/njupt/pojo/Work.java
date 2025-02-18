package cn.edu.njupt.pojo;

import lombok.Data;

@Data
public class Work {
    private Long id;
    private String name;
    private Long teamId;
    private String captainStudentId;
}
