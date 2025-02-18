package cn.edu.njupt.controller;

import cn.edu.njupt.pojo.Member;
import cn.edu.njupt.pojo.MemberIdRequest;
import cn.edu.njupt.pojo.Result;
import cn.edu.njupt.pojo.FindMember;
import cn.edu.njupt.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;


    //获取成员列表
    @GetMapping(value = "/captain/team/{teamId}/member",produces = {MediaType.APPLICATION_JSON_VALUE ,MediaType.APPLICATION_XML_VALUE})
    public Result list(@PathVariable("teamId") String TeamId) {
        Integer teamId = Integer.parseInt(TeamId);
        System.out.println("获取成员列表，团队ID:" + teamId);
        List<FindMember> memberList = memberService.find(teamId);
        return Result.success(memberList);
    }

    // 删除成员
    @DeleteMapping(value = "/captain/team/{teamId}/member", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result delete(@PathVariable("teamId") String TeamId, @RequestBody MemberIdRequest memberIdRequest) {
        Integer teamId = Integer.parseInt(TeamId);
        Integer id = memberIdRequest.getId();
        System.out.println("删除成员，团队ID:" + teamId + " 成员ID:" + id);
        memberService.delete(teamId, id);
        return Result.success();
    }

//    添加成员
    @PostMapping(value = "/captain/team/{teamId}/member", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result add(@PathVariable("teamId") String TeamId, @RequestBody Member member) {
//        Integer teamId = Integer.parseInt(TeamId);
        System.out.println("添加成员");
        memberService.add(member);
        return Result.success();
    }


//    根据id查询成员
    @GetMapping(value = "/team/{teamId}/member", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result getInfo(@PathVariable("teamId") String TeamId) {
//        Integer teamId = Integer.parseInt(TeamId);
        System.out.println("根据id查询成员");
        FindMember member = memberService.find(TeamId);
        return Result.success(member);
    }
}
