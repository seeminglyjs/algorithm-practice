package com.algorithm.practice.algorithmpractice.programmers.Case_ver2;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

@SpringBootTest
public class 공원_산책 {
    //https://school.programmers.co.kr/learn/courses/30/lessons/172928

    @Test
    public void test() {
        String[] park = {"SOO","OOO","OOO"};
        String[] routes = {"E 2","S 2","W 1"};
        int [] arr = solution(park, routes);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public int[] solution(String[] park, String[] routes) {
        int sx = 0;
        int sy = 0;

        char[][] arr = new char[park.length][park[0].length()];

        for (int i = 0; i < park.length; i++) {
            arr[i] = park[i].toCharArray();

            if (park[i].contains("S")) {
                sy = i;
                sx = park[i].indexOf("S");
            }
        }

        for (String st : routes) {
            String way = st.split(" ")[0];
            int len = Integer.parseInt(st.split(" ")[1]);

            int nx = sx;
            int ny = sy;

            for (int i = 0; i < len; i++) {
                if (way.equals("E")) {
                    nx++;
                }
                if (way.equals("W")) {
                    nx--;
                }
                if (way.equals("S")) {
                    ny++;
                }
                if (way.equals("N")) {
                    ny--;
                }
                if (nx >= 0 && ny >= 0 && ny < arr.length && nx < arr[0].length) {
                    if (arr[ny][nx] == 'X') {
                        break;
                    }
                    // 범위내 & 장애물 x
                    if (i == len - 1) {
                        sx = nx;
                        sy = ny;
                    }
                }
            }
        }

        int[] answer = {sy, sx};
        return answer;
    }

}
