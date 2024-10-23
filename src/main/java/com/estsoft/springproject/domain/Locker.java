package com.estsoft.springproject.domain;

import com.estsoft.springproject.entity.Member;
import jakarta.persistence.*;

@Entity
public class Locker {
    @Id
    @GeneratedValue
    @Column(name = "LOCKER_ID")
    private Long id;

    private String name;

    // locker 객체에서도 Members 객체에 접근이 가능!
    // 1:1 양방향 연관 관계 설정
//    @OneToOne(mappedBy = "locker")
//    private Member member;
}
