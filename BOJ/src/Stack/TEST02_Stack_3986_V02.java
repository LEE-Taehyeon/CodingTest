package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//백준(3986)_좋은단어
public class TEST02_Stack_3986_V02 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.valueOf(br.readLine());
		int answer = 0;
		
		for(int i=0;i<testCase;i++) {
			Stack<Character> stk = new Stack<Character>();
			String letter = br.readLine();
			
			for(int j=0;j<letter.length();j++) {
				char ch = letter.charAt(j);
				
				if(stk.size()==0) {
					stk.push(ch);
					continue;
				}else {
					if(ch==stk.peek()) {
						stk.pop();
					}else {
						stk.push(ch);
					}
				}
			}
			if(stk.size()==0) {
				answer++;
			}
		}
		System.out.println(answer);

	}

}
