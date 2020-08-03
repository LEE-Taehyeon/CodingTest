package DP_Review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 알고리즘(9095) - 해설 참고(런타임 에러)
public class TEST08_DP_9095_Review_R02 {
	static int[] arr = new int[1000];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.valueOf(br.readLine());
		int[] answer = new int[testCase];
		
		for(int i=0;i<testCase;i++) {
			int num = Integer.valueOf(br.readLine());
			answer[i] = reculsive(num);
		}
		for(int i:answer) {
			System.out.println(i);
		}
	}
	private static int reculsive(int num) {
		if(num==1) {
			return 1;
		}
		if(num==2) {
			return 2;
		}
		if(num==3) {
			return 4;
		}
		if(arr[num]!=0) {
			return arr[num];
		}
		
		return arr[num] = reculsive(num-1) + reculsive(num-2) + reculsive(num-3);
	}

}
