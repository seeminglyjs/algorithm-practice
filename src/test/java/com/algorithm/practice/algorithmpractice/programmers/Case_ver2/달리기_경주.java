package com.algorithm.practice.algorithmpractice.programmers.Case_ver2;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

@SpringBootTest
public class 달리기_경주 {
    //https://school.programmers.co.kr/learn/courses/30/lessons/178871?language=java

    @Test
    public void test(){
        String [] players = {"mumu", "soe", "poe", "kai", "mine"};
        String [] callings = {"kai", "kai", "mine", "mine"};

        String [] answer = solution(players, callings);
        for (int i = 0; i < answer.length; i++){
            System.out.println(answer[i]);
        }


    }


    public String[] solution(String[] players, String[] callings) {
        String [] answer = new String[players.length];
        HashMap<String, Integer> names = new HashMap<>();
        HashMap<Integer, String> ranks = new HashMap<>();
        for(int i = 0; i < players.length; i ++){
            names.put(players[i], i);
            ranks.put(i, players[i]);
        }

        for (String calling : callings) {
             int index = names.get(calling);
             String frontPlayer = ranks.get(index -1);

            names.put(calling, index-1);
            names.put(frontPlayer, index);

            ranks.put(index, frontPlayer);
            ranks.put(index-1, calling);
        }


        for(int i = 0; i < players.length; i++){
            answer[i] = ranks.get(i);
        }

        return answer;
    }


    /**
     * 시간초과 정확성 100
     *
     * @param players
     * @param callings
     * @return
     */
    public String[] solution2(String[] players, String[] callings) {
        HashMap<String, Integer> nowRace = new HashMap<>();
        LinkedList<String> names = new LinkedList<>(Arrays.asList(players));
        for(int i = 0; i < players.length; i ++){
            nowRace.put(players[i], i);
        }

        for (String calling : callings) {
            int index = nowRace.get(calling);
            if (index != 0) {//추월 사람 위치 변경
                String goName = names.get(index);
                String backName = names.get(index - 1);
                names.set(index - 1, goName);
                names.set(index, backName);

                nowRace.put(backName, index);
                nowRace.put(goName, index-1);
            }
        }
        return names.toArray(new String[0]);
    }
}
