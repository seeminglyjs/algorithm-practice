package com.algorithm.practice.algorithmpractice.CodeWars;

import org.junit.jupiter.api.Test;

import static org.testng.AssertJUnit.assertEquals;

public class Case_05_7kyu { //Exes and Ohs
//    Check to see if a string has the same amount of 'x's and 'o's. The method must return a boolean and be case insensitive. The string can contain any char.
//
//    Examples input/output:
//
//    XO("ooxx") => true
//    XO("xooxx") => false
//    XO("ooxXm") => true
//    XO("zpzpzpp") => true // when no 'x' and 'o' is present should return true
//    XO("zzoo") => false

    @Test
    public void testSomething1() {
        assertEquals(true, getXO("xxxooo"));
    }

    @Test
    public void testSomething2() {
        assertEquals(true, getXO("xxxXooOo"));
    }

    @Test
    public void testSomething3() {
        assertEquals(false, getXO("xxx23424esdsfvxXXOOooo"));
    }

    @Test
    public void testSomething4() {
        assertEquals(false, getXO("xXxxoewrcoOoo"));
    }

    @Test
    public void testSomething5() {
        assertEquals(false, getXO("XxxxooO"));
    }

    @Test
    public void testSomething6() {
        assertEquals(true, getXO("zssddd"));
    }

    @Test
    public void testSomething7() {
        assertEquals(false, getXO("Xxxxertr34"));
    }

    public static boolean getXO (String str) {
        int xCnt = 0;
        int oCnt = 0;

        for (int i = 0; i < str.length(); i++){
            String temp = String.valueOf(str.charAt(i)).toUpperCase();
            if(temp.equals("X")){
                xCnt++;
            } else if (temp.equals("O")) {
                oCnt++;
            }
        }
        return xCnt == oCnt;

//        str = str.toLowerCase();
//        return str.replace("o","").length() == str.replace("x","").length();
    }
}
