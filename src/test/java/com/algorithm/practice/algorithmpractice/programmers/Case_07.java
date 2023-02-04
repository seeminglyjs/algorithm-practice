package com.algorithm.practice.algorithmpractice.programmers;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Case_07 {// 가장 큰 수 Arrays.sort / compareTo 사용
//    가장 큰 수
//    문제 설명
//0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
//
//    예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.
//
//0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.
//
//    제한 사항
//    numbers의 길이는 1 이상 100,000 이하입니다.
//    numbers의 원소는 0 이상 1,000 이하입니다.
//    정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
//            입출력 예
//    numbers	return
//            [6, 10, 2]	"6210"
//            [3, 30, 34, 5, 9]	"9534330"

    @Test
    public void test() {
        int[] numbers = {1,1,1,1,1,3,0,5,5,1231,432423,931};
        System.out.println(solution(numbers));
    }
    public String solution(int[] numbers) {
        String answer = "";
        //문자열 리턴을 해줄 스트링배열 생성
        String[] str = new String[numbers.length];

        //int배열 String배열로 변환
        for(int i = 0; i < numbers.length; i++){
            str[i] = String.valueOf(numbers[i]);
        }

        //내림차순 정렬
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return (b+a).compareTo(a+b);
                //오름차순 정렬 (o1+o2).compareTo(o1+o2);
            }
        });

        //0값이 중복일경우 ex){0,0,0}
        //답이 000이 나오면 안되므로 첫번째값이 0이면 0을 리턴
        if (str[0].equals("0")) return "0";

        //0이 아니면 문자열을 더해준다.
        for(String s: str) answer += s;

        return answer;
    }
    public String solution2(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        HashMap<Integer,String> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            map.put(i, String.valueOf(numbers[i]));
        }

        String max = map.get(0);
        Set<Integer> mapKeySet = map.keySet();
        int firstIndex = 0;
        loop:
        while (true) {
            if (mapKeySet.size() == 1) { //키셋 사이즈가 1일 경우
                answer.append(map.get(mapKeySet.iterator().next()));
                break loop;
            }
            Stack<Integer> descStack = new Stack<>();
            for (int key : mapKeySet) {
                if (key != firstIndex && (Long.parseLong(max + map.get(key)) < Long.parseLong(map.get(key) + max))) {
                    System.out.println(Long.parseLong(max + map.get(key)) + " / " + Long.parseLong(map.get(key) + max));
                    descStack.push(key);
                    max = map.get(key);
                }else if(key != firstIndex && (Long.parseLong(max + map.get(key)) == Long.parseLong(map.get(key) + max))){
                    if(!descStack.isEmpty()){
                        if(map.get(descStack.peek()).equals(map.get(key))){
                            descStack.push(key);
                        }
                    }
                }
            }
            System.out.println("-----------------------------");
            if(descStack.isEmpty()){
                answer.append(map.remove(firstIndex));
            }else{
                while (!descStack.isEmpty()) {//내림차순 순으로 값을 더해줌
                    answer.append(map.remove(descStack.pop()));
                }
            }
            mapKeySet = map.keySet(); //새로운 키셋할당
            firstIndex = mapKeySet.iterator().next();
            max = map.get(firstIndex); //새로운 최대값 초기화
//            System.out.println(answer);
        }
        if (answer.substring(0, 1).equals("0")) {
            return "0";
        }
        return answer.toString();
    }
}

//                if (max.length() > list.get(i).length()) {
//                    StringBuilder temp = new StringBuilder(list.get(i));
//                    temp.append(String.valueOf(list.get(i).charAt(0)).repeat(Math.max(0, max.length() - (list.get(i).length() - 1))));
//                    if (Integer.parseInt(max) < Integer.parseInt(temp.toString())) {
//                        System.out.println("maxLen" +temp.toString());
//                        maxIndex = i;
//                        max = list.get(i);
//                        System.out.println(max);
//                    }
//                }else if(max.length() < list.get(i).length()){
//                    StringBuilder temp = new StringBuilder(max);
//                    temp.append(String.valueOf(max.charAt(0)).repeat(Math.max(0, max.length() - (max.length() - 1))));
//                    if (Integer.parseInt(temp.toString()) < Integer.parseInt(list.get(i))) {
//                        System.out.println("listLen" +temp.toString());
//                        maxIndex = i;
//                        max = list.get(i);
//                        System.out.println(max);
//                    }
//                }else{
//                    if (Integer.parseInt(max) < Integer.parseInt(list.get(i))) {
//                        System.out.println("max" + list.get(i));
//                        maxIndex = i;
//                        max = list.get(i);
//                        System.out.println(max);
//                    }
//                }

