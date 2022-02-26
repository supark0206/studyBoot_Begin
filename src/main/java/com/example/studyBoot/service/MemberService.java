package com.example.studyBoot.service;

import com.example.studyBoot.domain.Member;
import com.example.studyBoot.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//서비스는 비지니스 로직에 맞게 네이밍한다
//ctrl + shift + t 로 테스트 생성 가능
//@Service //스프링 컨테이너에 MemberService를 등록

public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     */
    public Long join(Member member){
        
        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    /**
     * 전체 회원조회
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

    private void validateDuplicateMember(Member member) {
        //같은 이름이 있는 중복 회원x
        //Ctrl+Alt+v 로 반환타입 자동생성 가능
        //Shift+Ctrl+Alt+T 로 리팩토링 팝업 띄워서 메소드 추출
       memberRepository.findByName(member.getName())
                .ifPresent(m->{
            throw new IllegalStateException("이미 존재하는 회원입니다");
        });
    }
}
