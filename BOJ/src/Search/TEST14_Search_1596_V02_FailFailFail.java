package Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준(1596)_영식함수  -- 메모리 초과 -> int를 double로  -- 런타임 에러
public class TEST14_Search_1596_V02_FailFailFail {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		double a = Double.valueOf(stk.nextToken());
		double b = Integer.valueOf(stk.nextToken());
		int answer = 0;
		
		for(double i=a;i<=b;i++) {
			if(isLuckyNum(i)) {
				//System.out.println(i);
				answer++;
			}
		}

		System.out.println(answer);
	}

	private static boolean isLuckyNum(double num) {
		String numStr = String.valueOf(num);
		numStr = numStr.substring(0, numStr.length()-2);//double형을 String타입으로 변경시 뒤에 .0까지 포함되므로 .0을 자르기 위한 작업
		double number = 0;
		
		//System.out.println("numStr:"+numStr);

		for(int i=1;i<numStr.length();i++) {
			int minus = Math.abs(numStr.charAt(i-1)-numStr.charAt(i));
			number*=10;//영식함수를 찾기위한 작업(1)
			number+=minus;//영식함수를 찾기위한 작업(2)
		}
		//System.out.println("number:"+number);
		
		if(num<10) {//num이 한자리 수 일때 위의 for문을 거치지 않으므로 number에 num대입
			number = num;
		}
		if(number<10) {
			if(number==7) {//영식함수 인지 판별
				return true;
			}else {
				return false;
			}
		}else {
			return isLuckyNum(number);//한자리 수 가 아닐 경우 재귀를 통해 자릿수를 줄여간다.
		}
	}
}
