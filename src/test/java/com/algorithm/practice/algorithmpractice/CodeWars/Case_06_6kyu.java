package com.algorithm.practice.algorithmpractice.CodeWars;

import org.junit.jupiter.api.Test;

import static org.testng.AssertJUnit.assertEquals;

public class Case_06_6kyu {//Persistent Bugger.
//    Write a function, persistence, that takes in a positive parameter num and returns its multiplicative persistence, which is the number of times you must multiply the digits in num until you reach a single digit.
//
//    For example (Input --> Output):
//
//            39 --> 3 (because 3*9 = 27, 2*7 = 14, 1*4 = 4 and 4 has only one digit)
//            999 --> 4 (because 9*9*9 = 729, 7*2*9 = 126, 1*2*6 = 12, and finally 1*2 = 2)
//            4 --> 0 (because 4 is already a one-digit number)

//    @Test
//    public void test(){
//        System.out.println(3/10);
//    }

    @Test
    public void BasicTests() {
        System.out.println("****** Basic Tests ******");
        assertEquals(2, persistence(427245));
        assertEquals(0, persistence(4));
        assertEquals(2, persistence(25));
        assertEquals(4, persistence(999));
    }

    public static int persistence(long n) {
        int count = 0;
        if (n < 10) return count;
        while (true) {
            long temp = 1;
            String check = String.valueOf(n);
            String [] arr = check.split("");
            for (int i = 0; i < arr.length; i++){
//                temp *= Integer.parseInt(arr[i]) != 0 ? Integer.parseInt(arr[i]) : 1; //0따로 구분할 필요 없었음 ㅠㅠㅠㅠ
                temp *= Integer.parseInt(arr[i]);
            }
            count++;
            if (temp < 10){ break;}
            else n = temp;
        }
        return count;
    }
}
