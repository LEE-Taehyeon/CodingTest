package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준(10988)_팰린드롬인지 확인하기
public class TEST06_String_10988 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		/*
		String inputStr = br.readLine();
		
		for(int i=0;i<inputStr.length();i++) {
			if(inputStr.charAt(i)!=inputStr.charAt(inputStr.length()-1-i)) {
				System.out.println(0);
				break;
			}else {
				if(i==inputStr.length()-1) {
					System.out.println(1);
				}
			}
		}
		*/
		
		StringBuilder sb = new StringBuilder(br.readLine());
		if(sb.toString().equals(sb.reverse().toString())) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}

	}

}
