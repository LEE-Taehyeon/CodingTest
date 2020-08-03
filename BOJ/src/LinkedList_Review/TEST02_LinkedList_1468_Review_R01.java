package LinkedList_Review;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;

//백준 알고리즘(1468) - ListIterator 사용
public class TEST02_LinkedList_1468_Review_R01 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String inputAlpabet = br.readLine();
		LinkedList<Character> linkedlist = new LinkedList<Character>();
		

		for (int i = 0; i < inputAlpabet.length(); i++) {
			linkedlist.add(inputAlpabet.charAt(i));
		}

		//iterator - list에 값을 넣기 전에 선언하면 안된다.
		ListIterator<Character> iter = linkedlist.listIterator();
		while(iter.hasNext()) {
			iter.next();
		}//커서가 문자열 맨 마지막에 위치하므로 ListIterator를 끝으로 이동시킴

		int testCase = Integer.valueOf(br.readLine());

		for (int i = 0; i < testCase; i++) {
			char[] charArr = br.readLine().toCharArray();

			switch (charArr[0]) {
			case 'L': {
				if(iter.hasPrevious()) {
					iter.previous();
				}
				break;
			}
			case 'D': {
				if(iter.hasNext()) {
					iter.next();
				}
				break;
			}
			case 'B': {
				if(iter.hasPrevious()) {
					iter.previous();
					iter.remove();
				}
				break;
			}
			case 'P': {
				char ch = charArr[2];
				iter.add(ch);
				break;
			}
			}
		}

		for(Character chr : linkedlist) {
			bw.write(chr);
		}
		
		bw.flush();
		bw.close(); 
	}

}
