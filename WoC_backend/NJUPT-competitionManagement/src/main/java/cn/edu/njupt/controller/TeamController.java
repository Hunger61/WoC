package cn.edu.njupt.controller;


import cn.edu.njupt.response.GlobalResponse;
import cn.edu.njupt.pojo.Team;
import cn.edu.njupt.service.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class TeamController {


    @Autowired
    private TeamService teamService;

//    获取队伍信息
    @GetMapping("/captain/team")
    public GlobalResponse getTeammsg() {
        log.info("获取队伍信息（队长）");
        return GlobalResponse.success(teamService.getTeammsg());
    }

//    获取队伍列表，通过可选的query参数
    @GetMapping("/academy/team")
    public GlobalResponse getTeamList(@RequestParam(required = false)Integer comId) {
        if (comId != null) {
            log.info("获取队伍列表（学院）,查询参数{}", comId);
            return GlobalResponse.success(teamService.getTeamList(comId));
        }
        log.info("获取队伍列表（学院）,无参数");
        return GlobalResponse.success(teamService.getTeamList());
    }
//    更新队伍信息
    @PostMapping("/captain/team")
    public GlobalResponse updateTeam(@RequestBody Team team) {
        log.info("更新队伍信息，team{}", team);
        return GlobalResponse.success(teamService.updateTeam(team));
    }

}
