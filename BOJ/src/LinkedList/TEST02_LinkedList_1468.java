package LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

//백준 알고리즘(1468) - 시간초과
public class TEST02_LinkedList_1468 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputAlpabet = br.readLine();
		LinkedList<Character> linkedlist = new LinkedList<Character>();

		for (int i = 0; i < inputAlpabet.length(); i++) {
			linkedlist.add(inputAlpabet.charAt(i));
		}
		
		int testCase = Integer.valueOf(br.readLine());
	
		int cursor = linkedlist.size();

		for (int i = 0; i < testCase; i++) {
			String str = br.readLine();

			switch (str) {
			case "L": {
				if (cursor != 0) {
					cursor--;
				}
				break;
			}
			case "D": {
				if (cursor != linkedlist.size()) {
					cursor++;
				}
				break;
			}
			case "B": {
				if (cursor != 0) {
					linkedlist.remove(--cursor);
				}
				break;
			}
			default: {
				char strCh = str.charAt(str.length()-1);
				linkedlist.add(cursor, strCh);
				cursor++;
			}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<linkedlist.size();i++) {
			sb.append(linkedlist.get(i));
		}
		System.out.println(sb);
	}

}
