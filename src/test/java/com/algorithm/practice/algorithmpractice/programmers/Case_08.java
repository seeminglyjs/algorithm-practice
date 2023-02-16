package com.algorithm.practice.algorithmpractice.programmers;

import org.junit.jupiter.api.Test;

public class Case_08 { //크기가 작은 부분 문자열 앤드포인트

    //    문제 설명
//    숫자로 이루어진 문자열 t와 p가 주어질 때, t에서 p와 길이가 같은 부분문자열 중에서, 이 부분문자열이 나타내는 수가 p가 나타내는 수보다 작거나 같은 것이 나오는 횟수를 return하는 함수 solution을 완성하세요.
//
//            예를 들어, t="3141592"이고 p="271" 인 경우, t의 길이가 3인 부분 문자열은 314, 141, 415, 159, 592입니다. 이 문자열이 나타내는 수 중 271보다 작거나 같은 수는 141, 159 2개 입니다.
    @Test
    public void solution(){
        int answer = 0;
        String t = "100000000000000000000000123";
        String p = "111111111111111111";

        int end = 0;
        StringBuilder temp = new StringBuilder();

        do {
            temp.append(t.charAt(end));
            if (temp.length() == p.length()) {
                System.out.println(temp);
                if (Long.parseLong(temp.toString()) <= Long.parseLong(p)) {
                    answer++;
                }
                temp.deleteCharAt(0);
            }
            end++;
        } while (end < t.length());
        System.out.println(answer);
    }
}
