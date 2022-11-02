package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository ;
    private final DiscountPolicy discountPolicy ;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId); // 레파지토리에서 멤버의 아이디 값을 찾는다
        int discountPrice = discountPolicy.discount(member, itemPrice); // 멤버의 정보와 아이템 가격을 받아서 디스카운트 실행한 값을 discountPrice에 주입

        return new Order(memberId, itemName, itemPrice, discountPrice); // 최종 주문생성을 반환
    }
}
