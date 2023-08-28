package com.algorithm.practice.algorithmpractice.programmers.Case_ver2;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class a20230828_개인정보_수집_유효기간 {
    //https://school.programmers.co.kr/learn/courses/30/lessons/150370

    @Test
    public void test(){

        String today = "2020.01.01";
        String[] terms = {"A 1"};
        String[] privacies = {"2019.12.09 A", "2019.12.09 A", "2019.12.09 A", "2019.12.09 A", "2019.12.09 A", "2019.12.09 A", "2019.12.09 A", "2019.12.09 A", "2019.12.09 A", "2019.12.09 A", "2019.12.01 A"};
        int [] arr = solution(today, terms, privacies);
        for (int j : arr) {
            System.out.println(j);
        }
    }

    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};

        String [] todayArr = today.split("\\.");

        int year = Integer.parseInt(todayArr[0]);
        int month = Integer.parseInt(todayArr[1])  ;
        int day = Integer.parseInt(todayArr[2]);

        StringBuilder sb = new StringBuilder();
        int todaySum = (year * 12 * 28) + (month - 1) * 28 + day;

        Map<String, Integer> termsMap = new HashMap<>();
        for (String term : terms) {
            termsMap.put(term.split(" ")[0], Integer.parseInt(term.split(" ")[1]));
        }

        for (int i = 0; i< privacies.length; i++) {
            String term = privacies[i].split(" ")[1];
            String[] privaciesDayArr = privacies[i].split(" ")[0].split("\\.");

            int pYear = Integer.parseInt(privaciesDayArr[0]);
            int pMonth = Integer.parseInt(privaciesDayArr[1]);
            int pDay = Integer.parseInt(privaciesDayArr[2]);

            int pTodaySum = (pYear * 12 * 28) + (pMonth - 1) * 28 + pDay;
            int pLimitSum = pTodaySum + (termsMap.get(term) * 28);
            pLimitSum -=1;
            if (todaySum > pLimitSum) {
                sb.append(i + 1);
                sb.append(" ");
            }
        }
        String [] sbArr = sb.toString().split(" ");
        answer = new int[sbArr.length];
        for (int i = 0; i < sbArr.length; i++){
            answer[i] = Integer.parseInt(sbArr[i]);
        }

        return answer;
    }
}
