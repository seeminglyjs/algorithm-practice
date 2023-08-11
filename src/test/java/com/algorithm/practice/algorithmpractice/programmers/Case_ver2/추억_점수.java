package com.algorithm.practice.algorithmpractice.programmers.Case_ver2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

@SpringBootTest
public class 추억_점수 {
    //https://school.programmers.co.kr/learn/courses/30/lessons/176963

    @Test
    public void test() {
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {
                {"may", "kein", "kain", "radi"},
                {"may", "kein", "brin", "deny"},
                {"kon", "kain", "may", "coni"}};

        int[] answer = solution(name, yearning, photo);

        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }


    }

    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];

        HashMap<String, Integer> nameAndYearning = new HashMap<String, Integer>();
        for (int i = 0; i < name.length; i++) {
            nameAndYearning.put(name[i], yearning[i]);
        }

        for (int i = 0; i < photo.length; i++) {
            int sum = 0;
            for (int j = 0; j < photo[i].length; j++) {
                if(nameAndYearning.containsKey(photo[i][j]))sum += nameAndYearning.get(photo[i][j]);
            }
            answer[i] = sum;
        }

        return answer;
    }
}
