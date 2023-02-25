package com.algorithm.practice.algorithmpractice.CodeWars;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class Case_14_5kyu {//    Number of trailing zeros of N!
//    Instructions
//            Output
//    Write a program that will calculate the number of trailing zeros in a factorial of a given number.
//
//    N! = 1 * 2 * 3 *  ... * N
//
//    Be careful 1000! has 2568 digits...
//
//    For more info, see: http://mathworld.wolfram.com/Factorial.html
//
//    Examples
//    zeros(6) = 1
//            # 6! = 1 * 2 * 3 * 4 * 5 * 6 = 720 --> 1 trailing zero
//
//    zeros(12) = 2
//            # 12! = 479001600 --> 2 trailing zeros


    @Test
    public void test() {
        System.out.println(Solution.zeros(500));
    }

    public static int zeros(int n) {
        if (n < 0) return -1;
        int count = 0;
        for (int i = 5; n / i >= 1; i *= 5) count += n / i;
        return count;
    }

    public class Solution {
        public static int zeros(int n) {
            if(n/5 == 0) return 0;
            System.out.println(n);
            return n/5 + zeros(n/5);
                // 500/5 + zeros(500/5) [100] 100 + 24
                    // 100/5 + zeros(100/5) [20] 20 + 4
                        // 20/5 + zeros(20/5) [4] 4 + 0
                            // zeros(4) if(n/5 == 0) return 0; [0]
        }
    }
}


