//package cn.edu.njupt.pojo;
//
//import lombok.Data;
//
//@Data
//public class FindMember {
//    private String studentId;
//    private String name;
//    private Integer academy;
//}


package cn.edu.njupt.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FindMember {
    @JsonProperty("studentId")
    private String studentId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("academy")
    private String academy;
}
