package com.estsoft.springproject.blog.domain.dto;

import com.estsoft.springproject.blog.domain.Article;
import com.estsoft.springproject.blog.domain.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class CommentResponse {
    private Long id;
    private Long article_id;
    private String body;
    private LocalDateTime created_at;
    private ArticleResponse article;

    public CommentResponse(Comment comment) {
        this.id =comment.getId();
        this.body =comment.getBody();
        this.created_at =comment.getCreatedAt();
        article = new ArticleResponse(comment.getArticle());
    }
}
