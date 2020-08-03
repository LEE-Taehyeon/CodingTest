package Search_Review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//백준(1026)_보물
public class TEST03_Search_1026 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int arrSize = Integer.valueOf(br.readLine());
		int[] arrA = new int[arrSize];
		PriorityQueue<Integer> priorQueue = new PriorityQueue<Integer>(Collections.reverseOrder());//B배열을 PriorityQueue를 내림차순으로 생성
		StringTokenizer stkA = new StringTokenizer(br.readLine());
		StringTokenizer stkB = new StringTokenizer(br.readLine());

		for(int i=0;i<arrSize;i++) {
			arrA[i] = Integer.valueOf(stkA.nextToken());
			priorQueue.offer(Integer.valueOf(stkB.nextToken()));
		}
		Arrays.sort(arrA);

		int sum = 0;
		for(int i=0;i<arrA.length;i++) {
			sum+=arrA[i]*priorQueue.poll();
		}
		System.out.println(sum);

	}

}
