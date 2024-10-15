package com.estsoft.springproject;

import com.estsoft.springproject.blog.domain.Article;
import org.junit.jupiter.api.Test;

public class ArticleTest {

    @Test
    public void test() {
        // 클래스 생성자 직접 호출
        Article article = new Article("제목", "내용");

        // 빌더 패턴을 사용하여 객체 생성
        // 추가할 필드가 많다면 이렇게 builder를 사용해서 생성하는 것도 ok
        Article articleBuilder = Article.builder()
                .title("제목")
                .content("내용")
                .build();
    }
}
