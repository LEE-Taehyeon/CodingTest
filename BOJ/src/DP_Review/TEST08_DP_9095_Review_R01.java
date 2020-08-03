package DP_Review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 알고리즘(9095) - 해설 참고(런타임 에러)
public class TEST08_DP_9095_Review_R01 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.valueOf(br.readLine());
		int[] answer = new int[testCase];
		
		for(int i=0;i<testCase;i++) {
			int num = Integer.valueOf(br.readLine());
			int[] arr = new int[num+1];
			arr[1] = 1;
			arr[2] = 2;
			arr[3] = 4;
			for(int j=4;j<=num;j++) {
				arr[j] = arr[j-1] + arr[j-2] + arr[j-3];
			}
			
			answer[i] = arr[num];
		}
		
		for(int i:answer) {
			System.out.println(i);
		}
	}

}
