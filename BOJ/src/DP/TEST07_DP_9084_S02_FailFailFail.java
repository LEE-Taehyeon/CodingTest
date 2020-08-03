package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 알고리즘(9084)_동전 : 해설 참고
public class TEST07_DP_9084_S02_FailFailFail {
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
			int[] d = new int[10001];
			d[0] = 1;
			
			int money = Integer.valueOf(br.readLine());
			
			for(int k=0;k<coinsArr.length;k++) {
				for(int l=coinsArr[k];l<=money;l++) {
					d[l] += d[l-coinsArr[k]];
				}
			}
			ansArr[i] = d[money];
		}
		
		for(int i:ansArr) {
			System.out.println(i);
		}
	}
}
