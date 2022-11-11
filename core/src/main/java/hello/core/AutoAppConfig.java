package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

// 기존의 앱콘피그와 다르게 빈정보가 없고 컴포넌트 스캔을 사용하려면 설정정보에 @ComponentScan을 붙여주면 된다.
// 그리고 쓰려면 Component 를 필터로 못쓰게 설정 후 사용 기존 예제코드를 살려두기 위해 하는 행동 보통 제외하지 않는다
@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}
