package Search_Review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준알고리즘(1100)_하얀 칸
public class TEST02_Search_1100_Review {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = 0;
		
		for(int i=0;i<8;i++) {
			StringBuilder sb = new StringBuilder(br.readLine());
			for(int j=i%2;j<sb.length();j+=2) {
				cnt += sb.charAt(j)=='F'?1:0;
			}
		}
		
		System.out.println(cnt);

	}

}
