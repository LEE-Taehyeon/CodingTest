package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

//백준(2841)_외계인의 기타연주
public class TEST05_Stack_2841 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.valueOf(stk.nextToken());
		int P = Integer.valueOf(stk.nextToken());
		Stack<Integer>[] stack = new Stack[7];//스택을 배열로 선언, 크기를 7로 선언한 이유는 줄의 번호와 스택의 번호를 맞추기 위함.
		
		for(int i = 1; i < 7; i++) {
			stack[i] = new Stack<Integer>();
		}
			
		
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			int n = Integer.valueOf(stk.nextToken());
			int p = Integer.valueOf(stk.nextToken());
			
			while(!stack[n].isEmpty() && stack[n].peek() > p) {
				cnt++;
				stack[n].pop();
			}
			if(!stack[n].isEmpty() && stack[n].peek()==p) {
				continue;
			}
			stack[n].push(p);
			cnt++;
		}

		System.out.println(cnt);

	}

}
