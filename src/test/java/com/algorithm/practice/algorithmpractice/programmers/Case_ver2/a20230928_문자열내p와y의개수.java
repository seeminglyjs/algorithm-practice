package com.algorithm.practice.algorithmpractice.programmers.Case_ver2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class a20230928_문자열내p와y의개수 {

    //https://school.programmers.co.kr/learn/courses/30/lessons/12916
    @Test
    public void Test() {
        System.out.println();
    }

    boolean solution(String s) {
        int yCnt = s.length() - s.toUpperCase().replace("Y","").length();
        int pCnt = s.length() - s.toUpperCase().replace("P","").length();
        return yCnt == pCnt;
    }


    boolean solution2(String s) {
        s = s.toUpperCase();
        return s.chars().filter(c -> 'P' == c).count() == s.chars().filter(c -> 'Y' == c).count();
    }
}
