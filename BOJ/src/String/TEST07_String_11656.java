package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//백준(11656)_접미사 배열
public class TEST07_String_11656 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer(br.readLine());
		String[] strArr = new String[sb.length()];
		
		/*
		for(int i=0;i<sb.length();i++) {
			strArr[i] = sb.toString().substring(i, sb.length());
		}
		*/
		
		char[] inputCharArr = sb.toString().toCharArray();
		StringBuilder sbuild = new StringBuilder();
		for(int i=0;i<sb.length();i++) {
			int j=i;
			while(j<sb.length()) {
				sbuild.append(inputCharArr[j]);
				j++;
			}
			strArr[i] = sbuild.toString();
			sbuild.setLength(0);
		}
		
		
		
		Arrays.sort(strArr);
		for(String str:strArr) {
			System.out.println(str);
		}

	}

}
