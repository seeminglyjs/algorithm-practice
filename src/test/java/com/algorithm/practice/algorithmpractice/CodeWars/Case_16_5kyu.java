package com.algorithm.practice.algorithmpractice.CodeWars;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.testng.AssertJUnit.*;

public class Case_16_5kyu { //What's a Perfect Power anyway?

//    A perfect power is a classification of positive integers:
//
//    In mathematics, a perfect power is a positive integer that can be expressed as an integer power of another positive integer. More formally, n is a perfect power if there exist natural numbers m > 1, and k > 1 such that mk = n.
//
//    Your task is to check wheter a given integer is a perfect power. If it is a perfect power, return a pair m and k with mk = n as a proof. Otherwise return Nothing, Nil, null, NULL, None or your language's equivalent.
//
//    Note: For a perfect power, there might be several pairs. For example 81 = 3^4 = 9^2, so (3,4) and (9,2) are valid solutions. However, the tests take care of this, so if a number is a perfect power, return any pair that proves it.
//
//            Examples
//    isPerfectPower(4) => new int[]{2,2}
//    isPerfectPower(5) => null
//    isPerfectPower(8) => new int[]{2,3}
//    isPerfectPower(9) => new int[]{3,2}
@Test
public void test0() {
    assertNull("0 is not a perfect number", PerfectPower.isPerfectPower(0));
}

    @Test
    public void test1() {
        assertNull("1 is not a perfect number", PerfectPower.isPerfectPower(1));
    }

    @Test
    public void test2() {
        assertNull("2 is not a perfect number", PerfectPower.isPerfectPower(2));
    }

    @Test
    public void test3() {
        assertNull("3 is not a perfect number", PerfectPower.isPerfectPower(3));
    }

    @Test
    public void test4() {
        assertArrayEquals("4 = 2^2", new int[]{2,2}, PerfectPower.isPerfectPower(4));
    }

    @Test
    public void test5() {
        assertNull("5 is not a perfect power", PerfectPower.isPerfectPower(5));
    }

    @Test
    public void test8() {
        assertArrayEquals("8 = 2^3", new int[]{2,3}, PerfectPower.isPerfectPower(8));
    }

    @Test
    public void test9() {
        assertArrayEquals("9 = 3^2", new int[]{3,2}, PerfectPower.isPerfectPower(9));
    }

    @Test
    public void test11(){
        int n = 434391;
        System.out.println(Math.pow(434391, 1.0 / 2));
        PerfectPower.isPerfectPower(n);
    }

    class PerfectPower {
        public static int[] isPerfectPower(int n) {
            for (int i = 2;; i++) {
                int root = (int) Math.round(Math.pow(n, 1.0 / i));
                System.out.println(root);
                if (root < 2)
                    return null;
                if (Math.pow(root, i) == n)
                    return new int[] { root, i };
            }
        }
    }


    public class PerfectPower2 { //timeout
        public static int[] isPerfectPower(int n) {
            if(n == 1 || n == 2 || n == 3 || n == 5 || n == 6 || n == 7) return null;
            if(n == 4) return new int [] {2,2};
            int a = 0; int b= 0;
            int cntA = (int) Math.sqrt(n);
            int cntB = 2;
            String result = "";
            loop : while(true){
                if(cntA >= n/2) break;
                if(n % cntA == 0){
                    while (true){
                        long pow = (long) Math.pow(cntA,cntB);
                        if(pow == n){
                            return new int [] {cntA,cntB};
                        } else if (pow > n) break;
                        else cntB++;
                    }
                }
                cntB = 2;
                cntA--;
            }
            return null;
        }
    }
}
