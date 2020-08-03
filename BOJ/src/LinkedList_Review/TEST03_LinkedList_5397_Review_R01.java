package LinkedList_Review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

//백준 알고리즘(5397번) - LinkedList 를 이용한 풀이
public class TEST03_LinkedList_5397_Review_R01 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.valueOf(br.readLine());
		
		for(int i=0;i<testCase;i++) {
			String password = br.readLine();
			
			LinkedList<Character> linkedList = new LinkedList<Character>();
			ListIterator<Character> iter = linkedList.listIterator();
			
			for(int j=0;j<password.length();j++) {
				char pw = password.charAt(j);
				
				switch(pw) {
				case '<':{
					if(iter.hasPrevious()) {
						iter.previous();
					}
					break;
				}
				case '>':{
					if(iter.hasNext()) {
						iter.next();
					}
					break;
				}
				case '-':{
					if(iter.hasPrevious()) {
						iter.previous();
						iter.remove();
					}
					break;
				}
				default:{
					iter.add(pw);
					break;
				}
				}
			}
			
			StringBuilder sb = new StringBuilder();
			for(char ch:linkedList) {
				sb.append(ch);
			}
			System.out.println(sb);
			
		}
	}
}
