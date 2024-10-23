package com.estsoft.springproject.blog.domain.dto;

import com.estsoft.springproject.blog.domain.Article;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Article Response DTO", title = "블로그 조회")
public class ArticleResponse {
    @Schema(description = "블로그 ID", type = "Long")
    private Long id;

    @Schema(description = "블로그 제목", type = "String")
    private String title;

    @Schema(description = "블로그 sodyd", type = "String")
    private String content;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public ArticleResponse(Article article) {
        id = article.getId();
        title = article.getTitle();
        content = article.getContent();
        createdAt = article.getCreatedAt();
        updatedAt = article.getUpdatedAt();
    }

    public ArticleResponse(Long id, String title, String content){
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
