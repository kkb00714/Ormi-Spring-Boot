package com.estsoft.springproject.blog.controller;

import com.estsoft.springproject.blog.domain.Comment;
import com.estsoft.springproject.blog.domain.dto.AddCommentRequest;
import com.estsoft.springproject.blog.domain.dto.CommentResponse;
import com.estsoft.springproject.blog.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentController {
    private final CommentService service;

    public CommentController(CommentService service, CommentService commentService) {
        this.service = service;
    }

    // 댓글 생성
    @PostMapping("/articles/{articleId}/comment")
    public ResponseEntity<CommentResponse> saveCommentByArticleId(
            @PathVariable Long articleId,
            @RequestBody AddCommentRequest request
    ) {
        Comment comment = service.saveComment(articleId, request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new CommentResponse(comment));
    }

    @GetMapping("/comment/{commentId}")
    public ResponseEntity<CommentResponse> selectCommentById(
            @PathVariable("commentId") Long id
    ) {
        Comment comment = service.findComment(id); // 받아온 findComment(id) 값은 Comment 타입
        return ResponseEntity.ok(new CommentResponse(comment));
    }

    @PutMapping("/comments/{commentId}")
    public ResponseEntity<CommentResponse> updateCommentById(
            @PathVariable Long commentId,
            @RequestBody AddCommentRequest request
    ) {
        Comment updated = service.updateComment(commentId, request);
        return ResponseEntity.ok(new CommentResponse(updated));
    }
}
