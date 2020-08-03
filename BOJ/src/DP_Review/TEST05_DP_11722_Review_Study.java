package DP_Review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//가장 긴 증가하는 부분 수열 
public class TEST05_DP_11722_Review_Study {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int arrSize = Integer.valueOf(br.readLine());
		int[] arr = new int[arrSize];
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		for(int i=0;i<arr.length;i++) {
			arr[i] = Integer.valueOf(stk.nextToken());
		}


		int[] arrCnt = new int[arrSize];
		arrCnt[0] = 1;
		for(int i=1;i<arr.length;i++) {
			arrCnt[i] = 1;
			for(int j=0;j<i;j++) {
				if(arr[i]>arr[j] && arrCnt[i]<=arrCnt[j]) {
					arrCnt[i] += 1;

				}
			}

		}
		
		for(int i:arrCnt) {
			System.out.println(i);
		}

	}

}
