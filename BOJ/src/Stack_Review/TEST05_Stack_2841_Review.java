package Stack_Review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

//백준(2841)_외계인의 기타연주
public class TEST05_Stack_2841_Review {
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
		Stack<Integer> stk6 = new Stack<Integer>();//줄에 따라 스택을 별도로 6개 선언
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			int n = Integer.valueOf(stk.nextToken());
			int p = Integer.valueOf(stk.nextToken());

			switch (n) {//해당 줄을 구분짓기 위해 switch문을 사용
			case 1: {
				while (!stk1.isEmpty() && stk1.peek() > p) {//스택이 비어있지 않고, 이전 값이 현재 값보다 크면 이전 값을 꺼내 삭제한다.
															//whlie문으로 작성한 이유는 이전 값을 삭제해도 계속해서 현재 값보다 클 수 있으므로 작을 때까지 원소를 삭제하기 위함.
					cnt++;
					stk1.pop();
				}
				if(!stk1.isEmpty() && stk1.peek()==p) {//만약 이전 값과 현재 값이 같다면 아무 조치도 취하지 않고  break문을 통해 빠져나간다.
					break;
				}
				stk1.push(p);//이전 값보다 현재값이 클 경우를 의미. 스택에 현재 값을 넣는다.
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
