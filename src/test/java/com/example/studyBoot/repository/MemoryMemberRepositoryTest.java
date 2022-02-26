package com.example.studyBoot.repository;

import com.example.studyBoot.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    //중요!!  하나의 테스트가 끝날때마다 저장소나 공용 데이터를 비워줘야한다
    //각 Test가 끝나고 데이터를 비워줌
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("test1");
        
        repository.save(member);
        Member result = repository.findById(member.getId()).get();

        System.out.println("result = " + (result==member));
        //member가 result와 같은지 확인
        //alt+enter로 스태틱 임포트 가능하다 그럼 더편하게 사용가능
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("findName1");
        repository.save(member1);

        //shift + f6으로 편하게 rename 가능하다
        Member member2 = new Member();
        member2.setName("findName2");
        repository.save(member2);

        Member result = repository.findByName("findName1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("findName1");
        repository.save(member1);

        //shift + f6으로 편하게 rename 가능하다
        Member member2 = new Member();
        member2.setName("findName2");
        repository.save(member2);

        List<Member> all = repository.findAll();

        assertThat(all.size()).isEqualTo(2);


    }

}
