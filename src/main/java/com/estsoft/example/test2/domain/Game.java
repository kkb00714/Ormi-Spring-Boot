package com.estsoft.example.test2.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Game {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "game_name")
    private String name;

    // 회사명 FK로 가져오기
}
