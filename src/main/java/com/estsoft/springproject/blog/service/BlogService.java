package com.estsoft.springproject.blog.service;

import com.estsoft.springproject.blog.domain.AddArticleRequest;
import com.estsoft.springproject.blog.domain.Article;
import com.estsoft.springproject.blog.repository.BlogRepository;
import org.springframework.stereotype.Service;

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
}
