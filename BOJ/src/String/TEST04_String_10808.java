package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준(10808)_알파벳 개수
public class TEST04_String_10808 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = br.readLine();
		int[] alpha = new int[26];
		
		for(int i=0;i<inputStr.length();i++) {
			char chAlpha = inputStr.charAt(i);
			alpha[chAlpha-'a']++;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i:alpha) {
			sb.append(i+" ");
		}
		sb.delete(sb.length()-1, sb.length());
		System.out.println(sb);

	}

}
