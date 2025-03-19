package cn.edu.njupt.service;


import cn.edu.njupt.pojo.Competition;

import java.util.List;

public interface CompetitionService {
    void CreatCompetition(Competition competition);

    List<Competition> getCompetitionList();
}
