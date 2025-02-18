package cn.edu.njupt.service.impl;

import cn.edu.njupt.mapper.MemberMapper;
import cn.edu.njupt.pojo.FindMember;
import cn.edu.njupt.pojo.Member;
import cn.edu.njupt.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {


    @Autowired
    private MemberMapper memberMapper;
    @Override
    public List<FindMember> find(Integer teamId) {
        return memberMapper.find(teamId);
    }

    @Override
    public void delete(Integer teamId, Integer id) {
        memberMapper.delete(teamId,id);
    }

    @Override
    public void add(Member member) {
        memberMapper.add(member);
    }
}
