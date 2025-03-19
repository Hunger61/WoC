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


//    根据id删除团队成员
    @Delete("delete from member where id = #{id}")
    void delete(@Param("id") Integer id);

//    新增成员
    @Insert("insert into member(id,name,studentId,teamId,academyId,phone,isCaptain) values(#{id},#{name},#{studentId},#{teamId},#{academyId},#{phone},#{isCaptain})")
    void add(Member member);


////    查询成员具体信息
//    @Select("select id,name,studentId,teamId,academyId,phone,isCaptain from member where id = #{id}")
//    Member getInfo(@Param("id") Integer id);


//    更新成员信息
    @Update("update member set name = #{name},studentId = #{studentId},teamId = #{teamId},academyId = #{academyId},phone = #{phone},isCaptain = #{isCaptain} where id = #{id}")
    void update(Member member);

//    通过id查询成员
    @Select("select count(1) from member where id = #{id}")
    int findById(Integer id);

//    通过学号查询成员
    @Select("select count(1) from member where studentId = #{studentId}")
    int findByStudentId(String studentId);


}

