package kr.bunny.bunnyspring.repository;

import kr.bunny.bunnyspring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRespository {

    Member save(Member member);
//    Optional<Member> findById(Long id);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
