package cn.edu.njupt.pojo;

import lombok.Data;

@Data
public class Score {
    private Long id;
    private String judgeId;
    private String workCode;
    private Long teamId;
    private Long comId;
    private Integer score;
    private String comment;
}
