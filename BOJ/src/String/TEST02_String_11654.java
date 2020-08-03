package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준(11654)_아스키 코드
public class TEST02_String_11654 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char inputWord = br.readLine().charAt(0);
		System.out.println((int)inputWord);
	}
}
