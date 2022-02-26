package com.example.studyBoot.controller;

import com.example.studyBoot.domain.Member;
import com.example.studyBoot.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

//@Controller를 읽어서 스프링 컨테이너가 관리를한다
@Controller
public class MemberController {
    // 이렇게 사용하는 것 보다
    // private final MemberService memberService = new MemberService();

    private final MemberService memberService;

    @Autowired  //스프링 컨테이너에서 memberService를 가져온다
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());
        memberService.join(member);

        System.out.println("member. = " + member.getName());

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members);

        return "/members/memberList";
    }

}

