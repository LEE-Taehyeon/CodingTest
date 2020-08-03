package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준알고리즘(11726)_2xn 타일링 - 해설 듣고 풀었음
public class TEST02_DP_11726 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		int[] arr = new int[1001];//이전에 행했던 작업을 저장하기 위한 배열
		int result = tilling(n, arr);
		
		System.out.println(result);
	}

	private static int tilling(int n, int[] arr) {
		if(n==1) {
			return 1;
		}
		if(n==2) {
			return 2;
		}
		if(arr[n]!=0) {
			return arr[n];
		}
		return arr[n] = (tilling(n-1, arr)+tilling(n-2, arr))%10007;
	}
}
