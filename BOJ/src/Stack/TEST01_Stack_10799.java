package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준(10799)_쇠막대기
public class TEST01_Stack_10799 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int answer = 0;
		int open = 0;
		
		for(int i=0;i<line.length();i++) {
			char ch = line.charAt(i);
			
			if(ch=='(' && line.charAt(i+1)!=')'){
				open++;
			}
			if(ch=='(' && line.charAt(i+1)==')') {
				answer += open;
				i++;
			}
			if(ch==')') {
				answer += 1;
				open -= 1;
			}
		}
		System.out.println(answer);

	}

}
