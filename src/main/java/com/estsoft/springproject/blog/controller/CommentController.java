package com.estsoft.springproject.blog.controller;

import com.estsoft.springproject.blog.domain.Comment;
import com.estsoft.springproject.blog.domain.dto.AddCommentRequest;
import com.estsoft.springproject.blog.domain.dto.CommentResponse;
import com.estsoft.springproject.blog.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/articles")
public class CommentController {
    private final CommentService service;

    public CommentController(CommentService service, CommentService commentService) {
        this.service = service;
    }

    // 댓글 생성
    @PostMapping("/{articleId}/comment")
    public ResponseEntity<CommentResponse> saveCommentByArticleId(
            @PathVariable Long articleId,
            @RequestBody AddCommentRequest request
    ) {
        Comment comment = service.saveComment(articleId, request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new CommentResponse(comment));
    }
}
