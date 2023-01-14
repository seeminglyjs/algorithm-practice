package com.algorithm.practice.algorithmpractice.programmers;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Case_02 { // [2개 이하로 다른 비트]
//
//    문제 설명
//    양의 정수 x에 대한 함수 f(x)를 다음과 같이 정의합니다.
//
//    x보다 크고 x와 비트가 1~2개 다른 수들 중에서 제일 작은 수
//    예를 들어,
//
//    f(2) = 3 입니다. 다음 표와 같이 2보다 큰 수들 중에서 비트가 다른 지점이 2개 이하이면서 제일 작은 수가 3이기 때문입니다.
//    수	비트	다른 비트의 개수
//2	000...0010
//        3	000...0011	1
//    f(7) = 11 입니다. 다음 표와 같이 7보다 큰 수들 중에서 비트가 다른 지점이 2개 이하이면서 제일 작은 수가 11이기 때문입니다.
//    수	비트	다른 비트의 개수
//7	000...0111
//        8	000...1000	4
//        9	000...1001	3
//        10	000...1010	3
//        11	000...1011	2
//    정수들이 담긴 배열 numbers가 매개변수로 주어집니다. numbers의 모든 수들에 대하여 각 수의 f 값을 배열에 차례대로 담아 return 하도록 solution 함수를 완성해주세요.
//
//    제한사항
//1 ≤ numbers의 길이 ≤ 100,000
//            0 ≤ numbers의 모든 수 ≤ 1015
//    입출력 예
//    numbers	result
//[2,7]	[3,11]


    @Test
    public void test1() {
        long[] number = {2, 7};
        long[] result = solution(number);
        for(int i = 0 ; i < result.length; i++){
            System.out.println(result);
        }
    }

    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        Integer index = 0;
        for (int i = 0; i < numbers.length; i++) {
            Long number = numbers[i];
            String bit1 = Long.toBinaryString(number);// 비교 대상 숫자

            Long number2 = number + 1; // 비교 대상 보다 하나 큰 수
            loop:
            while (true) {
                int count = 0; //차이 계산 변수
                String bit2 = Long.toBinaryString(number2);// 비교 대상 보다 큰 수의 비트 값을 구한다.
//                System.out.println(bit1 + " / " + bit2);
                if (bit1.length() == bit2.length()) { //길이가 같을 경우
                    for (int j = 0; j < bit1.length(); j++) {
                        if (bit1.charAt(j) != bit2.charAt(j)) {//비트가 다를경우
                            count++;
                        }
                        if (count > 2) {//비트가 2개 초과 되도록 다르면 중지
                            number2++;
                            break;
                        }
                    }
                    if (count <= 2) {//다비교했는데 2개 이하로 같으면
                        answer[index] = number2;
                        index++;
                        break loop;
                    }
                } else if (bit1.length() + 2 < bit2.length()) {//비교 보다 2이산 큰경우 비교 불필요
                    number2++;
                } else if (bit1.length() + 2 > bit2.length()) {
                    int bitsub = bit2.length() - bit1.length();
                    String subZero = "";
                    for(int s = 0; s < bitsub; s++){
                        subZero +="0";
                    }
                    subZero += bit1;
                    int k1 = subZero.length() - 1;
                    for (int k2 = bit2.length() - 1; k2 > -1; k2--) {
//                        System.out.println("k2 -> " + k2 + " / k1 -> " + k1);
                        if (subZero.charAt(k1) != bit2.charAt(k2)) {//비트가 다를경우
//                            System.out.println(subZero.charAt(k1) + " / " + bit2.charAt(k2));
                            count++;
                        }
                        if (count > 2) {//비트가 2개 초과 되도록 다르면 중지
                            number2++;
                            break;
                        }
                        k1--;
                    }
                    if (count <= 2) {//다비교했는데 2개 이하로 같으면
                        answer[index] = number2;
                        index++;
                        break loop;
                    }
                }
            }
        }

//        for (int i = 0; i < answer.length; i++) {
//            System.out.println(answer[i]);
//        }

        return answer;
    }

}
