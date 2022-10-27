package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/*
    스프링은 스프링 컨테이너에 스프링 빈을 등록할 때 , 기본으로 싱글톤으로 등록한다(유일하게 하나만 등록)
    같은 스프링 빈이면 모두 같은 인스턴스이다. 설정을 통해서 싱글톤이 아니게 할 수있는데 특별한 경우아니면 안쓴다.

 */


@Controller
public class MemberController {

    private final MemberService memberService ;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }
    @PostMapping(value = "/members/new")
    public String create(MemberForm memberForm){
        Member member = new Member();
        member.setName(memberForm.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }

}
