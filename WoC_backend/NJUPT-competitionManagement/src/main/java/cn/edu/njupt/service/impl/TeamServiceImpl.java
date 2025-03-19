package cn.edu.njupt.service.impl;

import cn.edu.njupt.mapper.TeamMapper;
import cn.edu.njupt.pojo.Team;
import cn.edu.njupt.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service


public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamMapper TeamMapper;
    @Override
    public Team getTeammsg() {
        return TeamMapper.getTeammsg();
    }

    @Override
    public Team getTeamList(Integer comId) {
        return TeamMapper.getTeamList(comId);
    }

    @Override
    public Team getTeamList() {
        return TeamMapper.getTeammsg();
    }

    @Override
    public Team updateTeam(Team team) {
        TeamMapper.updateTeam(team);
        Team team1 = TeamMapper.getTeamList(team.getComId());
        team1.setCreateTime(team.getCreateTime());
        return team1;

    }
}
