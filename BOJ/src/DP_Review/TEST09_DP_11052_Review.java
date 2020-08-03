package DP_Review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 알고리즘(11052) - 해설 참고
public class TEST09_DP_11052_Review {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cards = Integer.valueOf(br.readLine());
		int[] cardArr = new int[cards+1];
		int[] money = new int[cards+1];
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		for(int i=1;i<=cards;i++) {
			cardArr[i] = Integer.valueOf(stk.nextToken());
		}
		
		for(int i=1;i<cardArr.length;i++) {
			for(int j=1;j<=i;j++) {
				money[i] = Math.max(money[i-j]+cardArr[j], money[i]);
			}
		}
		for(int i:money) {
			System.out.println(i);
		}
	}

}
