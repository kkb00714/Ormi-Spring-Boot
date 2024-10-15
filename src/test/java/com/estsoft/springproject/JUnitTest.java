package com.estsoft.springproject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JUnitTest {
    @Test
    public void test() {
        // given
        int a = 1;
        int b = 2;

        // when : 검증하고 싶은 메서드 코드 호출
        int sum = a + b;

        // then : when절에서 실행한 결과 검증
        // 성공 케이스
        Assertions.assertEquals(3, sum);

        // 실패 케이스
//        Assertions.assertEquals(5, sum);
    }

}
