package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 알고리즘(11048)_이동하기
public class TEST10_DP_11048 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arrNM = br.readLine().split(" ");
		int n = Integer.valueOf(arrNM[0]);
		int m = Integer.valueOf(arrNM[1]);
		int[][] inputArr = new int[n][m];

		
		for(int i=0;i<inputArr.length;i++) {
			String[] inputArrLine = br.readLine().split(" ");
			for(int j=0;j<inputArr[i].length;j++) {
				inputArr[i][j] = Integer.valueOf(inputArrLine[j]);
			}
		}
		
		for(int i=0;i<inputArr.length;i++) {
			for(int j=0;j<inputArr[i].length;j++) {
				if(i==0 && j>0) {
					inputArr[i][j] += inputArr[i][j-1];
				}else if(i>0 && j==0) {
					inputArr[i][j] += inputArr[i-1][j];
				}else if(i>0 && j>0){
					inputArr[i][j] += Math.max(inputArr[i-1][j], inputArr[i][j-1]);
				}
			}
		}
		
		System.out.println(inputArr[n-1][m-1]);
		

	}

}
