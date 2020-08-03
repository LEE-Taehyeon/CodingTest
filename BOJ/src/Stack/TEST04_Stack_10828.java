package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//백준(10828)_스택
public class TEST04_Stack_10828 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.valueOf(br.readLine());
		Stack<Integer> stk = new Stack<Integer>();
		for(int i=0;i<testCase;i++) {
			String promp = br.readLine();
			if(promp.equals("pop")) {
				if(stk.isEmpty()) {
					System.out.println(-1);
				}else {
					System.out.println(stk.pop());
				}
			}else if(promp.equals("size")) {
				System.out.println(stk.size());
			}else if(promp.equals("empty")) {
				if(stk.isEmpty()) {
					System.out.println(1);
				}else {
					System.out.println(0);
				}
			}else if(promp.equals("top")) {
				if(stk.isEmpty()) {
					System.out.println(-1);
				}else {
					System.out.println(stk.peek());
				}
			}else {
				stk.push(Integer.valueOf(promp.substring(5)));
			}
		}
	}
}
