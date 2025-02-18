package cn.edu.njupt.mapper;


import cn.edu.njupt.pojo.FindMember;
import cn.edu.njupt.pojo.Member;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MemberMapper {
//    查询团队成员,按学号查询并排序


    @Select("select studentId,name,academyId from member where teamId = #{teamId}")
    @Results({
//            @Result(property = "studentId", column = "studentId"),
//            @Result(property = "name", column = "name"),
            @Result(property = "academy", column = "academyId")
    })
    List<FindMember> find(@Param("teamId") Integer teamId);


//    根据id和teamId删除团队成员
    @Delete("delete from member where id = #{id} and teamId = #{teamId}")
    void delete(@Param("id") Integer id, @Param("teamId") Integer teamId);

    @Insert("insert into member(id,name,studentId,teamId,academyId,phone,isCaptain) values(#{id},#{name},#{studentId},#{teamId},#{academyId},#{phone},#{isCaptain})")
    void add(Member member);
}
