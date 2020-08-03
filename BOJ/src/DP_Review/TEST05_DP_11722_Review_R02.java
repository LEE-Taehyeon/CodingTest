package DP_Review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준알고리즘(11722)_가장 긴 감소하는 부분 수열 - 해설참고
public class TEST05_DP_11722_Review_R02 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int arrSize = Integer.valueOf(br.readLine());
		int[] arr = new int[arrSize];
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for(int i=0;i<arrSize;i++) {
			arr[i] = Integer.valueOf(stk.nextToken());
		}
		
		int max = 0;
		int[] arrLength = new int[arrSize];
		for(int i=0;i<arrSize;i++) {
			arrLength[i] = 1;
			for(int j=0;j<i;j++) {
				if(arr[i]<arr[j] && arrLength[i]<=arrLength[j]) {
					arrLength[i]+=1;
				}
			}
			if(max<arrLength[i]) {
				max = arrLength[i];
			}
		}
		
		for(int i:arrLength) {
			System.out.println(i);
		}
		System.out.println(max);
	}
}
