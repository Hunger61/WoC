package cn.edu.njupt.controller;

import cn.edu.njupt.annotation.RequireRole;
import cn.edu.njupt.common.enums.ErrorEnum;
import cn.edu.njupt.exception.BusinessException;
import cn.edu.njupt.pojo.Member;
import cn.edu.njupt.response.GlobalResponse;
import cn.edu.njupt.pojo.FindMember;
import cn.edu.njupt.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@Slf4j
@RestController
@RequestMapping("/captain/team/{teamId}/member")
public class MemberController {

    @Autowired
    private MemberService memberService;


    //获取成员列表
    @GetMapping
    @RequireRole(role = 0)
    public List<FindMember> list(@Valid @PathVariable("teamId") String TeamId) {
        Integer teamId = Integer.parseInt(TeamId);
        log.info("获取成员列表，团队ID:{}", teamId);
        return memberService.find(teamId);
    }


    // 删除成员
    @DeleteMapping
    @RequireRole(role = 0)
    public void delete(@Valid @RequestBody Member member) {
        Integer id = Math.toIntExact(member.getId());
        log.info("删除成员ID:{}",id);
        memberService.delete(id);
    }

//    添加成员
    @PostMapping
    @RequireRole(role = 0)
    public void add(@RequestBody Member member) {
        log.info("添加成员：{}", member);
        memberService.add(member);
    }


////    根据id查询成员具体信息
//    @GetMapping
//    public GlobalResponse getInfo(@RequestParam("id") Integer id) {
//        log.info("修改成员信息，id:" + id);
//        Member member = memberService.getInfo(id);
//        return GlobalResponse.success(member);
//    }

//    修改成员信息

    @PatchMapping
    @RequireRole(role = 0)
    public void update(@RequestBody Member member) {
        log.info("修改成员信息：{}", member);
        memberService.update(member);
    }
}
