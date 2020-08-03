package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Pattern;

//백준(1935)_후위표기식2
public class TEST03_Stack_1935_V02 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numbers = Integer.valueOf(br.readLine());
		String postfixExpression = br.readLine();
		Stack<Double> stk = new Stack<Double>();
		Map<String, Double> map = new HashMap<String, Double>();
		
		for(int i=0;i<postfixExpression.length();i++) {
			String str = postfixExpression.substring(i, i+1);
			if(Pattern.matches("[A-Z]", str)) {
				if(!map.containsKey(str)) {
					double num = Integer.valueOf(br.readLine());
					map.put(str, num);
					stk.push(num);
					continue;
				}else {
					stk.push(map.get(str));
					continue;
				}
			}else {
				double firstNum = stk.pop();
				double secondNum = stk.pop();
				if(str.equals("*")) {
					stk.push(firstNum*secondNum);
				}else if(str.equals("+")) {
					stk.push(firstNum+secondNum);
				}else if(str.equals("-")) {
					stk.push(secondNum-firstNum);
				}else if(str.equals("/")) {
					stk.push(secondNum/firstNum);
				}
			}
		}
		System.out.printf("%.2f", stk.pop());
	}
}
