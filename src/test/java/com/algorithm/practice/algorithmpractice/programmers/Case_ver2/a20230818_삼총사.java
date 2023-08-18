package com.algorithm.practice.algorithmpractice.programmers.Case_ver2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class a20230818_삼총사 {
    //https://school.programmers.co.kr/learn/courses/30/lessons/131705
    @Test
    public void test(){

    }

    public int solution(int[] number) {
        int answer = 0;

        for(int i = 0; i < number.length-2; i++) {
            for(int j = i + 1; j < number.length-1; j++) {
                for(int k = j + 1; k < number.length; k++) {
                    if(number[i] + number[j] + number[k] == 0) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}
