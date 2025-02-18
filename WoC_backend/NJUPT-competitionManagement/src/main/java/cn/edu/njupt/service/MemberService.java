package cn.edu.njupt.service;

import cn.edu.njupt.pojo.FindMember;
import cn.edu.njupt.pojo.Member;

import java.util.List;

public interface MemberService {


//    查询成员信息
    List<FindMember> find(Integer teamId);
    void delete(Integer teamId,Integer id);
    void add(Member member);
}
