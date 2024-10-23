package com.estsoft.springproject.blog.service;

import com.estsoft.springproject.blog.domain.Article;
import com.estsoft.springproject.blog.domain.Comment;
import com.estsoft.springproject.blog.domain.dto.AddCommentRequest;
import com.estsoft.springproject.blog.domain.dto.CommentResponse;
import com.estsoft.springproject.blog.repository.BlogRepository;
import com.estsoft.springproject.blog.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final BlogRepository blogRepository;

    public CommentService(CommentRepository repository, BlogRepository blogRepository) {
        this.commentRepository = repository;
        this.blogRepository = blogRepository;
    }

    public Comment saveComment(Long articleId, AddCommentRequest request) {
        Article article = blogRepository.findById(articleId).orElseThrow();
        return commentRepository.save(new Comment(request.getBody(), article));
    }

    public Comment findComment(Long commentID) {
        Optional<Comment> optionalComment = commentRepository.findById(commentID);
        return optionalComment.orElse(new Comment());
    }

    public Comment updateComment(Long commentId, AddCommentRequest request) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(); // NoSuchElementException
        // 수정
        comment.updateCommentBody(request.getBody());
        return commentRepository.save(comment);
    }

    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
