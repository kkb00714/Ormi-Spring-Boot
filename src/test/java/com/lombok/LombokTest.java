package com.lombok;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LombokTest {
    @Test
    public void test() {
        People people = new People(
                1L, "me", 22,
                Arrays.asList("그림그리기", "게임하기", "영화보기"));
        System.out.println(people.getHobbies());
    }
}
