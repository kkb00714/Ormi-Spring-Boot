package com.estsoft.springproject.blog.service;

import com.estsoft.springproject.blog.domain.dto.AddArticleRequest;
import com.estsoft.springproject.blog.domain.Article;
import com.estsoft.springproject.blog.domain.dto.ArticleResponse;
import com.estsoft.springproject.blog.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    private final BlogRepository repository;

    public BlogService(BlogRepository blogRepository) {
        this.repository = blogRepository;
    }

    // blog 게시글 작성
    // repository.save(Article)
    public Article saveArticle(AddArticleRequest request) {
        return repository.save(request.toEntity());
    }

    // blog 글 조회 (전체)
    public List<Article> findAll() {
        return repository.findAll();
    }

    // blog 글 조회 (단건)
    public Article findArticleById(Long id) {
        return repository.findById(id)
                .orElseThrow( () ->new IllegalArgumentException("존재하지 않는 id : " + id));
    }
}