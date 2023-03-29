package kr.bunny.bunnyspring.service;

import kr.bunny.bunnyspring.domain.Member;
import kr.bunny.bunnyspring.repository.MemberRespository;
import kr.bunny.bunnyspring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {

    @Autowired MemberService memberService;
    @Autowired MemberRespository memberRespository;

    /**회원가입 */
    @Test
    //@Commit -> Transactional으로 data 리셋(반)
    void join() {

        //given
        Member member = new Member();
        member.setName("boot");

        //when
        Long saveId = memberService.join(member);

        //then
        Optional<Member> findMember =  memberService.findOne(member.getId());
        assertThat(member.getName()).isEqualTo(findMember.get().getName());
    }

    /**중복확인 */
    @Test
    public void duplicate() {
        //given
        Member member1 = new Member();
        member1.setName("spring1");

        Member member2 = new Member();
        member2.setName("spring1");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");

        //then
    }

}