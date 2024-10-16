package com.estsoft.springproject.blog.controller;

import com.estsoft.springproject.blog.domain.dto.AddArticleRequest;
import com.estsoft.springproject.blog.domain.Article;
import com.estsoft.springproject.blog.domain.dto.ArticleResponse;
import com.estsoft.springproject.blog.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlogController {
    private final BlogService service;

    public BlogController(BlogService service) {
        this.service = service;
    }

    // RequestMapping (특정 url   POST /articles)
    @PostMapping("/articles")
    public ResponseEntity<Article> writeArticle(
            @RequestBody AddArticleRequest request
            // JSON 데이터 형식으로 넘겨줬을 때, 특정 값으로 파싱을 해주는 어노테이션
    ) {
       Article article = service.saveArticle(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(article);
    }

    // RequestMapping   조회 : GET
    @GetMapping("/articles")
    public ResponseEntity<List<ArticleResponse>> findArticles() {
//        List<Article> articleList = service.findAll();
        List<ArticleResponse> list = service.findAll().stream()
                .map(article -> new ArticleResponse(
                        article.getId(), article.getTitle(), article.getContent()))
                .toList();
        return ResponseEntity.ok(list);
    }
}
