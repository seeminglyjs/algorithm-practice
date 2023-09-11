package com.algorithm.practice.algorithmpractice.programmers.Case_ver2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class a20230911_키패드누르기 {
    //https://school.programmers.co.kr/learn/courses/30/lessons/67256
    @Test
    public void test(){
        int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand = "left";
        System.out.println(solution(numbers, hand));
    }

    public String solution(int[] numbers, String hand) {
        StringBuilder answer =  new StringBuilder();
        Map<String, String> map = new HashMap<String, String>();
        map.put("1","00");map.put("2","01");map.put("3","02");
        map.put("4","10");map.put("5","11");map.put("6","12");
        map.put("7","20");map.put("8","21");map.put("9","22");
        map.put("*","30");map.put("0","31");map.put("#","33");

        String nowLeft = "*"; String nowRight = "#";
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
                answer.append("L");
                nowLeft = String.valueOf(numbers[i]);
            } else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                answer.append("R");
                nowRight = String.valueOf(numbers[i]);
            }else{
                String [] leftYX = map.get(nowLeft).split("");
                String [] rightYX = map.get(nowRight).split("");
                String [] nowYX = map.get(String.valueOf(numbers[i])).split("");
                //멘하탄 거리
                int leftDistance = Math.abs(Integer.parseInt(leftYX[0]) - Integer.parseInt(nowYX[0])) + Math.abs(Integer.parseInt(leftYX[1]) - Integer.parseInt(nowYX[1]));
                int rightDistance = Math.abs(Integer.parseInt(rightYX[0]) - Integer.parseInt(nowYX[0])) + Math.abs(Integer.parseInt(rightYX[1]) - Integer.parseInt(nowYX[1]));

                if(leftDistance > rightDistance){
                    answer.append("R");
                    nowRight = String.valueOf(numbers[i]);
                }else if (leftDistance < rightDistance){
                    answer.append("L");
                    nowLeft = String.valueOf(numbers[i]);
                }else{
                    answer.append(String.valueOf(hand.charAt(0)).toUpperCase());
                    if(hand.equals("right")) nowRight = String.valueOf(numbers[i]);
                    else nowLeft = String.valueOf(numbers[i]);
                }
            }
        }
        return answer.toString();
    }

}
