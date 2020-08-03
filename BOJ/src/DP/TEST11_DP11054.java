package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준(11054)_가장 긴 바이토닉 부분 수열
public class TEST11_DP11054 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numberSize = Integer.valueOf(br.readLine());
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int[] inputArr = new int[numberSize];
		
		for(int i=0;i<inputArr.length;i++) {
			inputArr[i] = Integer.valueOf(stk.nextToken());
		}
		
		int[] lTOr = new int[numberSize];
		int[] rTol = new int[numberSize];
		
		lTOr[0] = 1;
		rTol[numberSize-1] = 1;
		for(int i=1;i<inputArr.length;i++) {
			lTOr[i] = 1;
			for(int j=0;j<i;j++) {
				if(inputArr[i]>inputArr[j] && lTOr[i]<=lTOr[j]) {
					lTOr[i]++;
				}
			}
		}
		
		for(int i=inputArr.length-1-1;i>=0;i--) {
			rTol[i] = 1;
			for(int j=inputArr.length-1;j>i;j--) {
				if(inputArr[i]>inputArr[j] && rTol[i]<=rTol[j]) {
					rTol[i]++;
				}
			}
		}
		
		int max = 0;
		for(int i=0;i<lTOr.length;i++) {
			lTOr[i]+=rTol[i];
			if(max<lTOr[i]) {
				max = lTOr[i];
			}
		}
		
		System.out.println(max-1);

	}

}
