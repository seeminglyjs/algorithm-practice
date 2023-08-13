package com.algorithm.practice.algorithmpractice.programmers.Case_ver2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class 카드_뭉치 {
    //https://school.programmers.co.kr/learn/courses/30/lessons/159994

    @Test
    public void test(){
        String[] cards1 ={"i", "drink", "water"};
        String[] cards2 ={"want", "to"};
        String[] goal ={"i", "want", "to", "drink", "water"};
        System.out.println(solution(cards1, cards2,goal));
    }

    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";

        int index1 = 0;
        int index2 = 0;

        for(int i = 0; i < goal.length; i++){
            if(index1 < cards1.length && goal[i].equals(cards1[index1])){
                index1++;
            }else if(index2 < cards2.length && goal[i].equals(cards2[index2])){
                index2++;
            }else{
                return "No";
            }
        }
        return answer;
    }
}
