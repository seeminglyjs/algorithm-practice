package com.algorithm.practice.algorithmpractice.programmers.Case_ver2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class a20230909_삼각달팽이 {

    @Test
    public void test(){
        List<Integer> answer =  solution(6);
        answer.forEach(
               i -> System.out.print(i + " / ")
        );
    }

    public  List<Integer> solution(int n) {
        List<Integer> answer = new ArrayList<Integer>();
        int [][] snail = new int [n][n];

        int num = 1;
        int row = 0;
        int col = 0;
        boolean cross = false;
        while(true){
            snail[col][row] = num;
            num ++;

            if(col + 1 < snail.length && snail[col + 1][row] == 0 && !cross){col +=1;} //아래진행가능일경우
            else if(row + 1 < snail[0].length && snail[col][row +1] == 0 && !cross){row +=1;} //우측진행가능일경우
            else if(col - 1 >=0 && row -1 >= 0 && snail[col-1][row-1] == 0){col -=1; row-=1; cross=true;} // 좌측대각선 진행가능일 경우
            else if(cross && col + 1 < snail.length && snail[col+1][row] == 0){col +=1; cross=false;} //좌측대각선 아래로 다시 진행이 가능할 경우
            else break; //아무 방향도 진행 불가일 경우
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(snail[i][j] != 0){
                    answer.add(snail[i][j]);
                }
            }
        }

        return answer;
    }
}
