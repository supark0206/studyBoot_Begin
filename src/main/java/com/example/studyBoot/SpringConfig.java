package com.example.studyBoot;

import com.example.studyBoot.repository.JpaMemberRepository;
import com.example.studyBoot.repository.MemberRepository;
import com.example.studyBoot.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;


// 자바 코드로 스프링 빈에 등록하는 방법
@Configuration
public class SpringConfig {

    //private DataSource dataSource; //jdbc
    /*
   @Autowired
    public SpringConfig(DataSource dataSource){
        this.dataSource = dataSource;
    }
    */
    private EntityManager em;

    public SpringConfig(EntityManager em) {
        this.em = em;
    }


    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository(){

        //return new MemoryMemberRepository();
       // return new JdbcTemplateMemberRepository(dataSource);//jdbc
        return new JpaMemberRepository(em);//
    }
}
