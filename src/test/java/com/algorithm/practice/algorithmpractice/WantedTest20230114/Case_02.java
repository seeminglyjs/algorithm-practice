package com.algorithm.practice.algorithmpractice.WantedTest20230114;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Scanner;

@SpringBootTest
class Case_02 {
//	B번 - 도넛 행성
//	시간 제한	메모리 제한
//1 초	1024 MB
//			문제
//
//
//	준겸이는
//	$N \times M$칸으로 이루어진 도넛 모양의 행성에 살고 있다. 준겸이가 살고 있는 행성에는 위 그림처럼 격자 모양으로 줄이 그어져 있다. 행성의 각 칸은 숲으로 막혀 있거나, 지나갈 수 있도록 비어 있다.
//
//	준겸이는 본인의 집이 있는 위치를 기준으로 삼아
//	$(0,0)$이라고 표시하기로 했다. 준겸이는 행성 위에서 상하좌우로 걸어 다닐 수 있다. 준겸이가 오른쪽으로 한 칸 걸어가면, 위치
//	$(0,1)$에 도달할 것이다. 마찬가지로 아래로 한 칸 걸어가면, 위치
//	$(1,0)$에 도달할 것이다. 준겸이가
//	$(0,0)$에서
//	$M$칸 오른쪽으로 걸어가면, 한 바퀴를 돌아 다시 원래 자리로 되돌아오게 된다. 비슷하게
//	$(0,0)$에서
//	$N$칸 아래로 걸어가면,
//	$(0,0)$으로 돌아오게 된다. 행성은 연결되어 있기 때문에, 준겸이가
//	$(0,0)$에서 왼쪽으로 한 칸 걸어가면 위치
//	$(0,M-1)$에 도달할 것이다. 마찬가지로 준겸이가
//	$(0,0)$에서 위로 한 칸 걸어가면
//	$(N-1, 0)$에 도달하게 된다.
//
//	준겸이는 행성을 탐험하려고 한다. 만약 준겸이가 비어 있는 어떤 칸
//	$A=(p_1,q_1)$에서 시작해, 숲에 막히지 않고 비어 있는 칸
//	$B=(p_2,q_2)$에 도달할 수 있다면
//	$A$와
//	$B$는 같은 구역이다. 반대로, 도달할 수 없다면
//			$A$와
//	$B$는 서로 다른 구역이다. 당신은 준겸이가 탐험할 수 있는 빈 구역의 개수가 몇 개인지 출력해야 한다.
//
//	입력
//	첫 번째 줄에
//			$N$과
//	$M$이 공백을 사이에 두고 주어진다.
//
//	두 번째 줄부터
//	$N$개의 줄에 걸쳐
//	$N \times M$개의 칸에 대한 정보가 주어진다. 두 번째 줄에서부터
//	$i$번째 줄에 주어지는
//	$j$번째 정수는 칸
//	$(i-1, j-1)$에 대한 정보이다. 만약 0이라면 비어 있는 것이고, 1이라면 숲으로 막혀 있는 것이다.
//
//			출력
//	탐험할 수 있는 구역의 개수를 출력한다.
//
//	제한
// 
//	$2 \le N \le 1\,000$ 
//			 
//	$2 \le M \le 1\,000$ 
//	예제 입력 1
//			5 6
//			1 1 1 1 1 1
//			1 0 0 0 1 1
//			1 1 1 1 0 0
//			1 1 1 1 0 0
//			1 1 1 1 1 1
//	예제 출력 1
//			2
//	예제 입력 2
//			7 8
//			0 0 1 1 0 0 0 0
//			0 1 1 1 1 0 1 0
//			1 1 1 1 1 1 1 1
//			0 1 1 1 1 1 0 0
//			1 1 0 0 0 1 0 0
//			0 1 0 0 0 1 0 1
//			0 0 1 1 1 1 0 0
//	예제 출력 2
//			2
//	직사각형 격자로 보이지만 실제로는 한 바퀴를 돌아 이동할 수 있는 도넛 모양이기 때문에, 빈 영역의 개수는 두 개이다.

    @Test
    void contextLoads() { // test
        Scanner sc = new Scanner(System.in);
		int a, b;
//		a = sc.nextInt();
//		b = sc.nextInt();
//		int [][] arr = new int [a][b];
//		for(int i = 0; i < a; i++){
//			for(int j = 0; j < a; j++){
//				arr[i][j] = sc.nextInt();
//				System.out.println(arr[i][j]);
//
//			}
//		}

        a = 5;
        b = 6;
        int[][] arr = new int[a][b];
        arr[0][0] = 1;
        arr[0][1] = 1;
        arr[0][2] = 1;
        arr[0][3] = 1;
        arr[0][4] = 1;
        arr[0][5] = 1;

        arr[1][0] = 1;
        arr[1][1] = 0;
        arr[1][2] = 0;
        arr[1][3] = 0;
        arr[1][4] = 1;
        arr[1][5] = 1;

        arr[2][0] = 1;
        arr[2][1] = 1;
        arr[2][2] = 1;
        arr[2][3] = 1;
        arr[2][4] = 0;
        arr[2][5] = 0;

        arr[3][0] = 1;
        arr[3][1] = 1;
        arr[3][2] = 1;
        arr[3][3] = 1;
        arr[3][4] = 0;
        arr[3][5] = 0;

        arr[4][0] = 1;
        arr[4][1] = 1;
        arr[4][2] = 1;
        arr[4][3] = 1;
        arr[4][4] = 1;
        arr[4][5] = 1;


        for (int i = row; i < row; i++) {
			if(!visted[i][0]){
				checkfirstRow(arr, i);
			}
        }
    }

    public static void checkfirstRow(int[][] arr, int rowi) {
		count++;
		visted[rowi][0] = true;
		if(arr[rowi][col-1] == 0 && !visted[rowi][col-1]){//현재 행의 반대편이랑 연결되어 있을 경우
			visted[rowi][col-1] = true;
		}
    }

    static int count = 0;
    static int row, col;
    static boolean[][] visted = new boolean[row][col];
}
