package hello.core.beanDefinition;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BeanDefinitionTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

//    GenericXmlApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");

    @Test
    @DisplayName("빈 설정 메타 정보 확인")
    void findApplicationBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for(String beanDefinitionName : beanDefinitionNames){
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                System.out.println("beanDefinitionName = " + beanDefinitionName +
                        "beadefinition" + beanDefinition);
            }
        }
    }

    /*
        BeanClassName : 생성할 빈의 클래스 명(자바 설정 처럼 팩토리 역할의 빈을 사용하면 없음)
        factoryBeanName: 팩토리 역할의 빈을 사용할 경우 이름, 예 ) appConfig
        factoryMethodName: 빈을 생성할 팩토리 메서드 지정, 예) memberService
        Scope: 싱글톤(기본값)
        lazyInit: 스프링 컨테이너를 생성할 때 빈을 생성하는 것이 아니라, 실제 빈을 사용할 때 까지 최대한 생성을 지연처리 하는지 여부
        InitMethodName: 빈을 생성하고, 의존관계를 적용한 뒤에 호출되는 초기화 메서드 명
        DestroyMethodName: 빈의 생명주기가 끝나서 제거하기 직전에 호출되는 메서드 명
        Constructor arguments, Properties: 의존관계 주입에서 사용한다.(자바 설정 처럼 팩토리 역할의 빈을 사용하면 없음)


        정리:
        beanDefinition 은 메타정보를 담고 있다 . 이 정보를 기반으로 만든다.
         - BeanDefinition 을 직접 생성해서 스프링 컨테이너에 등록할 수도 있다.
         하지만 실무에서 BeanDefinition 을 직접 정의하거나 사용할 일은 없다.
         - BeanDefinition 에 대해서는 너무 깊이 있게 이해하기 보다는, 스프링이 다양한 형태의 설정 정보를 BeanDefinition 으로
         추상화 해서 사용하는 것 정도만 이해하자
         - 가끔 스프링 코드나 스프링 관련 오픈 소스의 코드를 볼 때, BeanDefinition 이라는 것이 보일 때가 있다.
         이때 이러한 메커니즘을 떠올리면 된다.
     */


}
