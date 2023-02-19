package com.algorithm.practice.algorithmpractice.CodeWars;


import org.junit.jupiter.api.Test;

public class Case_01_7kyu { // String ends with?

    //Complete the solution so that it returns true if the first argument(string) passed in ends with the 2nd argument (also a string).

    @Test
    public void staticTests() {
        check("samurai", "ai", true);
        check("sumo", "omo", false);
        check("ninja", "ja", true);
        check("sensei", "i", true);
        check("samurai", "ra", false);
        check("abc", "abcd", false);
        check("abc", "abc", true);
        check("abcabc", "bc", true);
        check("ails", "fails", false);
        check("fails", "ails", true);
        check("this", "fails", false);
        check("this", "", true);
        check(":-)", ":-(", false);
        check("!@#$%^&*() :-)", ":-)", true);
        check("abc\n", "abc", false);
    }
    private static void check(String str, String ending, boolean expected) {
        boolean result = solution(str, ending);
        System.out.println(result);
    }
    public static boolean solution(String str, String ending) {
//        return str.endsWith(ending);
        if(str.length()<ending.length()){return false;}
        return str.substring((str.length() - ending.length())).equals(ending);
    }
}
