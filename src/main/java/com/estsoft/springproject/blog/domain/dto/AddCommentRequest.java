package com.estsoft.springproject.blog.domain.dto;

import com.estsoft.springproject.blog.domain.Article;
import com.estsoft.springproject.blog.domain.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddCommentRequest {
    private String body;
    private Article article;

    public Comment toEntity() {
        return Comment.builder()
                .body(this.body)
                .article(this.article)
                .build();
    }
}
