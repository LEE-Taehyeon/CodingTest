package DP_Review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준알고리즘(2718)_타일 채우기 - 해설 듣고 풀은 TEST02를 참고해서 풀었음
public class TEST04_DP_2718_Review_R01 {
	static int[] arr = new int[1001];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.valueOf(br.readLine());
		
		for(int i=0;i<testCase;i++) {
			int n = Integer.valueOf(br.readLine());
			int dp = tilling(n, arr);
			System.out.println(dp);
		}

	}

	private static int tilling(int n, int[] arr2) {
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
		if(arr2[n]!=0) {
			return arr2[n];
		}
		int result = tilling(n-1, arr2) + 4*tilling(n-2, arr2);
		for(int i=3;i<=n;i++) {
			if(i%2==0) {
				result += 3*tilling(n-i, arr);
			}else {
				result += 2*tilling(n-i, arr);
			}
		}
		arr2[n] = result;
		return arr2[n];
		
	}

}
