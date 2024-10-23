package com.estsoft.springproject.blog.service;

import com.estsoft.springproject.blog.domain.Article;
import com.estsoft.springproject.blog.domain.Comment;
import com.estsoft.springproject.blog.domain.dto.AddCommentRequest;
import com.estsoft.springproject.blog.repository.BlogRepository;
import com.estsoft.springproject.blog.repository.CommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final BlogRepository blogRepository;

    public CommentService(CommentRepository repository, BlogRepository blogRepository) {
        this.commentRepository = repository;
        this.blogRepository = blogRepository;
    }

    public Comment saveComment(Long articleId, AddCommentRequest request) {
        Article article = blogRepository.findById(articleId).orElseThrow(); // NoSuchElementException
        return commentRepository.save(new Comment(request.getBody(), article));
    }
}
