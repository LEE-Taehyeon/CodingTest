package LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

//백준 알고리즘(1158) -> ArrayList를 이용해도 되나, LinkedList가 동작 속도면에서 더 빠르다.
public class TEST01_LinkedList_1158 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int[] testConditions = new int[2];
		
		for(int i=0;i<testConditions.length;i++) {
			testConditions[i] = Integer.valueOf(stk.nextToken());
		}
		
		List<Integer> list = new LinkedList<Integer>();
		
		for(int i=1;i<=testConditions[0];i++) {
			list.add(i);
		}

		int[] answer = new int[testConditions[0]];
		int j =0;
		while(!list.isEmpty()) {
			for(int i=0;i<testConditions[1]-1;i++) {
				list.add(list.remove(0));
			}
			answer[j++] = list.remove(0);
		}
		
		System.out.print("<");
		for(int i=0;i<answer.length;i++) {
			if(i==answer.length-1) {
				System.out.print(answer[i]+">");
			}else {
				System.out.print(answer[i]+", ");
			}
		}
		

	}

}
