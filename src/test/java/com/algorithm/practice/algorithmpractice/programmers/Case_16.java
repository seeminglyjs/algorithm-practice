package com.algorithm.practice.algorithmpractice.programmers;
import java.util.*;
public class Case_16 { //미로 탈출

//    미로 탈출
//    문제 설명
//1 x 1 크기의 칸들로 이루어진 직사각형 격자 형태의 미로에서 탈출하려고 합니다. 각 칸은 통로 또는 벽으로 구성되어 있으며, 벽으로 된 칸은 지나갈 수 없고 통로로 된 칸으로만 이동할 수 있습니다. 통로들 중 한 칸에는 미로를 빠져나가는 문이 있는데, 이 문은 레버를 당겨서만 열 수 있습니다. 레버 또한 통로들 중 한 칸에 있습니다. 따라서, 출발 지점에서 먼저 레버가 있는 칸으로 이동하여 레버를 당긴 후 미로를 빠져나가는 문이 있는 칸으로 이동하면 됩니다. 이때 아직 레버를 당기지 않았더라도 출구가 있는 칸을 지나갈 수 있습니다. 미로에서 한 칸을 이동하는데 1초가 걸린다고 할 때, 최대한 빠르게 미로를 빠져나가는데 걸리는 시간을 구하려 합니다.
//
//    미로를 나타낸 문자열 배열 maps가 매개변수로 주어질 때, 미로를 탈출하는데 필요한 최소 시간을 return 하는 solution 함수를 완성해주세요. 만약, 탈출할 수 없다면 -1을 return 해주세요.
//
//            제한사항
//5 ≤ maps의 길이 ≤ 100
//            5 ≤ maps[i]의 길이 ≤ 100
//    maps[i]는 다음 5개의 문자들로만 이루어져 있습니다.
//    S : 시작 지점
//    E : 출구
//    L : 레버
//    O : 통로
//    X : 벽
//    시작 지점과 출구, 레버는 항상 다른 곳에 존재하며 한 개씩만 존재합니다.
//    출구는 레버가 당겨지지 않아도 지나갈 수 있으며, 모든 통로, 출구, 레버, 시작점은 여러 번 지나갈 수 있습니다.
//            입출력 예
//    maps	result
//["SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"]	16
//        ["LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"]	-1
//    입출력 예 설명
//    입출력 예 #1
//
//    주어진 문자열은 다음과 같은 미로이며
//
//            image1
//
//    다음과 같이 이동하면 가장 빠른 시간에 탈출할 수 있습니다.
//
//            image2
//
//4번 이동하여 레버를 당기고 출구까지 이동하면 총 16초의 시간이 걸립니다. 따라서 16을 반환합니다.
//
//    입출력 예 #2
//
//    주어진 문자열은 다음과 같은 미로입니다.
//
//            image3
//
//    시작 지점에서 이동할 수 있는 공간이 없어서 탈출할 수 없습니다. 따라서 -1을 반환합니다.



    class Solution {
        static int n, m, sx, sy, ex, ey, lx, ly;
        static char[][] map;
        static boolean[][] visit;

        static int lMin = Integer.MAX_VALUE;

        public int solution(String[] maps) {
            n = maps.length;
            m = maps[0].length();

            map = new char[n][m];
            visit = new boolean[n][m];

            for (int i = 0; i < n; i++) {
                map[i] = maps[i].toCharArray();
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 'S') {
                        sx = i;
                        sy = j;
                    } else if (map[i][j] == 'L') {
                        lx = i;
                        ly = j;
                    } else if (map[i][j] == 'E') {
                        ex = i;
                        ey = j;
                    }
                }
            }
            int sum = 0;

            int startX = sx;
            int startY = sy;
            int endX = lx;
            int endY = ly;

            int searchL = search(startX, startY, endX, endY);
            visit = new boolean[n][m];
            System.out.println(searchL);
            if(searchL == -1) return -1;
            sum += searchL;
            lMin = Integer.MAX_VALUE;

            startX = lx;
            startY = ly;
            endX = ex;
            endY = ey;
            int searchE = search(startX, startY, endX, endY);
            System.out.println(searchE);

            if(searchE == -1) return -1;
            sum += searchE;
            return sum;
        }

        public static int search(int startX, int startY, int endX, int endY) {
            Queue<int[]> q = new LinkedList<>();
            visit[startX][startY] = true;
            q.add(new int[]{startX, startY, 0});

            while (!q.isEmpty()) {
                int[] point = q.poll();

                int x = point[0];
                int y = point[1];
                int dist = point[2];
                // System.out.println("x: " + x + " y: " + y + " dist:" + dist);

                if (x == endX && y == endY) {
                    System.out.println("lx: " + endX + " ly: " + endY);
                    System.out.println("dist" + dist);
                    if (dist < lMin) {
                        lMin = dist;
                        return lMin;
                    }
                }

                if (x + 1 < n && !visit[x + 1][y] && map[x + 1][y] != 'X') {
                    visit[x + 1][y] = true;
                    q.add(new int[]{x + 1, y, dist + 1});
                }

                if (x - 1 >= 0 && !visit[x - 1][y] && map[x - 1][y] != 'X') {
                    visit[x - 1][y] = true;
                    q.add(new int[]{x - 1, y, dist + 1});
                }

                if (y + 1 < m && !visit[x][y + 1] && map[x][y + 1] != 'X') {
                    visit[x][y + 1] = true;
                    q.add(new int[]{x, y + 1, dist + 1});
                }

                if (y - 1 >= 0 && !visit[x][y - 1] && map[x][y - 1] != 'X') {
                    visit[x][y - 1] = true;
                    q.add(new int[]{x, y - 1, dist + 1});
                }


            }
            if (lMin < Integer.MAX_VALUE) return lMin;
            return -1;
        }
    }
}
