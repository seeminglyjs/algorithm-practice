package com.algorithm.practice.algorithmpractice.programmers.Case_ver2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.stream.Collectors;

@SpringBootTest
public class a20230923_체육복 {

    //https://school.programmers.co.kr/learn/courses/30/lessons/42862
    @Test
    public void Test() {
        int n = 5;
        int[] lost = {2,4};
        int[] reserve = {1, 3, 5};

        System.out.println(solution(n,lost,reserve));
    }

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;

        List<Integer> integerList =  Arrays.stream(lost)
                .boxed()
                .collect(Collectors.toList());


        Map<Integer, Boolean> originReverseMap = new HashMap<>();
        for (int j : reserve) {
            if(!integerList.contains(j)) originReverseMap.put(j, true);
            else integerList.remove(integerList.indexOf(j));
        }

        int index = 0;
        int maxCoverLost = integerList.size();

        while(index < integerList.size()){
            int coverLost = integerList.size();
            Map<Integer, Boolean> duplication = new HashMap<>(originReverseMap); // 복사됨

            for(int i = index; i < integerList.size(); i++){
                coverLost = getCoverLost(integerList, duplication, i, coverLost);
            }

            for(int i = 0; i < index; i++){
                coverLost = getCoverLost(integerList, duplication, i, coverLost);
            }

            if(maxCoverLost > coverLost) maxCoverLost = coverLost;
            index++;
        }

        return answer - maxCoverLost;
    }

    private static int getCoverLost(List<Integer>integerList, Map<Integer, Boolean> duplication, int i, int coverLost) {
        if(duplication.containsKey(integerList.get(i)) && duplication.get(integerList.get(i))){
            duplication.put(integerList.get(i), false);
            coverLost--;
        } else if (duplication.containsKey(integerList.get(i) - 1) && duplication.get(integerList.get(i)-1)) {
            duplication.put(integerList.get(i) - 1, false);
            coverLost--;
        } else if (duplication.containsKey(integerList.get(i) + 1) && duplication.get(integerList.get(i)+1)) {
            duplication.put(integerList.get(i) + 1, false);
            coverLost--;
        }
        return coverLost;
    }
}
