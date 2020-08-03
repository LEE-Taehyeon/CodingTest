package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//백준 알고리즘(ATM)
public class TEST01_Greedy_11399_S02 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int people = Integer.parseInt(br.readLine());
        int[] time = new int[people];
        int answer = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        for (int i = 0; i < people; i++) {
        	time[i] = Integer.parseInt(st.nextToken());
        }
		
		Arrays.sort(time);//모든 시간의 합이 가장 최소가 되려면 첫번째사람부터 마지막 사람까지의 걸리는 시간을 오름차순으로 정렬해야한다.
		//왜냐하면 첫번째사람은 총걸리는 시간에 계속적으로 합을 더해주기 때문에
		
		//int totalTime = 0;
		for(int i=0;i<time.length;i++) {
			//totalTime += time[i];
			//answer += totalTime;
			
			answer += time[i]*(time.length-i);
		}
		System.out.println(answer);

	}
}
