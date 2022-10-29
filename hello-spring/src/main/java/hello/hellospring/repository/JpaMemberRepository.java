package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{
    /*
        EntityManager:
         1. 엔티티를 관리하는 역할을 한다.
         2. 엔티티 매니저 내부에는 영속성 컨텍스트가 있고 이를 통해 엔티티를 관리한다.
         3. 여러 엔티티 매니저가 하나의 영속성 컨텍스트를 공유 가능하다.
         4. EntityManager는 Thread-Safe를 보장해야한다. 동일한 EntityManager를 가지고 멀티 스레드 환경에서 호출한다면 데이터가 어떻게 변경될지 모른다.

     */
    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    // 회원정보를 저장하는 로직
    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    // 회원ID 를 찾는 로직 > 회원 정보가 존재 할수 도 있고 존재 하지 않을수도 있기에 Optional을 사용해서 리스트구조에 담아 둔다
    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    // 마찬가지로 회원 정보의 이름을 찾는 로직 >> 회원정보가 존재 할 수도 있고 아닐수도 있기에 Optional로 감싸준다.
    //
    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
        return result.stream().findAny();
    }

    // 회원 정보 모든 것을 찾는 로직
    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();

    }
}
