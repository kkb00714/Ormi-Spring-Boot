package com.estsoft.springproject.blog.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Builder // 생성자 생성을 할 때 메서드 체이닝 형식으로 생성해줌
    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
