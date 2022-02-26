package com.example.studyBoot.repository;

import com.example.studyBoot.domain.Member;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Repository;

import java.util.*;

//@Repository
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long,Member> store = new HashMap<>();
    private static long sequence = 0L;


    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        //null이 반활될 가능성이있을때 Optional사용
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                //파라미터 name과 같을때만 필터링됨
                .filter(member -> member.getName().equals(name))
                .findAny(); //하나라도 찾으면 반환 끝까지없으면 null
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
    
    
    //store를 비우는 메서드
    public void clearStore(){
        store.clear();
    }
}
