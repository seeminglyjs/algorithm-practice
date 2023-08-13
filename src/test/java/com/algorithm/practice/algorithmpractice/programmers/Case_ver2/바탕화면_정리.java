package com.algorithm.practice.algorithmpractice.programmers.Case_ver2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class 바탕화면_정리 {

    @Test
    public void test() {
        String[] wallpaper = {".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."};
        int[] a = solution(wallpaper);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public int[] solution(String[] wallpaper) {
        int[] answer = {0, 0, 0, 0};
        char[][] wallArr = new char[wallpaper.length][wallpaper[0].length()];
        int[] start = {0, 0};
        int[] end = {0, 0};

        for (int i = 0; i < wallpaper.length; i++) {
            wallArr[i] = wallpaper[i].toCharArray();
        }

        boolean first = true;
        for (int i = 0; i < wallArr.length; i++) {
            for (int j = 0; j < wallArr[i].length; j++) {
                if (wallArr[i][j] == '#') {
                    if (first) {
                        start[0] = i;
                        start[1] = j;
                        end[0] = i + 1;
                        end[1] = j + 1; //최초 드래그 위치 셋팅 시작 열은 최초 # 확인 후 더 이상 확인안해도된다.
                        first = false;
                    } else {
                        if (j < start[1]) start[1] = j;
                        if (j >= end[1]) end[1] = j + 1;
                        if (i >= end[0]) end[0] = i + 1;
                    }
                }
            }
        }

        answer[0] = start[0];
        answer[1] = start[1];
        answer[2] = end[0];
        answer[3] = end[1];

        return answer;
    }
}
