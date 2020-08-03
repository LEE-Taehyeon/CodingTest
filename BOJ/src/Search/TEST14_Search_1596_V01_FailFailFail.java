package Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준(1596)_영식함수  -- 메모리 초과
public class TEST14_Search_1596_V01_FailFailFail {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int a = Integer.valueOf(stk.nextToken());
		int b = Integer.valueOf(stk.nextToken());
		int answer = 0;
		
		for(int i=a;i<=b;i++) {
			if(isLuckyNum(i)) {
				System.out.println(i);
				answer++;
			}
		}

		System.out.println(answer);
	}

	private static boolean isLuckyNum(int num) {
		String numStr = String.valueOf(num);
		int number = 0;
		
		for(int i=1;i<numStr.length();i++) {
			int minus = Math.abs(numStr.charAt(i-1)-numStr.charAt(i));
			number*=10;
			number+=minus;
		}
		
		if(num<10) {
			number = num;
		}
		if(number<10) {
			if(number==7) {
				return true;
			}else {
				return false;
			}
		}else {
			return isLuckyNum(number);
		}
	}
}
