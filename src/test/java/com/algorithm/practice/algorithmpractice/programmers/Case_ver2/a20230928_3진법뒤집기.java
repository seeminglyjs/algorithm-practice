package com.algorithm.practice.algorithmpractice.programmers.Case_ver2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootTest
public class a20230928_3진법뒤집기 {

    //https://school.programmers.co.kr/learn/courses/30/lessons/68935
    @Test
    public void Test() {
        int n = 125;
        System.out.println(solution(n));
    }

    public int solution(int n) {
        int answer = 0;
        String strN = DecimalToTernary.reverse(DecimalToTernary.toTernary(n));
        return Integer.parseInt(strN,3);
    }

    public static class DecimalToTernary {
        public static String toTernary(int decimalNumber) {
            if (decimalNumber == 0) {
                return "0";
            }
            StringBuilder result = new StringBuilder();
            while (decimalNumber > 0) {
                int remainder = decimalNumber % 3;
                result.insert(0, remainder); // 나머지를 앞에 추가
                decimalNumber /= 3;
            }

            return result.toString();
        }

        public static String reverse(String strN) {
            StringBuilder sb = new StringBuilder(strN);
            return sb.reverse().toString();
        }
    }


}
