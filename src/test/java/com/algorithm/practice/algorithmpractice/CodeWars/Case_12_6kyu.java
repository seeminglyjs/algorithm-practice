package com.algorithm.practice.algorithmpractice.CodeWars;

import org.junit.jupiter.api.Test;

import static org.testng.AssertJUnit.assertEquals;

public class Case_12_6kyu { // Consecutive strings
    private static void testing(String actual, String expected) {
        assertEquals(expected, actual);
    }
    @Test
    public void test() {
        System.out.println("longestConsec Fixed Tests");
        testing(longestConsec(new String[] {"zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail"}, 2), "abigailtheta");
        testing(longestConsec(new String[] {"ejjjjmmtthh", "zxxuueeg", "aanlljrrrxx", "dqqqaaabbb", "oocccffuucccjjjkkkjyyyeehh"}, 1), "oocccffuucccjjjkkkjyyyeehh");
        testing(longestConsec(new String[] {}, 3), "");
        testing(longestConsec(new String[] {"itvayloxrp","wkppqsztdkmvcuwvereiupccauycnjutlv","vweqilsfytihvrzlaodfixoyxvyuyvgpck"}, 2), "wkppqsztdkmvcuwvereiupccauycnjutlvvweqilsfytihvrzlaodfixoyxvyuyvgpck");
        testing(longestConsec(new String[] {"wlwsasphmxx","owiaxujylentrklctozmymu","wpgozvxxiu"}, 2), "wlwsasphmxxowiaxujylentrklctozmymu");
        testing(longestConsec(new String[] {"zone", "abigail", "theta", "form", "libe", "zas"}, -2), "");
        testing(longestConsec(new String[] {"it","wkppv","ixoyx", "3452", "zzzzzzzzzzzz"}, 3), "ixoyx3452zzzzzzzzzzzz");
        testing(longestConsec(new String[] {"it","wkppv","ixoyx", "3452", "zzzzzzzzzzzz"}, 15), "");
        testing(longestConsec(new String[] {"it","wkppv","ixoyx", "3452", "zzzzzzzzzzzz"}, 0), "");
    }

    public static String longestConsec(String[] strarr, int k) {
        if(k > strarr.length || k <=0 ) return  "";
        StringBuilder sbResult = new StringBuilder();
        StringBuilder sbNow = new StringBuilder();
        int index = 0;
        for (int i = 0; i < strarr.length; i++) {
            if(i <= k-1){
                sbNow.append(strarr[i]);
                if ( i == k -1) sbResult = sbNow;
            }else{
                sbNow = new StringBuilder(sbNow.substring(strarr[index].length()));
                index++;
                sbNow.append(strarr[i]);
                if(sbResult.toString().length() < sbNow.toString().length()) sbResult = sbNow;
            }
        }
        return sbResult.toString();
    }
}
