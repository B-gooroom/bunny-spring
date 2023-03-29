package kr.bunny.bunnyspring;

import kr.bunny.bunnyspring.repository.JpaMemberRepository;
import kr.bunny.bunnyspring.repository.MemberRespository;
import kr.bunny.bunnyspring.repository.MemoryMemberRepository;
import kr.bunny.bunnyspring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {

    /**자바 코드로 직접 스프링 빈 등록 */
//    @Bean
//    public MemberService memberService() {
//        return new MemberService(memberRespository());
//    }
//
//    @Bean
//    public MemberRespository memberRespository() {
//        return new MemoryMemberRepository();
//    }

    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }
        @Bean
    public MemberService memberService() {
        return new MemberService(memberRespository());
    }

    @Bean
    public MemberRespository memberRespository() {
//        return new MemoryMemberRepository();
        return new JpaMemberRepository(em);
    }
}
