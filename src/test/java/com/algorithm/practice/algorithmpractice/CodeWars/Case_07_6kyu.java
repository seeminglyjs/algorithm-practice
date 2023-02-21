package com.algorithm.practice.algorithmpractice.CodeWars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Case_07_6kyu { //Character with longest consecutive repetition

    //   For a given string s find the character c (or C) with longest consecutive repetition and return:
//
//         Object[]{c, l};
//   where l (or L) is the length of the repetition. If there are two or more characters with the same l return the first in order of appearance.
//
//   For empty string return:
//
//         Object[]{"", 0}
//   In JavaScript: If you use Array.sort in your solution, you might experience issues with the random tests as Array.sort is not stable in the Node.js version used by CodeWars. This is not a kata issue.
//
//   Happy coding! :)

    @Test
    public void exampleTests() {
        assertArrayEquals(new Object[]{"a", 4}, longestRepetition("aaaabb"));
        assertArrayEquals(new Object[]{"a", 4}, longestRepetition("bbbaaabaaaa"));
        assertArrayEquals(new Object[]{"u", 3}, longestRepetition("cbdeuuu900"));
        assertArrayEquals(new Object[]{"b", 5}, longestRepetition("abbbbb"));
        assertArrayEquals(new Object[]{"a", 2}, longestRepetition("aabb"));
        assertArrayEquals(new Object[]{"", 0}, longestRepetition(""));
        assertArrayEquals(new Object[]{"0", 1}, longestRepetition("0"));
        assertArrayEquals(new Object[]{"d", 10}, longestRepetition("0123kldddddw2kkkkk83dddddddddd"));        assertArrayEquals(new Object[]{"a", 4}, longestRepetition("aaaabb"));

        assertArrayEquals(new Object[]{"a", 4}, longestRepetition2("bbbaaabaaaa"));
        assertArrayEquals(new Object[]{"u", 3}, longestRepetition2("cbdeuuu900"));
        assertArrayEquals(new Object[]{"b", 5}, longestRepetition2("abbbbb"));
        assertArrayEquals(new Object[]{"a", 2}, longestRepetition2("aabb"));
        assertArrayEquals(new Object[]{"", 0}, longestRepetition2(""));
        assertArrayEquals(new Object[]{"0", 1}, longestRepetition2("0"));
        assertArrayEquals(new Object[]{"d", 10}, longestRepetition2("0123kldddddw2kkkkk83dddddddddd"));
    }

    public static Object[] longestRepetition(String s) {
        int len = s.length(); //문자열 전체길이
        int count = 0; //최대연속된 변수 저장
        if (s.equals("")) return new Object[]{"", 0};
        else {
            char res = s.charAt(0);
            for (int i = 0; i < len; i++) {
                int cur_count = 1; //현재 카운트 변수 확인
                for (int j = i + 1; j < len; j++) {
                    if (s.charAt(i) != s.charAt(j)) break;
                    cur_count++;
                }
                if (cur_count > count) {
                    count = cur_count;
                    res = s.charAt(i);
                }
            }
            return new Object[]{String.valueOf(res), count};
        }
    }

    public static Object[] longestRepetition2(String s) {
        if (s.equals("")) return new Object[]{"", 0};
        else {
        char current = s.charAt(0);
        char result =  s.charAt(0);
        int low = 1;
        int max = 1;
            for (int i = 1; i < s.length(); i++) {
                if (current == s.charAt(i)) {
                    max++;
                } else {
                    max = 1;
                }
                if (max > low) {
                    low = max;
                    result = current;
                }
                current = s.charAt(i);
            }
            return new Object[]{String.valueOf(result), low};
        }
    }

}
