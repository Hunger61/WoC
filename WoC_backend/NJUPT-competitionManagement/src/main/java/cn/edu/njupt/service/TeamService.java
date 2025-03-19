package cn.edu.njupt.service;

import cn.edu.njupt.pojo.Team;

public interface TeamService {
    Team getTeammsg();

    Team getTeamList(Integer comId);
    Team getTeamList();

    Team updateTeam(Team team);
}
