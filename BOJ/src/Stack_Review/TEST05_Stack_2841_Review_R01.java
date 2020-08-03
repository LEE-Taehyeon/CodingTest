package Stack_Review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

//백준(2841)_외계인의 기타연주
public class TEST05_Stack_2841_Review_R01 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.valueOf(stk.nextToken());
		int P = Integer.valueOf(stk.nextToken());
		Stack<Integer> stk1 = new Stack<Integer>();
		Stack<Integer> stk2 = new Stack<Integer>();
		Stack<Integer> stk3 = new Stack<Integer>();
		Stack<Integer> stk4 = new Stack<Integer>();
		Stack<Integer> stk5 = new Stack<Integer>();
		Stack<Integer> stk6 = new Stack<Integer>();
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			int n = Integer.valueOf(stk.nextToken());
			int p = Integer.valueOf(stk.nextToken());

			switch (n) {
			case 1: {
				while (!stk1.isEmpty() && stk1.peek() > p) {
					cnt++;
					stk1.pop();
				}
				if(!stk1.isEmpty() && stk1.peek()==p) {
					break;
				}
				stk1.push(p);
				cnt++;
				break;

			}
			case 2: {
				while (!stk2.isEmpty() && stk2.peek() > p) {
					cnt++;
					stk2.pop();
				}
				if(!stk2.isEmpty() && stk2.peek()==p) {
					break;
				}
				stk2.push(p);
				cnt++;
				break;
			}
			case 3: {
				while (!stk3.isEmpty() && stk3.peek() > p) {
					cnt++;
					stk3.pop();
				}
				if(!stk3.isEmpty() && stk3.peek()==p) {
					break;
				}
				stk3.push(p);
				cnt++;
				break;
			}
			case 4: {
				while (!stk4.isEmpty() && stk4.peek() > p) {
					cnt++;
					stk4.pop();
				}
				if(!stk4.isEmpty() && stk4.peek()==p) {
					break;
				}
				stk4.push(p);
				cnt++;
				break;
			}
			case 5: {
				while (!stk5.isEmpty() && stk5.peek() > p) {
					cnt++;
					stk5.pop();
				}
				if(!stk5.isEmpty() && stk5.peek()==p) {
					break;
				}
				stk5.push(p);
				cnt++;
				break;
			}
			case 6: {
				while (!stk6.isEmpty() && stk6.peek() > p) {
					cnt++;
					stk6.pop();
				}
				if(!stk6.isEmpty() && stk6.peek()==p) {
					break;
				}
				stk6.push(p);
				cnt++;
				break;
			}
			}
		}

		System.out.println(cnt);

	}

}
