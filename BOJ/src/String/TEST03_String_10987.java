package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준(10987)_모음의 개수
public class TEST03_String_10987 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] inputCharArr = br.readLine().toCharArray();
		int answer = 0;
		
		for(char ch:inputCharArr) {

			if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
				answer++;
			}
			 
			//answer += ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'?1:0;
		}
		System.out.println(answer);
	}

}
