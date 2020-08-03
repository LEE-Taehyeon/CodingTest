package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백주(9372)_상근이의 꿈 - 문제에서 최소 스패닝 트리라는 것을 알 수 있는 부분이 없다.
public class TEST01_BFS_9372 {
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.valueOf(br.readLine());
		
		for(int i=0;i<testCase;i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int nation = Integer.valueOf(stk.nextToken());
			int plane = Integer.valueOf(stk.nextToken());
			
			for(int j=0;j<plane;j++) {
				StringBuilder sb = new StringBuilder(br.readLine());
			}
			System.out.println(nation-1);
		}
	}
}
