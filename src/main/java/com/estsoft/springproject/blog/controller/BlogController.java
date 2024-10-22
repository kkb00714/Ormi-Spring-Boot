package com.estsoft.springproject.blog.controller;

import com.estsoft.springproject.blog.domain.dto.AddArticleRequest;
import com.estsoft.springproject.blog.domain.Article;
import com.estsoft.springproject.blog.domain.dto.ArticleResponse;
import com.estsoft.springproject.blog.domain.dto.UpdateArticleRequest;
import com.estsoft.springproject.blog.service.BlogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Value;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
@Tag(name = "블로그 저장/수정/삭제/조회용 API")
public class BlogController {
    private final BlogService service;

    public BlogController(BlogService service) {
        this.service = service;
    }

    @ApiResponses(value = {     // content - 본문 내용에 있는 컨텐츠를 넣어줄 수 있음
            @ApiResponse(responseCode = "201", description = "article 생성에 성공했습니다.", content = @Content(mediaType = "application/json"))
    })
    @Operation(summary = "블로그 글 생성하기", description = "블로그 메인 화면에서 article 생성 페이지로 이동")
    // Create RequestMapping (특정 url   POST /articles)
    @PostMapping("/articles")
    public ResponseEntity<ArticleResponse> writeArticle(
            @RequestBody AddArticleRequest request
            // JSON 데이터 형식으로 넘겨줬을 때, 특정 값으로 파싱을 해주는 어노테이션
    ) {
       Article article = service.saveArticle(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(article.convert());
    }

    // Read RequestMapping   조회 : GET
    @ApiResponses(value = {     // content - 본문 내용에 있는 컨텐츠를 넣어줄 수 있음
            @ApiResponse(responseCode = "200", description = "요청에 성공했습니다", content = @Content(mediaType = "application/json"))
    })
    @Operation(summary = "블로그 전체 보기", description = "블로그 메인 화면에서 보여주는 전체 article 목록")
    @Parameters(value = {
            @Parameter(name="id", description="블로그 글 ID", example="본문에 들어갈 내용입니다")
    })
    @GetMapping("/articles")
    public ResponseEntity<List<ArticleResponse>> findArticles() {
        List<Article> articleList = service.findAll();
        List<ArticleResponse> list = service.findAll().stream()
                .map(Article::convert)  // article -> article.convert()
                .toList();
        return ResponseEntity.ok(list);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "{id}번 article을 조회합니다.", content = @Content(mediaType = "application/json"))
    })
    @Operation(summary = "{id}번 블로그 글 조회", description = "{id}번 블로그를 조회합니다.")
    @GetMapping("/articles/{id}")
    public ResponseEntity<ArticleResponse> findOneArticles(@PathVariable Long id) {
        Article article = service.findArticleById(id);
        // Article -> ArticleResponse 변환
        return ResponseEntity.ok(article.convert());
    }

    // Delete /articles/{id}
    // @RequestMapping(method = RequestMethod.DELETE, value = "/articles/{id}")
    @Operation(summary = "블로그 글 삭제", description = "{id}번 블로그를 삭제합니다.")
    @DeleteMapping("/articles/{id}")
    public ResponseEntity<Void> deleteArticles(@PathVariable Long id) {
        service.deleteArticleById(id);
        return ResponseEntity.ok().build();
    }

    // 특정 Exception을 받았을 때
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> illegalArgumentException(IllegalArgumentException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());  // 에러 사유를 정의해서 넘겨준다?
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "{id}번 article을 업데이트 합니다.", content = @Content(mediaType = "application/json"))
    })
    @Operation(summary = "블로그 글 업데이트", description = "{id}번 article을 업데이트 합니다.")
    // PUT /articles/{id} 수정 API -> RequestBody에 받기
    @PutMapping("/articles/{id}")
    public ResponseEntity<ArticleResponse> updateArticle (
            @PathVariable Long id,
            @RequestBody UpdateArticleRequest request)
    {
        Article updatedArticle = service.update(id, request);
        return ResponseEntity.ok(updatedArticle.convert());
    }
}
