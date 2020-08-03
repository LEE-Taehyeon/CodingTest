package Stack_Review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Pattern;

//백준(1935)_후위표기식2
public class TEST03_Stack_1935_Review {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numbers = Integer.valueOf(br.readLine());
		String postfixExpression = br.readLine();
		Stack<Double> stk = new Stack<Double>();
		double[] nums = new double[numbers];//주어진 숫자를 저장하기 위한 배열
		
		for(int i=0;i<nums.length;i++) {
			nums[i] = Double.valueOf(br.readLine());
		}
		
		for(int i=0;i<postfixExpression.length();i++) {
			char chPE = postfixExpression.charAt(i);
			if(chPE>=65 && chPE<=90) {
				stk.push(nums[chPE-'A']);
			}else {
				double firstNum = stk.pop();
				double secondNum = stk.pop();
				switch (chPE) {
				case '+':{
					stk.push(secondNum+firstNum);
					break;
				}
				case '-':{
					stk.push(secondNum-firstNum);
					break;
				}
				case '*':{
					stk.push(secondNum*firstNum);
					break;
				}
				case '/':{
					stk.push(secondNum/firstNum);
					break;
				}
				}
			}
		}
		System.out.printf("%.2f", stk.pop());
	}
}
