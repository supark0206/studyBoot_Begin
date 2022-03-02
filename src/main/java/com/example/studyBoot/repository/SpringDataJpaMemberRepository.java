package com.example.studyBoot.repository;

import com.example.studyBoot.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//JpaRepository<>를 상속해서 안에있는 메소드들을 사용 기본적인 CRUD들을 거의 다 제공한다
public interface SpringDataJpaMemberRepository extends JpaRepository<Member,Long> , MemberRepository {
    @Override
    public Optional<Member> findByName(String name);
}
