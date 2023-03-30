package kr.bunny.bunnyspring.repository;

import kr.bunny.bunnyspring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRespository {

    //JPQL -> select m from Member m where m.name = ?
    @Override
    Optional<Member> findByName(String name);
}
