package cn.edu.njupt.controller;

import cn.edu.njupt.pojo.Competition;
import cn.edu.njupt.response.GlobalResponse;
import cn.edu.njupt.service.CompetitionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Slf4j
@RestController

public class CompetitionController {

    @Autowired
    private CompetitionService competitionService;


//    创建比赛
    @PostMapping("/admin/competition")
    public GlobalResponse CreatCompetition(@RequestBody Competition competition) {
        log.info("创建比赛");
        competitionService.CreatCompetition(competition);

//        设置时间为当前时间
        competition.setCreateTime(LocalDateTime.now());

        return GlobalResponse.success(competition);
    }

//    获取比赛列表
    @GetMapping("/competitions")
    public GlobalResponse getCompetitionList() {
        log.info("获取比赛列表");
        return GlobalResponse.success(competitionService.getCompetitionList());
    }
}
