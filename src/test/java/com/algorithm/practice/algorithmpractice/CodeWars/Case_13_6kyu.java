package com.algorithm.practice.algorithmpractice.CodeWars;

import org.junit.jupiter.api.Test;

import static org.testng.AssertJUnit.assertEquals;

public class Case_13_6kyu { //    CamelCase Method

//            Java
//17
//    VIM
//            EMACS
//    Instructions
//            Output
//    Write simple .camelCase method (camel_case function in PHP, CamelCase in C# or camelCase in Java) for strings. All words must have their first letter capitalized without spaces.
//
//    For instance:
//
//    camelCase("hello case"); // => "HelloCase"
//    camelCase("camel case word"); // => "CamelCaseWord"
//    Don't forget to rate this kata! Thanks :)
//
    @Test
    public void testTwoWords() {
        assertEquals("TestCase", camelCase("test case"));
    }
    @Test
    public void testThreeWords() {
        assertEquals("CamelCaseMethod", camelCase("camel case method"));
    }
    @Test
    public void testLeadingSpace() {
        assertEquals("CamelCaseWord", camelCase(" camel case word"));
    }
    @Test
    public void testTrailingSpace() {
        assertEquals("SayHello", camelCase("say hello "));
    }
    @Test
    public void testSingleLetter() {
        assertEquals("Z", camelCase("z"));
    }

    @Test
    public void testTwoSpacesBetweenWords() {
        assertEquals("AbC", camelCase("ab  c"));
    }

    @Test
    public void testEmptyString() {
        assertEquals("", camelCase(""));
    }

    public static String camelCase(String str) {
        if(str.equals("")) return "";
        StringBuilder result = new StringBuilder();
        String [] strArr = str.split(" ");
        String temp = "";
        for (int i = 0; i < strArr.length; i++) {
            temp = "";
            if(!strArr[i].equals("")){
                temp += strArr[i].charAt(0);
                temp = temp.toUpperCase();
                if(strArr[i].length() > 1)temp += strArr[i].substring(1);
            }
            result.append(temp);
        }

        return result.toString();
    }
}
