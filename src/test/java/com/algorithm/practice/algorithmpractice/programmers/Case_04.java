package com.algorithm.practice.algorithmpractice.programmers;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class Case_04 { //2 x n 타일링 [피보나치]
//    2 x n 타일링
//    문제 설명
//    가로 길이가 2이고 세로의 길이가 1인 직사각형모양의 타일이 있습니다. 이 직사각형 타일을 이용하여 세로의 길이가 2이고 가로의 길이가 n인 바닥을 가득 채우려고 합니다. 타일을 채울 때는 다음과 같이 2가지 방법이 있습니다.
//
//    타일을 가로로 배치 하는 경우
//    타일을 세로로 배치 하는 경우

//
//    직사각형의 가로의 길이 n이 매개변수로 주어질 때, 이 직사각형을 채우는 방법의 수를 return 하는 solution 함수를 완성해주세요.
//
//    제한사항
//    가로의 길이 n은 60,000이하의 자연수 입니다.
//    경우의 수가 많아 질 수 있으므로, 경우의 수를 1,000,000,007으로 나눈 나머지를 return해주세요.

    static int answer = 0;
    @Test
    public void test(){
        int n = 5;
        int result;
        result = solution(n);
        System.out.println(result);
    }

    //가로 2 / 세로 1
    public int solution(int n) {
        int a = 1;
        int b = 2;
        int c = 0 ;
        if(n == 1){
            return  a;
        } else if (n == 2) {
            return  b;
        }
        for(int i = 0; i < n -2; i++){
            c = (a + b) % 1000000007;
            a = b;
            b = c;
            answer = c;
        }

        return answer;
    }


    //다른 사람의 풀이
    HashMap cache = new HashMap() ;

    public int tiling(int n) {
        int answer = 0;

        // 1과 2의 합 조합 경우의 수
        // 모두 1만의 합인경우는 무조건 있으니, 2가 포함된경우만 구하여 +1 한다.

        int cnt = n/2 ; //2의 최대갯수

        for(int i=1; i<=cnt; i++){
            int totCnt = n - i ; //1의 갯수. 이중에 2가 i 개 들어갈수 있는 경우의 수를 구한다
            answer += combination(totCnt,i) ;
        }
        return (answer + 1) %100000;
    }

    public int combination(long n, long r) {
        int retInt = 0;
        // 재귀호출은 속도문제 발생
        // 캐시사용으로 중복사용 제외
        if(n == r || r == 0) {
            return 1;
        }else{
            long tmpN = n -1 ;
            long tmpR = r -1 ;
            long tmpAns1 = 0 ;
            long tmpAns2 = 0 ;

            if(cache.get(tmpN + "/" + tmpR)==null){
                tmpAns1 = combination(tmpN, tmpR) ;
                cache.put(tmpN + "/" + tmpR, tmpAns1);
            }else{
                tmpAns1 = (long) cache.get(tmpN + "/" + tmpR);
            }
            //
            if(cache.get(tmpN + "/" + r)==null){
                tmpAns2 = combination(tmpN, r) ;
                cache.put(tmpN + "/" + r, tmpAns2);
            }else{
                tmpAns2 = (long) cache.get(tmpN + "/" + r);
            }
            retInt = (int)(tmpAns1 + tmpAns2) %100000;
        }
        return retInt ;
    }
}
