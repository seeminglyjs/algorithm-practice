package com.algorithm.practice.algorithmpractice.CodeWars;


import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class Case_11_5kyu { //Scramblies
//    Complete the function scramble(str1, str2) that returns true if a portion of str1 characters can be rearranged to match str2, otherwise returns false.
//
//    Notes:
//
//    Only lower case letters will be used (a-z). No punctuation or digits will be included.
//    Performance needs to be considered.
//            Examples
//    scramble('rkqodlw', 'world') ==> True
//    scramble('cedewaraaossoqqyt', 'codewars') ==> True
//    scramble('katas', 'steak') ==> False

    private static void testing(boolean actual, boolean expected) {
        assertEquals(expected, actual);
    }

    private static void assertEquals(boolean expected, boolean actual) {
    }

    @Test
    @Order(1)
    public void sampleTests() {
        testing(scramble("rkqodlw","world"), true);
        testing(scramble("cedewaraaossoqqyt","codewars"),true);
        testing(scramble("katas","steak"),false);
        testing(scramble("scriptjavx","javascript"),false);
        testing(scramble("scriptingjava","javascript"),true);
        testing(scramble("scriptsjava","javascripts"),true);
        testing(scramble("javscripts","javascript"),false);
        testing(scramble("aabbcamaomsccdd","commas"),true);
        testing(scramble("commas","commas"),true);
        testing(scramble("sammoc","commas"),true);
    }

    @Test @Order(2)
    public void largeTest() {

        String s1 = "abcdefghijklmnopqrstuvwxyz".repeat(10_000);
        String s2 = "zyxcba".repeat(9_000);

        testing(scramble(s1, s2), true);
    }

    public static boolean scramble2(String str1, String str2) {
        Map<Integer, Integer> cnt = new HashMap<>();
        str2.chars().forEach(i -> cnt.put(i, cnt.getOrDefault(i, 0) + 1));
        str1.chars().filter(i -> cnt.containsKey(i)).forEach(i -> cnt.put(i, cnt.get(i) - 1));
        return cnt.values().stream().filter(i -> i>0).count() == 0;
    }

    public static boolean scramble(String str1, String str2) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < str1.length(); i++){
            char ch = str1.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }else{
                map.put(ch,1);
            }
        }

        for(int i = 0; i < str2.length(); i++){
            char ch = str2.charAt(i);
            if(map.containsKey(ch)){
                if(map.get(ch) <= 0){
                    return false;
                }else{
                    map.put(ch, map.get(ch) -1);
                }
            }else{
                return false;
            }
        }
        return true;
    }
}
