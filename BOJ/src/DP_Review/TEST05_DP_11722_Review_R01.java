package DP_Review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//백준알고리즘(11722)_가장 긴 감소하는 부분 수열 - 해설참고
public class TEST05_DP_11722_Review_R01 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.valueOf(br.readLine());
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int[] intArr = new int[testCase];
		int[] cntArr = new int [testCase];
		
		for(int i=0;i<testCase;i++) {
			intArr[i] = Integer.valueOf(stk.nextToken());
		}
		
		cntArr[0] = 1;
		for(int i=1;i<intArr.length;i++) {
			cntArr[i] = 1;
			for(int j=0;j<i;j++) {
				if(intArr[i]<intArr[j] && cntArr[i]<=cntArr[j]) {
					cntArr[i] = cntArr[i]+1;
				}
				/* 이렇게 작성해도 된다.
				 if(intArr[i]<intArr[j]){
				 	cntArr[i] = Math.max(cntArr[j]+1, cntArr[i]);
				 }
				 */
			}
		}
		for(int i:cntArr) {
			System.out.println(i);
		}
		
		Arrays.sort(cntArr);
		System.out.println(cntArr[cntArr.length-1]);
		
	}
}
