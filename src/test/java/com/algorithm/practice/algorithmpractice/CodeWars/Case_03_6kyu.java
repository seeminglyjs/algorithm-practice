package com.algorithm.practice.algorithmpractice.CodeWars;

import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;

public class Case_03_6kyu { //Mexican Wave
//    Task
//    In this simple Kata your task is to create a function that turns a string into a Mexican Wave. You will be passed a string and you must return that string in an array where an uppercase letter is a person standing up.
//    Rules
// 1.  The input string will always be lower case but maybe empty.
//
// 2.  If the character in the string is whitespace then pass over it as if it was an empty seat
//            Example
//    wave("hello") => {"Hello", "hEllo", "heLlo", "helLo", "hellO"}


    @Test
    public void basicTest1() {
        String[] result = new String[] { "Hello", "hEllo", "heLlo", "helLo", "hellO" };
        assertArrayEquals("it should return '" + Arrays.toString(result) + "'", result, wave("hello"));
    }

    @Test
    public void basicTest2() {
        String[] result = new String[] { "Codewars", "cOdewars", "coDewars", "codEwars", "codeWars", "codewArs", "codewaRs", "codewarS" };
        assertArrayEquals("it should return '" + Arrays.toString(result) + "'", result, wave("codewars"));
    }

    @Test
    public void basicTest3() {
        String[] result = new String[] { };
        assertArrayEquals("it should return '" + Arrays.toString(result) + "'", result, wave(""));
    }

    @Test
    public void basicTest4() {
        String[] result = new String[] { "Two words", "tWo words", "twO words", "two Words", "two wOrds", "two woRds", "two worDs", "two wordS" };
        assertArrayEquals("it should return '" + Arrays.toString(result) + "'", result, wave("two words"));
    }

    @Test
    public void basicTest5() {
        String[] result = new String[] { " Gap ", " gAp ", " gaP " };
        assertArrayEquals("it should return '" + Arrays.toString(result) + "'", result, wave(" gap "));
    }

    public static String[] wave(String str) {
        String[] arr = {};
        if (str == null || str.equals("")) {
            return arr;
        }
        String result = "";
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < str.length(); i++) {
            sb.replace(i, i + 1, sb.substring(i, i + 1).toUpperCase());
            if (!str.equals(sb.toString())) {
                result += sb.toString() + "@@";
                System.out.println(result);
            }
            sb = new StringBuilder(str);
        }
        arr = result.split("@@");
        return arr;

//        return IntStream
//                .range(0, str.length())
//                .mapToObj(x -> new StringBuilder(str).replace(x, x+1, String.valueOf(str.charAt(x)).toUpperCase()).toString())
//                .filter(x -> !x.equals(str))
//                .toArray(String[]::new);

    }

}
