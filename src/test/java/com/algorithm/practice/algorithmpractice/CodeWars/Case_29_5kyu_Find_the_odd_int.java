package com.algorithm.practice.algorithmpractice.CodeWars;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.testng.AssertJUnit.assertEquals;

@SpringBootTest
public class Case_29_5kyu_Find_the_odd_int { //Best travel


    public static int findIt(int[] a) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int j : a) {
            if (!map.containsKey(j)) {map.put(j, 1);}
            else {map.put(j, map.get(j) + 1);}
        }
        Set<Integer> keySet = map.keySet();
        for(int key : keySet){
            if(map.get(key) % 2 != 0){return key;}
        }
        return -1;
    }

    public class FindOddBestAnswer {
        public static int findIt(int[] A) {
            int xor = 0;
            for (int i = 0; i < A.length; i++) {
                xor ^= A[i];
            }
            return xor;
        }
    }

    @Test
    public void findTest() {
        assertEquals(5, findIt(new int[]{20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5}));
        assertEquals(-1, findIt(new int[]{1,1,2,-2,5,2,4,4,-1,-2,5}));
        assertEquals(5, findIt(new int[]{20,1,1,2,2,3,3,5,5,4,20,4,5}));
        assertEquals(10, findIt(new int[]{10}));
        assertEquals(10, findIt(new int[]{1,1,1,1,1,1,10,1,1,1,1}));
        assertEquals(1, findIt(new int[]{5,4,3,2,1,5,4,3,2,10,10}));
    }
}
