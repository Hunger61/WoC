package cn.edu.njupt.pojo;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class Competition {
    private Long id;
    private String name;
    private String description;
    private Integer minTeamMembers;
    private Integer maxTeamMembers;
    /**
     * 活动负责⼈学⼯号
     */
    private String workCode;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private LocalDateTime reviewBeginTime;
    private LocalDateTime reviewEndTime;
    private LocalDateTime createTime;
}

