package com.algorithm.practice.algorithmpractice.programmers.Case_ver2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class a20230904_로또의최고순위와최저순위 {
        //https://school.programmers.co.kr/learn/courses/30/lessons/77484

    public int[] solution(int[] lottos, int[] win_nums) {
        Set<Integer> winNumsSet = new HashSet<>();
        for (int num : win_nums) winNumsSet.add(num);
        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;
        for(int i = 6; i >= 1; i--) {rankMap.put(i,rank); rank++;}
        rankMap.put(0,6);

        int zeroCnt = 0;
        int matchCnt = 0;
        for (int lotto : lottos) {
            if (winNumsSet.contains(lotto)) matchCnt += 1;
            else if (lotto == 0) zeroCnt += 1;
        }
        return new int[]{rankMap.get(matchCnt + zeroCnt), rankMap.get(matchCnt)};
    }
}
