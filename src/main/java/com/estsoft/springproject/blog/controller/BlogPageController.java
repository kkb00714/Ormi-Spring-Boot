package com.estsoft.springproject.blog.controller;

import com.estsoft.springproject.blog.domain.Article;
import com.estsoft.springproject.blog.domain.dto.ArticleViewResponse;
import com.estsoft.springproject.blog.service.BlogService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BlogPageController {
    private final BlogService service;

    public BlogPageController(BlogService service) {
        this.service = service;
    }

    @GetMapping("/articles")
    public String showArticle(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        // auth 값에 user, ROLE_ADMIN 둘 다 들어가있음.
        List<Article> articleList = service.findAll(); // Article 엔티티 리스트를 가져옴
        // Article -> ArticleViewResponse로 바꾸기

        List<ArticleViewResponse> list = articleList
                .stream()
                .map(ArticleViewResponse::new).toList();

        model.addAttribute("articles", list);

        return "articleList";  // articleList.html
    }

    // GET /articles/{id} 상세 페이지 리턴
    @GetMapping("/articles/{id}")
    public String showDetails(@PathVariable Long id, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        Users users = (Users) authentication.getPrincipal();

        Article article = service.findArticleById(id);
        model.addAttribute("article", new ArticleViewResponse(article));

        return "article"; // article.html
    }

    // GET /new-articles?id=1
    @GetMapping("/new-article")
    public String addArticle(@RequestParam(required = false) Long id, Model model) {
        if (id == null) { // 새로운 게시글 생성
            model.addAttribute("article", new ArticleViewResponse());

        } else { // 게시글 수정
            Article article = service.findArticleById(id);
            model.addAttribute("article", new ArticleViewResponse(article));
        }
        return "newArticle";  // newArticle.html
    }

}
