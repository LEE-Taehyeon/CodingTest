package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준알고리즘(2718)_타일 채우기 - 해설 듣고 풀은 TEST02를 참고해서 풀었음
public class TEST04_DP_2718 {
	static int[] arr = new int[1001];
	static int num = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		
		for(int i=0;i<n;i++) {
			int num = Integer.valueOf(br.readLine());
			int result = tilling(num);
			System.out.println(result);
		}
	}
	private static int tilling(int n) {
		if(n==0) {
			return 1;
		}
		if(n==1) {
			return 1;
		}
		if(n==2) {
			return 5;
		}
		if(n==3) {
			return 11;
		}
		if(arr[n]!=0) {
			return arr[n];
		}
		num = (tilling(n-1)+4*tilling(n-2));
		
		for(int i=3;i<=n;i++) {
			if(i%2==0) {
				num += 3*(tilling(n-i));
			}
			if(i%2!=0) {
				num += 2*(tilling(n-i));
			}
		}	
		return arr[n] = num;
	}
}
