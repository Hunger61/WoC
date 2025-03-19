package cn.edu.njupt.service.impl;


import cn.edu.njupt.mapper.CompetitionMapper;
import cn.edu.njupt.pojo.Competition;
import cn.edu.njupt.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetitionServiceImpl implements CompetitionService {


    @Autowired
    private CompetitionMapper competitionMapper;
    @Override
    public void CreatCompetition(Competition competition) {
        competitionMapper.CreatCompetition(competition);
    }

    @Override
    public List<Competition> getCompetitionList() {
        return competitionMapper.getCompetitionList();
    }
}
