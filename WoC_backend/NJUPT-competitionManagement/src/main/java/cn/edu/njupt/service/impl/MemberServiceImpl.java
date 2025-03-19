package cn.edu.njupt.service.impl;

import cn.edu.njupt.common.enums.ErrorEnum;
import cn.edu.njupt.exception.BusinessException;
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
    public void delete(Integer id) {
        // 检查成员是否存在
        if (memberMapper.findById(id) == 0) {
            throw new BusinessException(ErrorEnum.MEMBER_NOT_FOUND);
        }
        memberMapper.delete(id);
    }

    @Override
    public void add(Member member) {
//        检查学号是否重复
        if (memberMapper.findByStudentId(member.getStudentId()) ==0 ) {
            throw new BusinessException(ErrorEnum.DUPLICATE_STUDENT_ID);
        }

        // 检查队长标识是否合法
        if (member.getIsCaptain() != 0 && member.getIsCaptain() != 1) {
            throw new BusinessException(ErrorEnum.INVALID_ISCAPTAIN);
        }
        memberMapper.add(member);
    }

//    @Override
//    public Member getInfo(Integer id) {
//        return memberMapper.getInfo(id);
//    }

    @Override
    public void update(Member member) {
        if (memberMapper.findById(member.getId()) == 0) {
            throw new BusinessException(ErrorEnum.MEMBER_NOT_FOUND);
        }
        memberMapper.update(member);
    }
}
