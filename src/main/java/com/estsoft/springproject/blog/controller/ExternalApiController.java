package com.estsoft.springproject.blog.controller;

import com.estsoft.springproject.blog.domain.Article;
import com.estsoft.springproject.blog.repository.BlogRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@RestController
public class ExternalApiController {

    @Autowired
    private final BlogRepository repository;

    public ExternalApiController(BlogRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/api/external")
    public String callApi() {
        // 외부 API 호출
        RestTemplate restTemplate = new RestTemplate();

        String url = "http://jsonplaceholder.typicode.com/posts";

        // 외부 API 호출, 역직렬화  (restTemplate)
        ResponseEntity<List<Content>> resultList = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Content>>() {});

        List<Content> contents = resultList.getBody();

        if (contents != null) {
            for (Content content : contents) {
                Article article = new Article();
                article.setTitle(content.getTitle());
                article.setContent(content.getBody());
                repository.save(article);
            }
        }

        return "OK";
    }
}
