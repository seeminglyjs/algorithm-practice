package com.algorithm.practice.algorithmpractice.CodeWars;

import org.junit.jupiter.api.Test;

public class Case_10_5kyu {  //Product of consecutive Fib numbers
    //    The Fibonacci numbers are the numbers in the following integer sequence (Fn):
//
//            0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, ...
//
//    such as
//
//    F(n) = F(n-1) + F(n-2) with F(0) = 0 and F(1) = 1.
//
//    Given a number, say prod (for product), we search two Fibonacci numbers F(n) and F(n+1) verifying
//
//    F(n) * F(n+1) = prod.
//
//    Your function productFib takes an integer (prod) and returns an array:
//
//            [F(n), F(n+1), true] or {F(n), F(n+1), 1} or (F(n), F(n+1), True)
//    depending on the language if F(n) * F(n+1) = prod.
//
//    If you don't find two consecutive F(n) verifying F(n) * F(n+1) = prodyou will return
//
//            [F(n), F(n+1), false] or {F(n), F(n+1), 0} or (F(n), F(n+1), False)
//    F(n) being the smallest one such as F(n) * F(n+1) > prod.
//
//    Some Examples of Return:
//            (depend on the language)
//
//    productFib(714) # should return (21, 34, true),
//            # since F(8) = 21, F(9) = 34 and 714 = 21 * 34
//
//    productFib(800) # should return (34, 55, false),
//            # since F(8) = 21, F(9) = 34, F(10) = 55 and 21 * 34 < 800 < 34 * 55
//            -----
//    productFib(714) # should return [21, 34, true],
//    productFib(800) # should return [34, 55, false],
//            -----
//    productFib(714) # should return {21, 34, 1},
//    productFib(800) # should return {34, 55, 0},
//            -----
//    productFib(714) # should return {21, 34, true},
//    productFib(800) # should return {34, 55, false},
//    Note:
//    You can see examples for your language in "Sample Tests".

    @Test
    public void test1() {
        long [] result = productFib(800);
        System.out.println(result[0] + " / " + result[1] + " / " + result[2] + " / " );
    }

    public static long[] productFib(long prod) {
//        long aa = 0;
        long a = 0;
        long b = 1;
        long c = 0;
        long [] answer = new long[3];
        while(true){
            if(a * b == prod){
                answer[0] = a;
                answer[1] = b;
                answer[2] = 1;
                break;
            }else if( a * b > prod){
                answer[0] = a;
                answer[1] = b;
                answer[2] = 0;
                break;
            }
//            aa = a;
            c = a + b;
            a = b;
            b = c;
        }
        return answer;
    }

    public static long[] productFib2(long prod) {
        long a = 0L;
        long b = 1L;
        while (a * b < prod) {
            long tmp = a;
            a = b;
            b = tmp + b;
        }
        return new long[] { a, b, a * b == prod ? 1 : 0 };
    }

}
