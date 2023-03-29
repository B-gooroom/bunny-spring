package kr.bunny.bunnyspring.repository;

import kr.bunny.bunnyspring.domain.Member;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRespository{

    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }
    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return  Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        /**jpql */
        List<Member> result =  em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
//        List<Member> result = em.createQuery("select m from Member m", Member.class).getResultList();
//        return result;
        // inline variable -> 위 두줄 inline variable로 정리
        /**jpql
         * 기존 sql 'select * from Member' 또는 원하는 키 설정 -> 'select m from Member m' @Entitiy로 선언되어있는 key만 매핑해서 가져옴(객체 자체)
         */
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }
}
