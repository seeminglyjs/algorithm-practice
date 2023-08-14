package com.algorithm.practice.algorithmpractice.programmers.Case_ver2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@SpringBootTest
public class a20230813_둘만의_암호 {
    @Test
    public void test() {
        String s = "aukks";
        String skip = "a";
        int index = 1;
        System.out.println(solution(s, skip, index));
    }

    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        Set<Character> skipSet = new HashSet<Character>();
        for (int i = 0; i < skip.length(); i++) {
            skipSet.add(skip.charAt(i));
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int idx = 0;
            int skipC = 0;
            int cnt = 1;

            while (true) {
                if (c + cnt >= 123) { c = Character.toChars(c - 26)[0];}
                if (skipSet.contains(Character.toChars(c + cnt)[0])) {
                    skipC++;
                } else {
                    idx++;
                    if (index <= idx) break;
                }
                cnt++;
            }
            c = Character.toChars(c + idx + skipC)[0];
            answer.append(c);
        }
        return answer.toString();
    }


}
