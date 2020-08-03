package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 알고리즘(9095)_1,2,3더하기 - 해설 참고(런타임 에러)
public class TEST08_DP_9095_S01_FailFailFail {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.valueOf(br.readLine());
		int[] answer = new int[testCase];
		
		for(int i=0;i<testCase;i++) {
			int money = Integer.valueOf(br.readLine());
			int[] moneyArr = new int[money+1];
			moneyArr[1] = 1;
			moneyArr[2] = 2;
			moneyArr[3] = 4;
			for(int j=4;j<moneyArr.length;j++) {
				moneyArr[j] = moneyArr[j-1] + moneyArr[j-2] + moneyArr[j-3];
			}
			answer[i] = moneyArr[moneyArr.length-1];
		}

		for(int i:answer) {
			System.out.println(i);
		}
	}

}
