package LinkedList_Review;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

//백준 알고리즘(1468) - Stack 사용
public class TEST02_LinkedList_1468_Review_R02 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String inputAlpabet = br.readLine();
		
		Stack<Character> leftStk = new Stack<Character>();
		Stack<Character> rightStk = new Stack<Character>();
		
		for(int i=0;i<inputAlpabet.length();i++) {
			leftStk.push(inputAlpabet.charAt(i));
		}
		
		int testCase = Integer.valueOf(br.readLine());
		
		for(int i=0;i<testCase;i++) {
			String testString = br.readLine();
			char testChar = testString.charAt(0);
			
			switch(testChar) {
			case 'L':{
				if(!leftStk.isEmpty()) {
					rightStk.push(leftStk.pop());
				}
				break;
			}
			case 'D':{
				if(!rightStk.isEmpty()) {
					leftStk.push(rightStk.pop());
				}
				break;
			}
			case 'B':{
				if(!leftStk.isEmpty()) {
					leftStk.pop();
				}
				break;
			}
			case 'P':{
				char addChar = testString.charAt(2);
				leftStk.push(addChar);
				break;
			}
			}
		}
		System.out.println(leftStk);
		System.out.println(rightStk);

		while(!leftStk.isEmpty()) {
			rightStk.push(leftStk.pop());
		}
		
		while(!rightStk.isEmpty()) {
			bw.write(rightStk.pop());
		}
		
		bw.flush();
		bw.close();
		
	}

}
