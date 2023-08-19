package com.algorithm.practice.algorithmpractice.programmers.Case_ver2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class a20230819_부족한금계산하기 {
    //https://school.programmers.co.kr/learn/courses/30/lessons/82612

    @Test
    public void test(){
        System.out.println();
    }

    public long solution(int price, int money, int count) {
        long sum = 0;
        for(int i = 1; i <= count; i++){
            sum += (long) price *i;
        }

        long plus = money - sum;
        if(plus < 0 ) return  -plus;
        else return 0;
    }
}
