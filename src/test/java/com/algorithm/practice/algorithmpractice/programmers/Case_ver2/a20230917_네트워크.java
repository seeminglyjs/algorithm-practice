package com.algorithm.practice.algorithmpractice.programmers.Case_ver2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
public class a20230917_네트워크 {

    //https://school.programmers.co.kr/learn/courses/30/lessons/43165
    @Test
    public void Test() {
        int[][] computers = {
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 0},
                {1, 1, 0, 1}};
        int n = 4;
        System.out.printf("----> "+ solution(n, computers));
    }


    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] check = new boolean[n]; // n 갯수만큼 boolean 배열을 만들고 모든 요소를 false로 초기화

        for (int i = 0; i < n; i++) {
            if (!check[i]) {
                dfs(computers, i, check);
                answer++;
            }
        }

        return answer;
    }

    boolean[] dfs(int[][] computers, int i, boolean[] check) {
        check[i] = true;

        for (int j = 0; j < computers.length; j++) {
            if (i != j && computers[i][j] == 1 && check[j] == false) {
                check = dfs(computers, j, check);
            }
        }
        return check;
    }


    public int solution2(int n, int[][] computers) {
        int answer = n;
        Set<String> connection = new HashSet<>();
        int result = answer - (dfs2(connection, computers, -1, -1))/2;
        return result == 0 ? 1 : result;
    }

    private int dfs2(Set<String> connection, int[][] computers, int depth, int network) {
        depth++; network++;
        if(depth > computers.length -1){ //최대 깊이 초과시
            return connection.isEmpty() ? 0 : connection.size();
        }else{
            int [] computer = computers[depth];
            for(int i = 0; i < computer.length; i++){
                if(i != network && computer[i] == 1){
                    connection.add(i +""+network); //양방향 연결정보 저장
                    connection.add(network +""+i); //양방향 연결정보 저장
                }
            }
            return dfs2(connection, computers, depth, network);
        }
    }

}
