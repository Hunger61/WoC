package cn.edu.njupt.pojo;
import javax.validation.constraints.*;

import lombok.Data;

@Data
public class Member {

    @NotNull(message = "id不能为空")
    private Long id;
    @NotBlank(message = "姓名不能为空")
    private String name;
    private String studentId;
    private Long teamId;
    private Long academyId;
    private String phone;
    private Integer isCaptain;
}
