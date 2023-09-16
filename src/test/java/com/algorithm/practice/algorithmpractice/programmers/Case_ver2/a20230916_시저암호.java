package com.algorithm.practice.algorithmpractice.programmers.Case_ver2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class a20230916_시저암호 {

    //https://school.programmers.co.kr/learn/courses/30/lessons/12926

    @Test
    public void test(){
        System.out.println(solution("a B z", 4));
    }

    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' '){answer.append(s.charAt(i));}
            else {
                if((s.charAt(i) <= 122 && s.charAt(i) >= 97 && s.charAt(i) + n > 122) || (s.charAt(i) <= 90 && s.charAt(i) >= 65 && s.charAt(i) + n > 90)){answer.append( Character.toChars(s.charAt(i) + n - 26));}
                else{answer.append( Character.toChars(s.charAt(i) + n));}
            }
        }
        return answer.toString();
    }
}
