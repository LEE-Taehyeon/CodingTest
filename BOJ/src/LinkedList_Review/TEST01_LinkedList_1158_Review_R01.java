package LinkedList_Review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 알고리즘(1158) -> ArrayList를 이용해도 되나, LinkedList가 동작 속도면에서 더 빠르다.
public class TEST01_LinkedList_1158_Review_R01 {
	public static void main(String[] args) throws IOException {
		// Deque를 이용한 풀이
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int peoples = Integer.valueOf(stk.nextToken());
		int n = Integer.valueOf(stk.nextToken());
		
		Deque<Integer> deque = new LinkedList<Integer>();
		for(int i=1;i<=peoples;i++) {
			deque.add(i);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		while(!deque.isEmpty()) {
			for(int i=0;i<n-1;i++) {
				deque.addLast(deque.removeFirst());
			}
			sb.append(deque.removeFirst()+", ");
		}
		sb.delete(sb.lastIndexOf(", "), sb.length());
		sb.append(">");
		System.out.println(sb);
		
		
		
	}

}
