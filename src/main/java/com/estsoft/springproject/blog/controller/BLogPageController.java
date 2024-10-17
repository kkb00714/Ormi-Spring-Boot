package com.estsoft.springproject.blog.controller;

import com.estsoft.springproject.blog.domain.Article;
import com.estsoft.springproject.blog.domain.dto.ArticleViewResponse;
import com.estsoft.springproject.blog.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BLogPageController {
    private final BlogService service;

    public BLogPageController(BlogService service) {
        this.service = service;
    }

    @GetMapping("/articles")
    public String showArticle(Model model) {
        List<Article> articleList = service.findAll(); // Article 엔티티 리스트를 가져옴
        // Article -> ArticleViewResponse로 바꾸기

        List<ArticleViewResponse> list = articleList
                .stream()
                .map(ArticleViewResponse::new).toList();

        model.addAttribute("articles", list);

        return "articleList";  // articleList.html
    }
}
