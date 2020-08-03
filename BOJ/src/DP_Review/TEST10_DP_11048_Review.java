package DP_Review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 알고리즘(11048) - 리뷰
public class TEST10_DP_11048_Review {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arrNM = br.readLine().split(" ");
		int n = Integer.valueOf(arrNM[0]);
		int m = Integer.valueOf(arrNM[1]);
		int[][] inputArr = new int[n+1][m+1];
		
		for(int i=1;i<=n;i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			for(int j=1;j<=m;j++) {
				inputArr[i][j] = Integer.valueOf(stk.nextToken());
			}
		}
		
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<m+1;j++) {
				inputArr[i][j] += Math.max(inputArr[i-1][j], inputArr[i][j-1]);
			}
		}
		System.out.println(inputArr[n][m]);
		

	}

}
