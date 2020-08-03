package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 알고리즘(9095)_1,2,3더하기 - 해설 참고
public class TEST08_DP_9095_S02_FailFailFail {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.valueOf(br.readLine());
		int[] answer = new int[testCase];
		
		for(int i=0;i<testCase;i++) {
			int money = Integer.valueOf(br.readLine());
			int[] moneyArr = new int[money+1];
			answer[i] = reculsive(money, moneyArr);
		}

		for(int i:answer) {
			System.out.println(i);
		}
	}

	private static int reculsive(int money, int[] moneyArr) {
		if(money==1) {
			return 1;
		}
		if(money==2) {
			return 2;
		}
		if(money==3) {
			return 4;
		}
		if(moneyArr[money]!=0) {
			return moneyArr[money];
		}
		return reculsive(money-1, moneyArr)+reculsive(money-2, moneyArr)+reculsive(money-3, moneyArr);
	}

}
