package com.estsoft.springproject.blog.domain;

import com.estsoft.springproject.blog.domain.dto.ArticleResponse;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Entity
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @CreatedDate // 생성된 날짜, 시간을 넣어줌
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate // 업데이트된 날짜, 시간을 넣어줌.
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "article")
    private List<Comment> comments;


    @Builder // 생성자 생성을 할 때 메서드 체이닝 형식으로 생성해줌
    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

//    public ArticleResponse convert() {
//        return new ArticleResponse(id, title, content);
//    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
