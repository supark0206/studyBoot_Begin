package com.example.studyBoot;

import com.example.studyBoot.repository.MemberRepository;
import com.example.studyBoot.repository.MemoryMemberRepository;
import com.example.studyBoot.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 자바 코드로 스프링 빈에 등록하는 방법
@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
