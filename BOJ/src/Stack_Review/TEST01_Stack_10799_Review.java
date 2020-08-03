package Stack_Review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//백준(10799)_쇠막대기
public class TEST01_Stack_10799_Review {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int answer = 0;
		
		Stack<Character> openStk = new Stack<Character>();
		for(int i=0;i<line.length();i++) {
			char ch = line.charAt(i);
			
			if(ch=='(') {
				openStk.push(ch);
			}else {
				openStk.pop();
				if(line.charAt(i-1)!=')') {
					answer += openStk.size();
				}else {
					answer++;
				}
			}
		}
		System.out.println(answer);

	}

}
