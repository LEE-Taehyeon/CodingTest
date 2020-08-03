package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//백준알고리즘(11722)_가장 긴 감소하는 부분 수열 - 해설참고
public class TEST05_DP_11722 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int arrSize = Integer.valueOf(br.readLine());
		int[] arr = new int[arrSize];// 입력값 배열 저장
		int[] arrCnt = new int[arrSize];// 감소하는 구간의 배열길이 저장
		String[] strArr = br.readLine().split(" ");
		System.out.println(strArr.length);

		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.valueOf(strArr[i]);
		}

		arrCnt[0] = 1;

		for (int i = 1; i < arr.length; i++) {
			arrCnt[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[i] < arr[j] && arrCnt[i] <= arrCnt[j]) {
					arrCnt[i] = arrCnt[j] + 1;
				}
			}
		}
		Arrays.sort(arrCnt);
		System.out.println(arrCnt[arrCnt.length-1]);

	}

}
