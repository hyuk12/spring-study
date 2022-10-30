package hello.hellospring;

import hello.hellospring.repository.MemberRepository;

import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

// 어떤 서비스로 진행을 할지 정해준다 bean을 이용해서
@Configuration
public class SpringConfig  {
    private final MemberRepository memberRepository;

//    private final DataSource dataSource;
//    private final EntityManager em;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
//    public SpringConfig(MemberRepository memberRepository, DataSource dataSource, EntityManager em) {
//        this.memberRepository = memberRepository;
//        this.dataSource = dataSource;
//        this.em = em;
//    }
//    private final DataSource dataSource ;
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

    @Bean
    public MemberService memberService(){

        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository(){
//
////        return new MemoryMemberRepository();
////          return new JdbcMemberRepository(dataSource);
////            return new JdbcTemplateMemberRepository(dataSource);
////        return new JpaMemberRepository(em);
//
//    }

}
