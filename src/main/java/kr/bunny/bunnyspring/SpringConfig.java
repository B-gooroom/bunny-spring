package kr.bunny.bunnyspring;

import kr.bunny.bunnyspring.repository.MemberRespository;
import kr.bunny.bunnyspring.repository.MemoryMemberRepository;
import kr.bunny.bunnyspring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
}
