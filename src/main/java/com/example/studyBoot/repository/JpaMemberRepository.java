package com.example.studyBoot.repository;

import com.example.studyBoot.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{

    //jpa 는 entitymanager로 모든게 동작함
    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member =  em.find(Member.class,id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m where m.name = :name",Member.class)
        .setParameter("name",name)
        .getResultList();

        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        //객체자체를 조회함
        return em.createQuery("select m from Member m",Member.class)
                .getResultList();
    }
}
