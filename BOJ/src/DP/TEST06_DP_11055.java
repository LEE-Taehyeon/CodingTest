package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//백준 알고리즘(11055)_가장 큰 증가 부분 수열 - 해설 참고
public class TEST06_DP_11055 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int arrSize = Integer.valueOf(br.readLine());
		int[] arr = new int[arrSize];
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		for(int i=0;i<arr.length;i++) {
			arr[i] = Integer.valueOf(stk.nextToken());
		}

		int max = 0;
		int[] arrSum = new int[arrSize];
		arrSum[0] = arr[0];
		for(int i=0;i<arr.length;i++) {
			arrSum[i] = arr[i];
			for(int j=0;j<i;j++) {
				if(arr[j]<arr[i] && arrSum[i]<arrSum[j]+arr[i]) {
					arrSum[i] = arrSum[j]+arr[i];
				}
			}
			if(max<arrSum[i]) {
				max = arrSum[i];
			}
		}

		//Arrays.sort(arrSum);
		//System.out.println(arrSum[arrSum.length-1]);
		System.out.println(max);
	}

}
