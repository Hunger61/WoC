package cn.edu.njupt.pojo;

import lombok.Data;

@Data
public class MemberIdRequest {
    private Integer id;
    public Integer getId() {
        return id;
    }
}
