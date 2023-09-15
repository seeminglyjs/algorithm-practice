package com.algorithm.practice.algorithmpractice.programmers.Case_ver2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class a20230916_이상한문자만들기 {

    //https://school.programmers.co.kr/learn/courses/30/lessons/12930

    @Test
    public void Test(){
        System.out.println(solution("try hello world"));
    }

    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        int index = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' '){ answer.append(s.charAt(i)); index = 0;}
            else if(index % 2 == 0) {answer.append(String.valueOf(s.charAt(i)).toUpperCase()); index++;}
            else{ answer.append(String.valueOf(s.charAt(i)).toLowerCase()); index++;}
        }
        return answer.toString();
    }
}
