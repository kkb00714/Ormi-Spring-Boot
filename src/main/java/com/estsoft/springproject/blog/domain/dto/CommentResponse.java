package com.estsoft.springproject.blog.domain.dto;

import com.estsoft.springproject.blog.domain.Article;
import com.estsoft.springproject.blog.domain.Comment;
import com.estsoft.springproject.util.DateFormatUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.estsoft.springproject.util.DateFormatUtil.formatter;

@Getter
@Setter
@NoArgsConstructor
public class CommentResponse {
    private Long id;
    private Long article_id;
    private String body;
    private String created_at;
    private ArticleResponse article;

    public CommentResponse(Comment comment) {
        Article articleFromComment = comment.getArticle();

        this.id =comment.getId();
        this.body =comment.getBody();
        this.created_at =comment.getCreatedAt().format(formatter);
        article = new ArticleResponse(articleFromComment);
    }
}
