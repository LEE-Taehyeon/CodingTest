package Stack_Review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//백준(3986)_좋은단어
public class TEST02_Stack_3986_Review {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.valueOf(br.readLine());
		int answer = 0;
		
		for(int i=0;i<testCase;i++) {
			Stack<Character> stk = new Stack<Character>();
			String letter = br.readLine();
			
			for(int j=0;j<letter.length();j++) {
				char ch = letter.charAt(j);
				
				//이중 if문을 하나의 if문으로 합쳤다.
				if(!stk.isEmpty() && stk.peek()==ch) {
					stk.pop();
				}else {
					stk.push(ch);
				}
			}
			if(stk.isEmpty()) {
				answer++;
			}
		}
		System.out.println(answer);
	}
}
