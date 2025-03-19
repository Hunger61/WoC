package cn.edu.njupt.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
@Data
public class Team implements Serializable {
    private Long id;
    private Integer comId;
    private String name;
    private Long captainId;
    private String captainName;
    // 审核通过标识
    private Integer status;
    /**
     * 队员ID列表，包括队⻓
     * 可以考虑使⽤typeHandler
     * 可以参考：https://mybatis.org/mybatis-3/configuration.html#typeHandlers
     * https://juejin.cn/post/7196490153135751224
     */
    private List<Long> memberIds;
    private List<Long> instructorIds;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
}
