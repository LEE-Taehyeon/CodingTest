package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준(2743)_단어 길이 재기
public class TEST01_String_2743 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		System.out.println(word.length());
	}

}
