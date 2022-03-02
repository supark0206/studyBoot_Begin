package com.example.studyBoot;

import com.example.studyBoot.aop.TimeTraceAop;
import com.example.studyBoot.repository.MemberRepository;
import com.example.studyBoot.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


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
    /*    private EntityManager em;  //jpa

        public SpringConfig(EntityManager em) {
            this.em = em;
        }*/

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }
/*    @Bean
    public MemberRepository memberRepository(){

        //return new MemoryMemberRepository();
       // return new JdbcTemplateMemberRepository(dataSource);//jdbc
       // return new JpaMemberRepository(em);//entitymanager jpa를 활용

    }*/


    /*
    @Bean //이렇게 스프링에 추가해도되고 @component 로도 추가가능
    public TimeTraceAop timeTraceAop(){
        return new TimeTraceAop();
    }*/
}
