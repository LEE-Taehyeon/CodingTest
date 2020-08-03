package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준(1120)_문자열
public class TEST07_Greedy_1120 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		char[] aArr = stk.nextToken().toCharArray();
		char[] bArr = stk.nextToken().toCharArray();
		
		int max = 0;
		for(int i=0;i<=bArr.length-aArr.length;i++) {
			int cnt = 0;
			for(int j=0;j<aArr.length;j++) {
				if(bArr[i+j]==aArr[j]) {
					cnt++;
				}
			}
			max = Math.max(max, cnt);
		}
		System.out.println(aArr.length-max);
	}

}
