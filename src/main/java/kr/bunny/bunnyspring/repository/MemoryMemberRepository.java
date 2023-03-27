package kr.bunny.bunnyspring.repository;

import kr.bunny.bunnyspring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRespository{

    // Map<Long, Member> = 객체 형식 -> List<Member> = 배열 형식
//    private static Map<Long, Member> store = new HashMap<>();
    private static List<Member> store = new ArrayList<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
//        store.put(member.getId(), member);
        store.add(member);
        return member;
    }
//    overloading ex
    public Member save(int member) {
        return new Member();
    }

//    public Optional<Member> findById(Long id) {
    // 배열에서는 Long -> int
    @Override
    public Member findById(int id) {
        // optional.ofNumllable 로 감싸두면 반환되는 값이 null이어도 반환이 가능
        return store.get(id);

    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.stream()
                .filter(member -> member.getName().equals(name))
                .findAny(); // 아무거나 하나라도 찾아지면 찾아오는함수
    }

    @Override
    public List<Member> findAll() {
//        return new ArrayList<>(store.values());
        return store;
    }

    public void clearStore() {
        store.clear();
    }
}
