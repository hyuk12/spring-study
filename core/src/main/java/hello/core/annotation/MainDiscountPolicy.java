package hello.core.annotation;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

// 어노테이션을 직접 만들어서 쓰기
// 어노테이션은 상속이라는 개념이 없다. 여러 애노테이션을 모아서 쓰는 것은 스프링에서 지원해주는 기능이다 Qualifier 뿐만아니라 다른 애노테이션도
// 재정의 가능하지만 목적없이 무분별하게 재정의 하는 것은 유지 보수에 더 혼란만 가중할 수 있다.
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Qualifier("mainDiscountPolicy")
public @interface MainDiscountPolicy {
}
