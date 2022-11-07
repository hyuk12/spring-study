package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class SingletoneTest {

    /*
        singleton 을 쓰는 이유는 만약에 클라이언트가 여러명이고
        그 여러명이 한가지의 같은 service 를 요청을 하게 되면
        앞에 짰던 코드는 appConfig 에서 서비스 요청을 받을 때마다
        새로운 객체를 생성하게 된다
        그렇게 되면 한명이 요청할 때마다 계속 객체를 생성해야 하기 때문에 비효율적이다.

        클래스의 인스턴스가 딱 1개만 생성되는 것을 보장하는 디자인 패턴
        객체- 인스턴스를 2개이상 생성하지 못하도록 막는다
        private 생성자를 이용해서 임의로 new하지 못하게한다.
     */
    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer(){
        AppConfig appConfig = new AppConfig();

        //1.  조회: 호출할 때 마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();

        //2.  조회: 호출할 때 마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();

        // 참조값이 다른것을 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        // memberService1 != memberService2
        assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest(){
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("singletonService1 = " + singletonService1 );
        System.out.println("singletonService2 = " + singletonService2 );
        assertThat(singletonService1).isSameAs(singletonService2);
        // same > ==
        // equal > equals
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer(){
//        AppConfig appConfig = new AppConfig();

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        // 참조값이 다른것을 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        // memberService1 == memberService2
        assertThat(memberService1).isSameAs(memberService2);
    }
}
