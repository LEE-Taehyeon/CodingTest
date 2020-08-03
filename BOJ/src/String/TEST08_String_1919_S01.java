package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준(1919)_애너그램 만들기
public class TEST08_String_1919_S01 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] inputACharArr = br.readLine().toCharArray();
		char[] inputBCharArr = br.readLine().toCharArray();
		
		int cnt = 0;
		for(int i=0;i<inputACharArr.length;i++) {
			for(int j=0;j<inputBCharArr.length;j++) {
				if(inputACharArr[i]==inputBCharArr[j]) {
					inputBCharArr[j] = '0';
					cnt++;
					break;
				}
			}
		}
		System.out.println((inputACharArr.length-cnt)+(inputBCharArr.length-cnt));
	}
}
