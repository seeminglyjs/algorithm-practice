package com.algorithm.practice.algorithmpractice.WantedTest20230114;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Scanner;

@SpringBootTest
class Case_01 { //A번 - 신을 모시는 사당


//	A번 - 신을 모시는 사당
//	시간 제한	메모리 제한
//2 초	512 MB
//			문제
//	신을 모시는 사당에는 신을 조각한 돌상 N개가 일렬로 놓여 있다. 각 돌상은 왼쪽 또는 오른쪽을 바라보고 서있다. 창영이는 연속한 몇 개의 돌상에 금칠을 하여 궁극의 깨달음을 얻고자 한다.
//
//	궁극의 깨달음을 얻기 위해서는 가능한 한 많은 금색 돌상들이 같은 방향을 바라보아야 한다. 방향이 다른 돌상은 깨달음에 치명적이다. 깨달음의 양은 아래와 같이 정의된다.
//
//| (왼쪽을 바라보는 금색 돌상의 개수) - (오른쪽을 바라보는 금색 돌상의 개수) |
//
//	창영이는 궁극의 깨달음을 얻을 수 있을까?
//
//	입력
//	첫째 줄에 돌상의 개수 N이 주어진다.
//
//	둘째 줄에 돌상이 나열된 순서대로, 각 돌상이 바라보고 있는 방향이 주어진다. 입력의 편의상 왼쪽은 1, 오른쪽은 2라고 하자.
//
//	출력
//	최대한 많은 깨달음을 얻기 위해 금을 칠하였을 때, 얻을 수 있는 깨달음의 양을 출력한다.
//
//			제한
//1 ≤ N ≤ 100,000
//	예제 입력 1
//			5
//			1 1 2 1 2
//	예제 출력 1
//			2
//	예제 입력 2
//			1
//			1
//	예제 출력 2
//			1
//	예제 입력 3
//			2
//			1 2
//	예제 출력 3
//			1
//	힌트
//	칠할 수 있는 돌상의 개수에 제한은 없으며, 반드시 연속한(인접한) 돌상들만 칠할 수 있음(띄엄띄엄 칠할 수 없음)에 유의하라.

    static Integer MaxCount = 0;
    @Test
    public void test1() {

        Scanner sc = new Scanner(System.in);
        int a;
        a = sc.nextInt();
        Integer [] b = new Integer [a];

        for(int i = 0; i < b.length; i++){
            b[i] = sc.nextInt();
        }
        getPower(a, b);
    }

    public static Integer getPower(Integer a, Integer[] b) {
        Integer cnt = 0;
        if (a == 1) {
            if (b[0] == 1) { //길이가 1인 배열에 첫값이 1이면 리턴 1
                return 1;
            } else {//길이가 1인 배열에 첫값이 2면 리턴 0
                return 0;
            }
        }
        int startIdx = 0;
        int endIdx = b.length - 1;
        searchMax(startIdx, endIdx, b);
        return cnt;
    }

    private static void searchMax(int startIdx, int endIdx, Integer[] b) {
        if(MaxCount == b.length){return;}
        if(startIdx == b.length -1){
            return;
        } else if (endIdx < 0) {
            return;
        }
        int count = 0;
        if((endIdx - startIdx) < MaxCount){return;}
        for(int i = startIdx; i < endIdx; i++){
            if(b[i].equals(1)){
                count+=1;
            }else{
                count-=1;
            }
        }
        if(MaxCount < count){
            MaxCount= count;
        }
//        System.out.println(MaxCount);
        searchMax(startIdx+1, endIdx, b);
        searchMax(startIdx, endIdx-1, b);
    }
}
