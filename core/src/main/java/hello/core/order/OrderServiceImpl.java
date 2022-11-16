package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor // 필수값인 생성자들을 만들어준다. 고로 밑에 final 로 되어 있는 두개를 받는 생성자를 만들어준다 자동으로
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository ;
    private final DiscountPolicy discountPolicy ;

    // 생성자가 하나만 있으면 @Autowired 를 생략해도 가능하다 .스프링 빈으로 등록되어 있을 때

    /**
     *  Autowired 매칭정리
     *  타입매칭
     * 타입 매칭 결과가 두개이상일 때는 필드명, 파라미터명으로 빈 이름을 매칭한다.
     *
     * @ Qualifier("이름") 퀄리파이어의 이름과 동일한 것을 매칭해서 들고온다.
     * 왠만해선 퀄리파이어 지정을 해놓은 것 끼리 찾는 용도로만 사용하는 것이 명확하다.
     *
     * @ Primary 우선순위를 정한다. 주로 데이터베이스 커넥션을 할 때 메인 데이터 베이스에는
     * 프라이머리를 정해주고 서브 데이터베이스는 쿼리파이어나 직접 이름을 정해 들고오는 식으로 하자.
     *
     * 우선순위
     * 프라이머리는 기본값처럼 동작하고 쿼리파이어는 매우 상세하게 동작하는데
     * 이런경우 어떤것이 우선권을 가져가는지는 자동보다는 수동이 넓은 범위 선택권보다는
     * 좁은 ㅅ범위 선택권이 우선권이 높기 때문에 Qualifier 의 우선순위가 높다.
     */


    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId); // 레파지토리에서 멤버의 아이디 값을 찾는다
        int discountPrice = discountPolicy.discount(member, itemPrice); // 멤버의 정보와 아이템 가격을 받아서 디스카운트 실행한 값을 discountPrice 에 주입

        return new Order(memberId, itemName, itemPrice, discountPrice); // 최종 주문생성을 반환
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
