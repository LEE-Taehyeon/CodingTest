package LinkedList_Review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;

//백준 알고리즘(5397번) - Stack 두 개를 이용한 풀이
public class TEST03_LinkedList_5397_Review_R02 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.valueOf(br.readLine());
		
		for(int i=0;i<testCase;i++) {
			String password = br.readLine();
			
			Stack<Character> leftStk = new Stack<Character>();
			Stack<Character> rightStk = new Stack<Character>();
			
			for(int j=0;j<password.length();j++) {
				char pw = password.charAt(j);
				
				switch(pw) {
				case '<':{
					if(!leftStk.isEmpty()) {
						rightStk.add(leftStk.pop());
					}
					break;
				}
				case '>':{
					if(!rightStk.isEmpty()) {
						leftStk.add(rightStk.pop());
					}
					break;
				}
				case '-':{
					if(!leftStk.isEmpty()) {
						leftStk.pop();
					}
					break;
				}
				default:{
					leftStk.add(pw);
					break;
				}
				}
			}
			
			while(!leftStk.isEmpty()) {
				rightStk.push(leftStk.pop());
			}
			StringBuilder sb = new StringBuilder();
			while(!rightStk.isEmpty()) {
				sb.append(rightStk.pop());
			}
			System.out.println(sb);
		}

	}
}
