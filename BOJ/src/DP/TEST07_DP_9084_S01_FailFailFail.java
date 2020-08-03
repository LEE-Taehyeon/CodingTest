package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 알고리즘(9084)_동전  해설 참고
public class TEST07_DP_9084_S01_FailFailFail {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.valueOf(br.readLine());
		int[] ansArr = new int[testCase];
		
		for(int i=0;i<testCase;i++) {
			int coins = Integer.valueOf(br.readLine());
			int[] coinsArr = new int[coins];
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			for(int j=0;j<coinsArr.length;j++) {
				coinsArr[j] = Integer.valueOf(stk.nextToken());
			}
			int[] d = new int[1001];
			d[0] = 1;
			
			int money = Integer.valueOf(br.readLine());
			
			ansArr[i] = solution(coinsArr, d, money);
			System.out.println(ansArr[i]);
			
		}

	}

	private static int solution(int[] coinsArr, int[] d, int money) {
		
		for(int i=0;i<coinsArr.length;i++) {
			for(int j=coinsArr[i];j<=money;j++) {
				d[j] += d[j-coinsArr[i]];
			}
		}
		return d[money];
	}

}
