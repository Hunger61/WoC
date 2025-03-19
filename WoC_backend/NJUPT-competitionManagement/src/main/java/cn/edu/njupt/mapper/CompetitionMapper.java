package cn.edu.njupt.mapper;


import cn.edu.njupt.pojo.Competition;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CompetitionMapper {

    @Insert("insert into competition(id,name,description,minTeamMembers,maxTeamMembers,workCode,startTime,endTime,reviewBeginTime,reviewEndTime,createTime) values(#{id},#{name},#{description},#{minTeamMembers},#{maxTeamMembers},#{workCode},#{startTime},#{endTime},#{reviewBeginTime},#{reviewEndTime},#{createTime})")
    void CreatCompetition(Competition competition);

    @Select("select id,name,description,minTeamMembers,maxTeamMembers,workCode,startTime,endTime,reviewBeginTime,reviewEndTime,createTime from competition")
    List<Competition> getCompetitionList();
}
