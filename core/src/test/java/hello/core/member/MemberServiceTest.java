package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }
//    MemberService memberService = new MemberServiceImpl();

    // service 가입 부분 테스트
    @Test
    void join(){
        //given 이러한 환경이 주어 졌을 때
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        //then 가입한 join한 member와 찾은 member가 같느냐?
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
