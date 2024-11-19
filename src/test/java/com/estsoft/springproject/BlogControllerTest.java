package com.estsoft.springproject;

import com.estsoft.springproject.blog.domain.Article;
import com.estsoft.springproject.blog.domain.dto.UpdateArticleRequest;
import com.estsoft.springproject.blog.repository.BlogRepository;
import com.estsoft.springproject.blog.service.BlogService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@Disabled
public class BlogControllerTest {

    @Autowired
    WebApplicationContext context;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private BlogRepository repository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private BlogService blogService;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        repository.deleteAll();
    }

    // 게시글 생성 테스트코드
    @Test
    public void addArticle() throws Exception {
        // given
        Article article = new Article("제목테스트", "내용테스트");
        repository.save(article);

        // 직렬화
        String json = objectMapper.writeValueAsString(article);

        // when
        ResultActions resultActions = mockMvc.perform(post("/articles")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json));

        // then
        resultActions.andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value(article.getTitle()))
                .andExpect(jsonPath("$.content").value(article.getContent()));

        List<Article> articleList = repository.findAll();
        Assertions.assertThat(articleList.size()).isEqualTo(2);
    }

    // 게시글 전체 조회 테스트코드
    @Test
    public void findAll() throws Exception {
        // given : 조회 API에 필요한 값 셋팅
        Article article = repository.save(new Article("title", "content"));

        // when : 조회 API
        ResultActions resultActions = mockMvc.perform(get("/articles")
                .accept(MediaType.APPLICATION_JSON));

        // then : API 호출 결과 검증 - json
        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value(article.getTitle()))
                .andExpect(jsonPath("$[0].content").value(article.getContent()));
    }

    // 게시글 한 개 조회 테스트케이스
    @Test
    public void findOne() throws Exception {
        // given
        Article article = repository.save(new Article("title123", "content321"));
        Long id = article.getId();

        // when
        ResultActions resultActions = mockMvc.perform(get("/articles/{id}", id)
                .accept(MediaType.APPLICATION_JSON));

        // then
        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.title").value(article.getTitle()))
                .andExpect(jsonPath("$.content").value(article.getContent()));
    }

    // 블로그 글 삭제 API 호출 테스트

    @Test
    public void deleteArticle() throws Exception {
        // given
        Article article = repository.save(new Article("i'm fine thank you", "And you?"));
        Long id = article.getId();

        // when
        ResultActions resultActions = mockMvc.perform(delete("/articles/{id}", id));

        // then
        resultActions.andExpect(status().isOk());
        List<Article> articleList = repository.findAll();
        Assertions.assertThat(articleList).isEmpty();
    }

    // 단전 조회 API에서 id에 해당하는 자원이 없을 경우 400에러 예외처리 검증
    @Test
    public void findOneException() throws Exception {
        // when
        ResultActions resultActions = mockMvc.perform(get("/articles/{id}", 1L)
                .accept(MediaType.APPLICATION_JSON));

        // then
        resultActions.andExpect(status().isBadRequest());

        org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class,
                () -> blogService.findArticleById(1L));
    }

    // PUT /articles/{id}  body(json content) 요청
    @Test
    public void updateArticle() throws Exception {
        Article article = repository.save(new Article("Update Test", "Test2"));
        Long id = article.getId();

        // 수정 데이터(object) -> json
        UpdateArticleRequest request = new UpdateArticleRequest("변경 제목", "변경 내용");
        String updateJsonContent = objectMapper.writeValueAsString(request);

        ResultActions resultActions = mockMvc.perform(put("/articles/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(updateJsonContent));

        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value(request.getTitle()))
                .andExpect(jsonPath("$.content").value(request.getContent()));
    }
    
    // 수정 API 호출시 예외 발생했을 경우 (수정하려는 id가 존재하지 않을 경우) => status 검증, Exception 검증
    @Test
    public void updateException() throws Exception {
        // given
        Long id = 13L;
        
        UpdateArticleRequest request = new UpdateArticleRequest("id1제목", "id2제목");
        String updateJsonContent = objectMapper.writeValueAsString(request);

        // when
        ResultActions resultActions = mockMvc.perform(put("/articles/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(updateJsonContent));

        // then
        resultActions.andExpect(status().isBadRequest());

        org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class,
                () -> blogService.update(id, request));

    }

}
