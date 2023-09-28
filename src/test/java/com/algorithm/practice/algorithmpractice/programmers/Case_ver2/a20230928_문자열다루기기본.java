package com.algorithm.practice.algorithmpractice.programmers.Case_ver2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class a20230928_문자열다루기기본 {

    //https://school.programmers.co.kr/learn/courses/30/lessons/12918
    @Test
    public void Test() {

    }

    public boolean solution(String s) {
        return (s.length() == 6 || s.length() == 4) && s.chars().noneMatch(c -> c > 57);
    }

}
