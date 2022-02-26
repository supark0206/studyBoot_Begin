package com.example.studyBoot.repository;

import com.example.studyBoot.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    //구현부가 없는 추상메서드
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
