package cn.edu.njupt.mapper;

import cn.edu.njupt.pojo.Team;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface TeamMapper {

//    查询团队信息
    @Select("select id,comId,name,captainId,captainName,status,memberIds,instructorIds from team")
    Team getTeammsg();

    @Select("select id,comId,name,captainId,captainName,status,memberIds,instructorIds from team where comId = #{comId}")
    Team getTeamList(@Param("comId") Integer comId);

//    更新团队信息
    @Update("update team set comId = #{comId},name = #{name},captainId = #{captainId},captainName = #{captainName},status = #{status},memberIds = #{memberIds},instructorIds = #{instructorIds},createTime = #{createTime} where id = #{id}")
    void updateTeam(Team team);
}
