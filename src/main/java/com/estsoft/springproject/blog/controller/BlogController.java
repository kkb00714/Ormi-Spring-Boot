package com.estsoft.springproject.blog.controller;

import com.estsoft.springproject.blog.domain.dto.AddArticleRequest;
import com.estsoft.springproject.blog.domain.Article;
import com.estsoft.springproject.blog.domain.dto.ArticleResponse;
import com.estsoft.springproject.blog.domain.dto.UpdateArticleRequest;
import com.estsoft.springproject.blog.service.BlogService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class BlogController {
    private final BlogService service;

    public BlogController(BlogService service) {
        this.service = service;
    }

    // Create RequestMapping (특정 url   POST /articles)
    @PostMapping("/articles")
    public ResponseEntity<ArticleResponse> writeArticle(
            @RequestBody AddArticleRequest request
            // JSON 데이터 형식으로 넘겨줬을 때, 특정 값으로 파싱을 해주는 어노테이션
    ) {
       Article article = service.saveArticle(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(article.convert());
    }

    // Read RequestMapping   조회 : GET
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

    // Delete /articles/{id}
    // @RequestMapping(method = RequestMethod.DELETE, value = "/articles/{id}")
    @DeleteMapping("/articles/{id}")
    public ResponseEntity<Void> deleteArticles(@PathVariable Long id) {
        service.deleteArticleById(id);
        return ResponseEntity.ok().build();
    }

    // 특정 Exception을 받았을 때
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> illegalArgumentException(IllegalArgumentException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());  // 에러 사유를 정의해서 넘겨준다?
    }

    // PUT /articles/{id} 수정 API -> RequestBody에 받기
    @PutMapping("/articles/{id}")
    public ResponseEntity<ArticleResponse> updateArticle (
            @PathVariable Long id,
            @RequestBody UpdateArticleRequest request)
    {
        Article updatedArticle = service.update(id, request);
        return ResponseEntity.ok(updatedArticle.convert());
    }
}
