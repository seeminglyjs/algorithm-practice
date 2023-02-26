package com.algorithm.practice.algorithmpractice.CodeWars;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Case_17_5kyu { //Is my friend cheating?

    @Test
    public void test11(){
        int n = 100;

        int sum1 = 0;
        for(int i = 0; i <=n ; i++){
            sum1 += i;
        }

        int sum2 = n * (n+1) / 2;

        System.out.println(sum1 + " / " + sum2);
        // 5050 / 5050

    }

    @Test
    public void test99() {
        int a = 12 * 26;
        System.out.println("a ->" + a);

        int b = 0;
        for (int i = 1; i <= 26; i++) {
            b += i;
        }
        b -= 12 + 26;
        System.out.println("b ->" + b);

        List<long[]> list = RemovedNumbers.removNb(26);
        System.out.println(list.get(0)[0] + " / " + list.get(0)[1]);
        System.out.println(list.get(0)[0] + " / " + list.get(0)[1]);
    }

    public class RemovedNumbers {

        public static List<long[]> removNb(long n) {
            // from the instruction:
            // a * b = S(n) - a - b

            // and the sum of all first n natural numbers is
            // S(n) = n * (n + 1) / 2

            // a * b =   n * (n + 1) / 2 - a - b
            // a * b + b = n * (n + 1) / 2 - a
            // b(a + 1) = n * (n + 1) / 2 - a
            // b = (n * (n + 1) / 2 - a) / (a + 1)
            // b = (S(n) - a) / (a + 1)

            long sum = n * (n + 1) / 2;
            List<long[]> resultList = new ArrayList<>();
            for (long x = 1; x <= n; x++) {
                long y = (sum - x) / (x + 1);
                if (y <= n && x * y == sum - x - y) {
                    resultList.add(new long[]{x, y});
                }
            }
            return resultList;
        }
    }
}