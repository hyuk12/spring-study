package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

// 기존의 앱콘피그와 다르게 빈정보가 없고 컴포넌트 스캔을 사용하려면 설정정보에 @ComponentScan 을 붙여주면 된다.
// 그리고 쓰려면 Component 를 필터로 못쓰게 설정 후 사용 기존 예제코드를 살려두기 위해 하는 행동 보통 제외하지 않는다
@Configuration
@ComponentScan(
        // 탐색할 시작패키지 시점을 정할 수 있다. 이 패키지를 포함해서 하위 패키지를 모두 탐색한다.
        // 여러개를 지정 해 줄 수도 있다.
        // 지정하지 않으면 componentScan 이 붙은 설정 정보 클래스의 패키지가 시작 위치가 된다. 패키지 위치를 지정 하지 않는 것이 관례
        // 그러므로 메인 설정 정보는 프로젝트의 시작 루트에 둔다.
//        basePackages = "hello.core.member",
//        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}
