package Sieve_of_Eratosthenes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준(2960)_에라토스테네스의 체
public class TEST01_Sieve_of_Eratosthenes_2960 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(stk.nextToken());
		int k = Integer.valueOf(stk.nextToken());
		int[] inputArr = new int[n+1];
		int[] ouputArr = new int[n+1];
		int cnt = 0;
		
		for(int i=2;i<=n;i++) {
			inputArr[i] = i;
		}
		
		for(int i=2;i<=n;i++) {
			if(inputArr[i]==0) {
				continue;
			}
			for(int j=i;j<=n;j+=i) {
				if(inputArr[j]!=0) {
					ouputArr[cnt++] = inputArr[j];
					inputArr[j] = 0;
				}
			}
		}
		
		System.out.println(ouputArr[k-1]);
		
	}
}