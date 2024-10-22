package com.estsoft.springproject.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {
    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;

    @Column(updatable = false)
    private String name;

    // 양방향 연관관계 => @OneToMan (X) 성능에 좋지 않음..
    // ☆ 연관관계의 주인 명시, mappedBy 안에 FK를 들고있는 객체를 써줘야 함.
    // -> 1 : N 중, N에 해당하는 것을 써주면 됨.
    @OneToMany(mappedBy = "team")
    private List<Members> members = new ArrayList<>();
}
