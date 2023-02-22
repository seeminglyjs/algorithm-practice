package com.algorithm.practice.algorithmpractice.CodeWars;

import java.util.stream.IntStream;

public class Case_09_6kyu { //    Multiples of 3 or 5

    //    If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
//
//    Finish the solution so that it returns the sum of all the multiples of 3 or 5 below the number passed in. Additionally, if the number is negative, return 0 (for languages that do have them).
//
//    Note: If the number is a multiple of both 3 and 5, only count it once.
//
//    Courtesy of projecteuler.net (Problem 1)

    public int solution(int number) {
        if (number <= 0) {
            return 0;
        }
        int sum = 0;
        int three = 3;
        int five = 5;
        boolean threeFlag = true;
        boolean fiveFlag = true;
        while (threeFlag || fiveFlag) {
            if (number > three) {
                sum += three;
                three += 3;
            } else threeFlag = false;
            if (number > five) {
                sum += five;
                five += 5;
            } else fiveFlag = false;
        }
        int fifteen = 15;
        while (number > fifteen) {
            sum -= fifteen;
            fifteen += 15;
        }
        return sum;
    }

    public int solution2(int number) {
        int sum = 0;
        for (int i = 0; i < number; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public int solution3(int number) {
        return IntStream.range(0, number)
                .filter(n -> (n % 3 == 0) || (n % 5 == 0))
                .sum();
    }

}
