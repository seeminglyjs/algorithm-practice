package com.algorithm.practice.algorithmpractice.programmers;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class Case_13 { // 옹알이 (2)
//    문제 설명
//    머쓱이는 태어난 지 11개월 된 조카를 돌보고 있습니다. 조카는 아직 "aya", "ye", "woo", "ma" 네 가지 발음과 네 가지 발음을 조합해서 만들 수 있는 발음밖에 하지 못하고 연속해서 같은 발음을 하는 것을 어려워합니다. 문자열 배열 babbling이 매개변수로 주어질 때, 머쓱이의 조카가 발음할 수 있는 단어의 개수를 return하도록 solution 함수를 완성해주세요.
//
//    제한사항
//1 ≤ babbling의 길이 ≤ 100
//            1 ≤ babbling[i]의 길이 ≤ 30
//    문자열은 알파벳 소문자로만 이루어져 있습니다.
//            입출력 예
//    babbling	result
//["aya", "yee", "u", "maa"]	1
//        ["ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"]	2
//    입출력 예 설명
//    입출력 예 #1
//
//            ["aya", "yee", "u", "maa"]에서 발음할 수 있는 것은 "aya"뿐입니다. 따라서 1을 return합니다.
//    입출력 예 #2
//
//            ["ayaye", "uuuma", "yeye", "yemawoo", "ayaayaa"]에서 발음할 수 있는 것은 "aya" + "ye" = "ayaye", "ye" + "ma" + "woo" = "yemawoo"로 2개입니다. "yeye"는 같은 발음이 연속되므로 발음할 수 없습니다. 따라서 2를 return합니다.
//    유의사항
//    네 가지를 붙여 만들 수 있는 발음 이외에는 어떤 발음도 할 수 없는 것으로 규정합니다. 예를 들어 "woowo"는 "woo"는 발음할 수 있지만 "wo"를 발음할 수 없기 때문에 할 수 없는 발음입니다.

    @Test
    public void test(){
        String [] arr = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};
        System.out.println(solution(arr));
    }

    public int solution(String[] babbling) {
        int answer = 0;
        Set<String> word = new HashSet<>();
        word.add("aya");
        word.add("ye");
        word.add("woo");
        word.add("ma");

        for (String temp : babbling) {
            String babble = "";
            String before = "";
            for(int i = 0; i < temp.length(); i++){
                babble += temp.charAt(i);
                //길이가 3이상이면 안되는 단어 들어 있음
                if(babble.length() > 3)break;
                else if(word.contains(babble)){//해당 단어가 들어 있으면 초기화
                    //연속된 단어는 발음 못함
                    if(before.equals(babble))break;
                    else{
                        before=babble;
                        babble ="";
                    }
                }
            }
            if(babble.equals("")){
                answer++;
            }
        }
        return answer;
    }
}
