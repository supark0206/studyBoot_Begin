package com.example.studyBoot.domain;


import javax.persistence.*;

//jpa 를 사용하기 위한 매핑
@Entity
public class Member {

    //Id 인걸 알려준다
    @Id 
    //db가 알아서 생성되게함
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
