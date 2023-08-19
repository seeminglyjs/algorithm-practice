package com.algorithm.practice.algorithmpractice.programmers.Case_ver2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
public class a20230819_숫자문자열과영단어 {
    @Test
    public void test(){
        System.out.println(solution("one4seveneight"));
    }

    public int solution(String s) {
        StringBuilder sb = new StringBuilder(); //결과를 담을 변수
        StringBuilder sbStrNum = new StringBuilder(); //임시 문자열을 담을 변수

        String [] sArr = s.split("");
        Set<String> strNumSet = new HashSet<String>();
        strNumSet.add("0");
        strNumSet.add("1");
        strNumSet.add("2");
        strNumSet.add("3");
        strNumSet.add("4");
        strNumSet.add("5");
        strNumSet.add("6");
        strNumSet.add("7");
        strNumSet.add("8");
        strNumSet.add("9");

        Map<String, Integer> numStrMap = new HashMap<String, Integer>();
        numStrMap.put("zero", 0);
        numStrMap.put("one", 1);
        numStrMap.put("two", 2);
        numStrMap.put("three", 3);
        numStrMap.put("four", 4);
        numStrMap.put("five", 5);
        numStrMap.put("six", 6);
        numStrMap.put("seven", 7);
        numStrMap.put("eight", 8);
        numStrMap.put("nine", 9);

        for (String str : sArr) {
            if(strNumSet.contains(str)) sb.append(str); // 단순 숫자 문자열일 경우
            else{
                sbStrNum.append(str);
                if(numStrMap.containsKey(sbStrNum.toString())) {
                    sb.append(numStrMap.get(sbStrNum.toString()));
                    sbStrNum = new StringBuilder(); //객체초기화
                }
            }
        }

        return Integer.parseInt(sb.toString());
    }
}
