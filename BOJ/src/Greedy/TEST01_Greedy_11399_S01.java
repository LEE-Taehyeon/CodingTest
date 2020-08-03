package Greedy;

import java.util.Arrays;
import java.util.Scanner;

//백준 알고리즘(ATM)
public class TEST01_Greedy_11399_S01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int people = scanner.nextInt();//사람수
		int[] time = new int[people];
		int answer = 0;
		
		for(int i=0;i<time.length;i++) {
			time[i] = scanner.nextInt();//시간 받기
		}
		Arrays.sort(time);//모든 시간의 합이 가장 최소가 되려면 첫번째사람부터 마지막 사람까지의 걸리는 시간을 오름차순으로 정렬해야한다.
		//왜냐하면 첫번째사람은 총걸리는 시간에 계속적으로 합을 더해주기 때문에
		
		answer = solution(time);
		
		for(int i=0;i<time.length;i++) {
			System.out.println(time[i]);
		}
	
		System.out.println(answer);
		scanner.close();
	}

	private static int solution(int[] time) {
		int totalTime = 0;
		int peopleTime = 0;
		for(int i=0;i<time.length;i++) {
			//totalTime += time[i]*(time.length-i);
			peopleTime += time[i];
			totalTime += peopleTime;
		}
		return totalTime;
	}

}
