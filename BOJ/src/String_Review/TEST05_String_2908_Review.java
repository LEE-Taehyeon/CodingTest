package String_Review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준(2908)_상수
public class TEST05_String_2908_Review {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		/*
		//reverse()메소드 이용
		StringBuilder sb = new StringBuilder(br.readLine()).reverse();
		String[] inputStrArr = sb.toString().split(" ");
		
		if(Integer.valueOf(inputStrArr[0])>Integer.valueOf(inputStrArr[1])) {
			System.out.println(inputStrArr[0]);
		}else {
			System.out.println(inputStrArr[1]);
		}
		*/
		
		
		/*
		//charAt(i)이용
		StringBuilder sb = new StringBuilder(br.readLine());
		String[] inputStrArr = sb.toString().split(" ");
		
		String numA = inputStrArr[0].charAt(2)+""+inputStrArr[0].charAt(1)+inputStrArr[0].charAt(0);
		String numB = inputStrArr[1].charAt(2)+""+inputStrArr[1].charAt(1)+inputStrArr[1].charAt(0);
		
		System.out.println(Integer.valueOf(numA)>Integer.valueOf(numB)?numA:numB);
		*/
		
		
		/*
		// %10, /10, ... 등을 이용
		String[] inputStrArr = br.readLine().split(" ");
		int inputIntegerNumA = Integer.valueOf(inputStrArr[0]);
		int inputIntegerNumB = Integer.valueOf(inputStrArr[1]);
		
		int numA = (inputIntegerNumA%10)*100+((inputIntegerNumA/10)%10)*10+(inputIntegerNumA/100)%10;
		int numB = (inputIntegerNumB%10)*100+((inputIntegerNumB/10)%10)*10+(inputIntegerNumB/100)%10;
		
		System.out.println(numA>numB?numA:numB);
		*/
		
		
		
		//수학식 이용
		String[] inputStrArr = br.readLine().split(" ");
		int numA = getReverseNum(Integer.valueOf(inputStrArr[0]));
		int numB = getReverseNum(Integer.valueOf(inputStrArr[1]));
		System.out.println(numA>numB?numA:numB);
		
		
	}

	private static int getReverseNum(Integer num) {
		int result = 0;
		while(num!=0) {
			result = result*10 + num%10;
			num /= 10;
		}

		return result;
	}

}
