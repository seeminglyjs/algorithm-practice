package com.algorithm.practice.algorithmpractice.programmers.Case_ver2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootTest
public class a20230919_신규아이디추천 {

    //https://school.programmers.co.kr/learn/courses/30/lessons/72410
    @Test
    public void Test() {

        String new_id = "=.=";
        System.out.println(solution(new_id));
    }

    public String solution(String new_id) {
        //조건1
        new_id = new_id.toLowerCase();
        //조건2
        String regex = "[^a-z0-9\\-_.]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(new_id);
        new_id = matcher.replaceAll("");
        //조건3
        int dotCnt = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < new_id.length(); i++) {
            if (new_id.charAt(i) == '.') {
                dotCnt++;
            } else {
                if (dotCnt >= 1) {
                    sb.append(".");
                    sb.append(new_id.charAt(i));
                    dotCnt = 0;
                } else {
                    sb.append(new_id.charAt(i));
                }
            }
        }
        new_id = sb.toString();
        //조건4
        if(new_id.length() > 0){
            if(new_id.charAt(0) == '.'){new_id = new_id.substring(1,new_id.length());}
            if(new_id.charAt(new_id.length()-1) == '.'){new_id = new_id.substring(0,new_id.length()-1);}
        }
        //조건5
        if (new_id.equals("")){new_id = "a";}
        //조건6
        if(new_id.length() > 15){ new_id = new_id.substring(0,15);}
        if(new_id.charAt(new_id.length()-1) == '.'){new_id = new_id.substring(0,new_id.length()-1);}
        //조건7
        if(new_id.length() <= 2){
            while (new_id.length() < 3){
                new_id += new_id.charAt(new_id.length()-1);
            }
        }
        return new_id;
    }

}
