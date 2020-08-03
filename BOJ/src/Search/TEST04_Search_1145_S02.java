package Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준(1145)_적어도 대부분의 배수
public class TEST04_Search_1145_S02 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[5];
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.valueOf(stk.nextToken());
		}
		
		int min = 101;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]<min) {
				min = arr[i];
			}
		}
		
		boolean run = true;
		int answer = 1;
		int cnt = 0;
		while(run) {
			answer = ++min;
			for(int i=0;i<arr.length;i++) {
				if(answer%arr[i]==0) {
					cnt++;
				}
			}
			if(cnt>=3) {
				run=false;
			}
			cnt = 0;
		}
		System.out.println(answer);
	}
}
