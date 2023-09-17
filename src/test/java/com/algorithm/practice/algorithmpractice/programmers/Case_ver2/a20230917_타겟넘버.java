package com.algorithm.practice.algorithmpractice.programmers.Case_ver2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class a20230917_타겟넘버 {

    //https://school.programmers.co.kr/learn/courses/30/lessons/43165

    static int total = 0;

    @Test
    public void Test() {
        int[] numbers = {4, 1, 2, 1};
        int target = 4;
        System.out.println(solution(numbers, target));
    }


    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, -1, target);
        return total;
    }

    private void dfs(int[] numbers, int sum, int index, int target) {
        index ++;
        if(index == numbers.length){
            if(sum == target) total+= 1;
            return;
        }else{
            dfs(numbers, sum + numbers[index], index, target);
            dfs(numbers, sum - numbers[index], index, target);
        }
    }

}
