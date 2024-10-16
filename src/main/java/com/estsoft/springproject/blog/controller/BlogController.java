package com.estsoft.springproject.blog.controller;

import com.estsoft.springproject.blog.domain.dto.AddArticleRequest;
import com.estsoft.springproject.blog.domain.Article;
import com.estsoft.springproject.blog.domain.dto.ArticleResponse;
import com.estsoft.springproject.blog.service.BlogService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {
    private final BlogService service;

    public BlogController(BlogService service) {
        this.service = service;
    }

    // RequestMapping (특정 url   POST /articles)
    @PostMapping("/articles")
    public ResponseEntity<ArticleResponse> writeArticle(
            @RequestBody AddArticleRequest request
            // JSON 데이터 형식으로 넘겨줬을 때, 특정 값으로 파싱을 해주는 어노테이션
    ) {
       Article article = service.saveArticle(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(article.convert());
    }

    // RequestMapping   조회 : GET
    @GetMapping("/articles")
    public ResponseEntity<List<ArticleResponse>> findArticles() {
//        List<Article> articleList = service.findAll();
        List<ArticleResponse> list = service.findAll().stream()
                .map(Article::convert)  // article -> article.convert()
                .toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/articles/{id}")
    public ResponseEntity<ArticleResponse> findOneArticles(@PathVariable Long id) {
        Article article = service.findArticleById(id);
        // Article -> ArticleResponse 변환
        return ResponseEntity.ok(article.convert());
    }
}
