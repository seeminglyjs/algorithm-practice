package com.algorithm.practice.algorithmpractice.programmers;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Case_01 { // [문제 : 최댓값과_최솟값]

//	문제 설명
//	문자열 s에는 공백으로 구분된 숫자들이 저장되어 있습니다. str에 나타나는 숫자 중 최소값과 최대값을 찾아 이를 "(최소값) (최대값)"형태의 문자열을 반환하는 함수, solution을 완성하세요.
//	예를들어 s가 "1 2 3 4"라면 "1 4"를 리턴하고, "-1 -2 -3 -4"라면 "-4 -1"을 리턴하면 됩니다.
//

//	제한 조건
//	s에는 둘 이상의 정수가 공백으로 구분되어 있습니다.
//	입출력 예
//	s				return
//	"1 2 3 4"		"1 4"
//	"-1 -2 -3 -4"	"-4 -1"
//	"-1 -1"			"-1 -1"

	@Test
	void contextLoads() {
		System.out.println("hello test");
	}
	public String solution(String s) {
		String answer = "";
		String [] strArr = s.split(" "); //주어진 문자열을 공백 기준으로 나눈다.

		int max = Integer.MIN_VALUE; //인트형중에 가장 큰 값
		int min = Integer.MAX_VALUE; //인트형중에 가장 작은 값

		String maxStr = "";
		String minStr = "";

		for(String str : strArr) {
			String num = ""; //비교할 값이 들어가는 임시변수
			if(str.equals("-")) {// - 기호이면
				num += str;
				continue;
			}else {
				num += str;
				if(Integer.parseInt(num) < min) {//최소값여부 비교
					min = Integer.parseInt(num);
					minStr = String.valueOf(min);
				}
				if(Integer.parseInt(num) > max) {//최대값여부 비교
					max = Integer.parseInt(num);
					maxStr = String.valueOf(max);
				}
			}
		}
		answer = minStr + " " + maxStr;
		return answer;
	}
}
