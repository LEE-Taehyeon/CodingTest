package DP;

import java.util.Arrays;

//백준(11066)_파일 합치기
public class TEST12_DP_11066_FailFailFail {
	public static void main(String[] args) {
		int[] arr = { 1, 21, 3, 4, 5, 35, 5, 4, 3, 5, 98, 21, 14, 17, 32};
		Arrays.sort(arr);
		int sum = 0;
		for(int i:arr) {
			sum += i;
			System.out.println(i);
		}
		System.out.println(sum);

	}

}
