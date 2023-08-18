package com.algorithm.practice.algorithmpractice.programmers.Case_ver2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class a20230818_콜라_문제 {
    //https://school.programmers.co.kr/learn/courses/30/lessons/132267

    @Test
    public void test(){
        System.out.println(solution(3,1,20));
    }

    /**
     *
     * @param a b 당 빈병수
     * @param b a 당 콜라수
     * @param n 전체 빈병수
     * @return 총 먹을 수 있는 콜라 수
     */
    public int solution(int a, int b, int n) {
        int answer = 0;

        while (n >= a){
            int mok = n / a;
            int mng = n % a;

            int newCoke = mok * b;
            answer += newCoke;
            n = newCoke + mng;
        }

        return answer;
    }
}
