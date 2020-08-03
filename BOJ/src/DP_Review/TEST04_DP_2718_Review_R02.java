package DP_Review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준알고리즘(2718)_타일 채우기 - 해설 듣고 풀은 TEST02를 참고해서 풀었음
public class TEST04_DP_2718_Review_R02 {
	static int[] arr = new int[1001];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.valueOf(br.readLine());
		
		for(int i=0;i<testCase;i++) {
			int num = Integer.valueOf(br.readLine());
			int result = tilling(num);
			System.out.println(result);
		}
	}

	private static int tilling(int num) {
		if(num==0) {
			return 1;
		}
		if(num==1) {
			return 1;
		}
		if(num==2) {
			return 5;
		}
		if(num==3) {
			return 11;
		}
		if(arr[num]!=0) {
			return arr[num];
		}
		int sum = tilling(num-1) + 4*tilling(num-2);
		for(int i=3;i<=num;i++) {
			if(i%2==0) {
				sum += 3*tilling(num-i);
			}else {
				sum += 2*tilling(num-i);
			}
		}
		return sum;
	}



}
