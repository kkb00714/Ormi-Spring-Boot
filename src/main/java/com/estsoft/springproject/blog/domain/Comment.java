package com.estsoft.springproject.blog.domain;

import com.estsoft.springproject.blog.domain.dto.CommentResponse;
import jakarta.persistence.*;
import lombok.Builder;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Getter
@Setter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    @Column(nullable = false)
    private String body;

    @CreatedDate // 생성된 날짜, 시간을 넣어줌
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    @Builder
    public Comment(String body, Article article) {
        this.body = body;
        this.article = article;
    }
//
//    public CommentResponse convert() {
//        return new CommentResponse(id, body, createdAt, article);
//    }
}
