package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준알고리즘(11727)_2xn 타일링2 - 해설 듣고 풀은 TEST02를 참고해서 풀었음
public class TEST03_DP_11727 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[1001];
		int n = Integer.valueOf(br.readLine());
		int result = tilling(n, arr);
		System.out.println(result);
	}

	private static int tilling(int n, int[] arr) {
		if(n==1) {
			return 1;
		}
		if(n==2) {
			return 3;
		}
		if(arr[n]!=0) {
			return arr[n];
		}
		return arr[n] = (tilling(n-1, arr)+2*tilling(n-2, arr))%10007;
	}

}
