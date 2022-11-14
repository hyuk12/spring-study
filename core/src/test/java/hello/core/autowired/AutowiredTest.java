package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption(){
     ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean{

        // 메서드 자체가 호출이 안된다 (주입대상이 없으면)
        @Autowired(required = false)
        public void setNoBean1(Member noBean1){
            System.out.println("noBean1: " + noBean1);
        }
        // 주입대상이 없으면 호출은 되나 null 로 나온다.
        @Autowired
        public void setNoBean2(@Nullable Member noBean2){
            System.out.println("noBean2: " + noBean2);
        }
        // Optional.empty 로 호출된다.
        @Autowired
        public void setNoBean3(Optional<Member>  noBean3){
            System.out.println("noBean3: " + noBean3);
        }
    }
    // Nullable 과 Optional 은 스프링 전반에서 사용이 가능하다.
}
