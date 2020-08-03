package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준(1439)_뒤집기
public class TEST06_Greedy_1439 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] inputCharArr = br.readLine().toCharArray();
		int oneArea = 0;
		int zeroArea = 0;
		char compare = inputCharArr[0];

		if(compare=='1') {
			oneArea++;
		}else {
			zeroArea++;
		}
		
		for(int i=1;i<inputCharArr.length;i++) {
			if(compare!=inputCharArr[i]) {
				if(inputCharArr[i]=='1') {
					oneArea++;
				}else {
					zeroArea++;
				}
				compare = inputCharArr[i];
			}
		}
		
		System.out.println(Math.min(oneArea, zeroArea));

	}

}
