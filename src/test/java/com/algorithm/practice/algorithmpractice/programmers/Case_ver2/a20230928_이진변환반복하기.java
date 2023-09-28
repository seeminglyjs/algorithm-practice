package com.algorithm.practice.algorithmpractice.programmers.Case_ver2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class a20230928_이진변환반복하기 {

    //https://school.programmers.co.kr/learn/courses/30/lessons/70129
    @Test
    public void Test() {

    }

    public int[] solution(String s) {
        int[] answer = {0, 1};

        int zeroCount = 0;
        int binaryCnt = 0;
        while(true) {
            if(!s.equals("1")) {
                zeroCount += (s.length() - s.replace("0", "").length());
                s = s.replace("0", "");
                System.out.println(s);
                s = Integer.toBinaryString(s.length());
                System.out.println("b-> " +s);
                binaryCnt ++;
            }else {
                System.out.println(binaryCnt + " / " + zeroCount);
                answer[0] = binaryCnt;
                answer[1] = zeroCount;
                break;
            }
        }

        return answer;
    }


}
