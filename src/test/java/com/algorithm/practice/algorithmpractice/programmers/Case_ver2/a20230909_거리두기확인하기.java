package com.algorithm.practice.algorithmpractice.programmers.Case_ver2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedList;
import java.util.Queue;

@SpringBootTest
public class a20230909_거리두기확인하기 {
//https://school.programmers.co.kr/learn/courses/30/lessons/81302/solution_groups?language=java1
    @Test
    public void test() {
        String[][] places = {
                {"OOPOO",
                 "OOOOO",
                 "OOPOO"}
        };

        int[] answer = solution(places);

        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + "/ ");
        }
    }


    public static int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int i = 0; i < places.length; i++) {
            String[] p = places[i];

            boolean isOk = true;
            for (int r = 0; r < 5 && isOk; r++) {
                for (int c = 0; c < 5 && isOk; c++) {
                    if (p[r].charAt(c) == 'P') {
                        if (!bfs(r, c, p))
                            isOk = false;
                    }
                }
            }
            answer[i] = isOk ? 1 : 0;
        }

        return answer;
    }


    private static boolean bfs(int r, int c, String[] p) {
        int dr[] = { -1, 1, 0, 0 };
        int dc[] = { 0, 0, -1, 1 };

        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[] { r, c });

        while (!queue.isEmpty()) {
            int[] position = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = position[0] + dr[i];
                int nc = position[1] + dc[i];

                if (nr < 0 || nc < 0 || nr >= 5 || nc >= 5 || (nr == r && nc == c))
                    continue;

                int d = Math.abs(nr - r) + Math.abs(nc - c); //메하탄 거리 계산

                if (p[nr].charAt(nc) == 'P' && d <= 2)
                    return false;
                else if (p[nr].charAt(nc) == 'O' && d < 2) //거리가 2이하이고 빈 테이블이 경우
                    queue.offer(new int[] { nr, nc });
            }
        }

        return true;   //X 일 경우
    }



































    public int[] solution2(String[][] places) {
        int[] answer = new int[places.length];
        int index = 0;

        for (int i = 0; i < places.length; i++) {
            String[][] subPlace = new String[places[0].length][];

            for (int j = 0; j < places[0].length; j++) {
                String[] split = places[i][j].split("");
                subPlace[j] = split;
            }
            answer[index] = checkDistance(subPlace);
            index++;
        }

        return answer;
    }

    public int checkDistance(String[][] places) {
        for (int i = 0; i < places.length; i++) {
            for (int j = 0; j < places[0].length; j++) {
                int NSEW = 0;
                if (places[i][j].equals("P")) {//응시자 위치
                    if (i - 1 < 0 || places[i - 1][j].equals("X")) {
                        NSEW += 1;
                    } else if (
                            i - 2 == -1 && places[i - 1][j].equals("O") || places[i - 1][j].equals("O") || i - 2 >= 0 && places[i - 1][j].equals("O") && (places[i - 2][j].equals("O") || places[i - 2][j].equals("X")))
                    {
                    } else {
                        return 0;
                    } //거리두기 실패

                    if (i + 1 > places.length - 1 || places[i + 1][j].equals("X")) {
                        NSEW += 1;
                    } else if (
                            (i + 1 == places.length - 1 && places[i + 1][j].equals("O")) ||
                            (i + 2 == places.length && places[i + 1][j].equals("O")) ||
                            (i + 1 <= places.length -1 && places[i + 1][j].equals("O")) ||
                            (i + 2 <= places.length - 1 && (places[i + 1][j].equals("O") && (places[i + 2][j].equals("O") || places[i + 2][j].equals("X"))))) {
                    } else {
                        return 0;
                    } //거리두기 실패

                    if (j + 1 > places[0].length - 1 || places[i][j + 1].equals("X")){
                        NSEW += 1;
                    }else if (
                            (j + 1 == places[0].length - 1 && places[i][j + 1].equals("O")) ||
                            (j + 2 == places[0].length && places[i][j + 1].equals("O")) ||
                            (j + 1 <= places[0].length -1 && places[i][j + 1].equals("O")) ||
                            (j + 2 <= places[0].length - 1 && (places[i][j + 1].equals("O") && (places[i][j + 2].equals("O") || places[i][j + 2].equals("X")))))
                    {
                    } else {
                        return 0;
                    } //거리두기 실패

                    if (j - 1 < 0 || places[i][j - 1].equals("X")){
                        NSEW += 1;
                    }else if(
                            j - 2 == -1 && places[i][j - 1].equals("O") || places[i][j - 1].equals("O") || j - 2 >= 0 && places[i][j - 1].equals("O") && (places[i][j - 2].equals("O") || places[i][j - 2].equals("X"))) {
                    } else {
                        return 0;
                    } //거리두기 실패

                    if(NSEW != 4){
                        if ((i - 1 >= 0 && j - 1 >= 0 && places[i - 1][j - 1].equals("X")) ||
                                (i - 1 < 0 || j - 1 < 0) ||
                                (i - 2 == -1 && j - 2 == -1 && places[i - 1][j - 1].equals("O")) ||
                                (i - 2 < 0 || j - 2 < 0) ||
                                (i - 2 >= 0 && j - 2 >= 0 && (places[i - 1][j - 1].equals("O") && (places[i - 2][j - 2].equals("O") || places[i - 2][j - 2].equals("X"))))
                        ) {
                        } else {
                            return 0;
                        } //거리두기 실패

                        if ((i - 1 >= 0 && j + 1 <= places[0].length - 1 && places[i - 1][j + 1].equals("X")) ||
                                (i - 1 < 0 || j + 1 > places[0].length - 1) ||
                                (i - 2 == -1 && j + 2 == places[0].length && places[i - 1][j + 1].equals("O")) || //맨허튼 2보다 작고 열 위가 비었을 경우
                                (i - 2 < 0 || j + 2 > places[0].length - 1) ||
                                (i - 2 >= 0 && j + 2 <= places[0].length - 1 && (places[i - 1][j + 1].equals("O") && (places[i - 2][j + 2].equals("O") || places[i - 2][j + 2].equals("X"))))
                        ) {
                        } else {
                            return 0;
                        } //거리두기 실패

                        if ((i + 1 <= places.length - 1 && j + 1 <= places[0].length - 1 && places[i + 1][j + 1].equals("X")) ||
                                (i + 1 > places.length - 1 || j + 1 > places[0].length - 1) ||
                                (i + 2 == places.length && j + 2 == places[0].length && places[i + 1][j + 1].equals("O")) ||
                                (i + 2 > places.length - 1 || j + 2 > places[0].length - 1) ||
                                (i + 2 <= places.length - 1 && j + 2 <= places[0].length - 1 && (places[i + 1][j + 1].equals("O") && (places[i + 2][j + 2].equals("O") || places[i + 2][j + 2].equals("X"))))
                        ) {
                        } else {
                            return 0;
                        } //거리두기 실패

                        if ((i + 1 <= places.length - 1 && j - 1 >= 0 && places[i + 1][j - 1].equals("X")) ||
                                (i + 1 > places.length - 1 || j - 1 < 0) ||
                                (i + 2 == places.length && j - 2 == -1 && places[i + 1][j - 1].equals("O")) ||
                                (i + 2 > places.length - 1 || j - 2 < 0) ||
                                (i + 2 <= places.length - 1 && j - 2 >= 0 && (places[i + 1][j - 1].equals("O") && (places[i + 2][j - 2].equals("O") || places[i + 2][j - 2].equals("X"))))
                        ) {
                        } else {
                            return 0;
                        } //거리두기 실패
                    }
                }
            }
        }
        return 1;
    }

}
