package LinkedList_Review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 알고리즘(1158) -> ArrayList를 이용해도 되나, LinkedList가 동작 속도면에서 더 빠르다.
public class TEST01_LinkedList_1158_Review_R03 {
	public static void main(String[] args) throws IOException {
		// Deque를 이용한 풀이
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int peoples = Integer.valueOf(stk.nextToken());
		int n = Integer.valueOf(stk.nextToken());

		LinkedList<Integer> linkedlist = new LinkedList<Integer>();
		for (int i = 0; i <= peoples; i++) {
			linkedlist.add(i);
		}

		int cnt = 0, i = 0;
		while (linkedlist.size() != 1) {
			cnt++;
			i = i == linkedlist.size() - 1 ? 1 : i + 1;

			if (cnt % n == 0) {
				System.out.println(linkedlist.remove(i));
				i -= 1;
			}
		}

	}

}
