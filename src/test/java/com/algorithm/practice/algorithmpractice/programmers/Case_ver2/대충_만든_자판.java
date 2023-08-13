package com.algorithm.practice.algorithmpractice.programmers.Case_ver2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
public class 대충_만든_자판 {


    @Test
    public void test() {
        String[] keymap = {"ABACD", "BCEFD"};
        String[] targets = {"ABCD", "AABB"};
        TestUtil.printArr(solution(keymap, targets));
    }

    public Integer[] solution(String[] keymap, String[] targets) {
        Integer[] answer = new Integer[targets.length];
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String s : keymap) { //키 정보 맵에 저장
            char[] charArr = s.toCharArray();
            for (int j = 0; j < charArr.length; j++) {
                if (!map.containsKey(String.valueOf(charArr[j]))) {
                    map.put(String.valueOf(charArr[j]), j + 1);
                }else{
                    int cnt = map.get(String.valueOf(charArr[j]));
                    if(cnt > j){
                        map.put(String.valueOf(charArr[j]), j + 1);
                    }
                }
            }
        }

        int index = 0;
        for (String target : targets) {
            char[] charArr = target.toCharArray();
            int sum = 0;
            for (char c : charArr) {
                if (map.containsKey(String.valueOf(c))) {
                    sum += map.get(String.valueOf(c));
                }else {
                    sum = 0;
                    break;
                }
            }
            answer[index] = sum == 0 ? -1 : sum;
            index++;
        }

        return answer;
    }
}
