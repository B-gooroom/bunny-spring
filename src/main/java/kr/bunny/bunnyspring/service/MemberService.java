package kr.bunny.bunnyspring.service;

import kr.bunny.bunnyspring.domain.Member;
import kr.bunny.bunnyspring.repository.MemberRespository;
import kr.bunny.bunnyspring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/** 네이밍
 * repository -> class 이름들이 단순함
 * service -> class 비즈니스 로직에 가까운 이름으로 설계
 */
@Service
public class MemberService  {

    private final MemberRespository memberRespository;

    @Autowired
    public MemberService(MemberRespository memberRespository) {
        this.memberRespository = memberRespository;
    }

    /**회원가입 */
    public Long join (Member member) {
        // 중복이름 제외
        //optinal로 감싸주지 않는다면 if null~로 예외처리 해주어야함
        validateDuplicateMember(member);
        memberRespository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRespository.findByName(member.getName())
                .ifPresent(member1 -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다");
                });
    }

    /**전체회원조회 */
    public List<Member> findMembers() {
        return memberRespository.findAll();
    }

//    public Optional<Member> findOne(Long memberId) {
      public Member findOne(int memberId) {
        return memberRespository.findById(memberId);
    }
}
