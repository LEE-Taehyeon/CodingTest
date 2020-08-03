package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준알고리즘(2163)_초콜릿 자르기
public class TEST01_DP_2163 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		
		System.out.println(Integer.valueOf(arr[0])*Integer.valueOf(arr[1])-1);

	}

}
