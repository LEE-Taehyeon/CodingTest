package DP_Review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 알고리즘(11055) - 해설 참고
public class TEST06_DP_11055_Review {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int arrSize = Integer.valueOf(br.readLine());
		int[] arr = new int[arrSize];
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		for(int i=0;i<arrSize;i++) {
			arr[i] = Integer.valueOf(stk.nextToken());
		}
		
		int[] arrSum = new int[arrSize];
		int max = 0;
		for(int i=0;i<arrSize;i++) {
			arrSum[i] = arr[i];
			for(int j=0;j<i;j++) {
				if(arr[i]>arr[j] && arrSum[i]<=arr[i]+arrSum[j]) {
					arrSum[i]=arr[i]+arrSum[j];
				}
			}
			if(max<arrSum[i]) {
				max = arrSum[i];
			}
		}
		
		for(int i:arrSum) {
			System.out.println(i);
		}
		
		System.out.println(max);
		
	}

}
