package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 알고리즘(11052)_카드 구매하기  - 해설 참고
public class TEST09_DP_11052_FailFailFail {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cards = Integer.valueOf(br.readLine());
		int[] cardArr = new int[cards+1];
		int[] d = new int[cards+1];
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for(int i=1;i<cardArr.length;i++) {
			cardArr[i] = Integer.valueOf(stk.nextToken());
		}

		
		for(int i=1;i<cardArr.length;i++) {
			for(int j=1;j<=i;j++) {
				d[i] = Math.max(d[i], d[i-j]+cardArr[j]);
			}
			
		}
		
		for(int i:d) {
			System.out.println(i);
		}
		
		System.out.println(d[d.length-1]);
		

	}

}
