package com.estsoft.springproject.blog.controller;

import com.estsoft.springproject.blog.domain.AddArticleRequest;
import com.estsoft.springproject.blog.domain.Article;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController {
    // RequestMapping (특정 url   POST /articles)
    @PostMapping("/articles")
    public ResponseEntity<Article> writeArticle(
            @RequestBody AddArticleRequest request
            // JSON 데이터 형식으로 넘겨줬을 때, 특정 값으로 파싱을 해주는 어노테이션
    ) {
        System.out.println(request.getTitle());
        System.out.println(request.getContent());
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
