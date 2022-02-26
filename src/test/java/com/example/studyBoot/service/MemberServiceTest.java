package com.example.studyBoot.service;

import com.example.studyBoot.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.example.studyBoot.repository.MemoryMemberRepository;

import static org.assertj.core.api.Assertions.*;


public class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memoryMemberRepository;
    
    //테스트하기전마다 실행되는 코드
    @BeforeEach
    public void beforeEach(){
        //DI
        memoryMemberRepository = new MemoryMemberRepository(); //생성후
        //memberService 에 넣어준다
        //이러면 같은 repository를 외부에서 넣어주기때문에 같은걸 사용가능
        memberService = new MemberService(memoryMemberRepository);
    }

    /**
     *  이렇게하면 MemoryMemberRepository memberRepository = new MemoryMemberRepository();
     * MemberSercive에서 만든 MemoryMemberRepository() 와는 다른게되버림 새로운 객체이기때문
     *
     */


    @AfterEach
    public void afterEach(){
        memoryMemberRepository.clearStore();
    }


    @Test
    public void join(){
        //given
        Member member = new Member();
        member.setName("hello");
        //when
        Long saveId = memberService.join(member);
        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void  중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("test1");

        Member member2 = new Member();
        member2.setName("test1");

        //when
        memberService.join(member1);
        // (터질 예외 , 로직)
        IllegalStateException e = Assertions.assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");

       /* try{
            memberService.join(member2);
        }catch (IllegalStateException e){
            //오류발생시 발생하는 문구가 같은지 확인해서 검증
            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");
        }*/
        //then
    }

    @Test
    public void findOne(){

    }
    @Test
    public void findMembers(){

    }
    
}
