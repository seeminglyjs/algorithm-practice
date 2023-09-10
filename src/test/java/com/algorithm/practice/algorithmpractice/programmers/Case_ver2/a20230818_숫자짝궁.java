package com.algorithm.practice.algorithmpractice.programmers.Case_ver2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Comparator;

@SpringBootTest
public class a20230818_숫자짝궁 {
    //https://school.programmers.co.kr/learn/courses/30/lessons/131128

    @Test
    public void test() {
        System.out.println(solution("100", "2345"));
    }


    //정답
    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();

        int[] arrCntX = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] arrCntY = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        for (String s : X.split("")) {
            arrCntX[Integer.parseInt(s)] += 1;
        }
        for (String s : Y.split("")) {
            arrCntY[Integer.parseInt(s)] += 1;
        }

        for (int i = arrCntX.length - 1; i >= 0; i--) {
            int min = Math.min(arrCntX[i], arrCntY[i]);
            if (min >= 1) {
                sb.append(String.valueOf(i).repeat(min));
            }
        }

        if (sb.toString().length() == 0) return "-1";
        if (sb.toString().replaceAll("0", "").length() == 0) return "0";
        return sb.toString();
    }

    //시간초과
    public String solution2(String X, String Y) {
        StringBuilder answer = new StringBuilder();

        String[] arrX = X.split("");
        Arrays.sort(arrX, Comparator.reverseOrder());  // 내림차순 정렬
        String[] arrY = Y.split("");
        Arrays.sort(arrY, Comparator.reverseOrder());  // 내림차순 정렬

        int xLen = 0;
        int yLen = 0;
        while (true) {
            if (xLen > arrX.length - 1 || yLen > arrY.length - 1) break;

            if (Integer.parseInt(arrX[xLen]) == Integer.parseInt(arrY[yLen])) {
                if (!answer.toString().equals("0")) answer.append(arrX[xLen]);
                xLen++;
                yLen++;
            } else if (Integer.parseInt(arrX[xLen]) > Integer.parseInt(arrY[yLen])) {
                xLen++;
            } else if (Integer.parseInt(arrY[yLen]) > Integer.parseInt(arrX[xLen])) {
                yLen++;
            } else break;
        }
        if (answer.toString().length() == 0) return "-1";
        return answer.toString();
    }
}
