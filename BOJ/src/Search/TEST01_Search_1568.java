package Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준알고리즘(1568)_새
public class TEST01_Search_1568 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int sum = 0;
		int cnt = 0;
		
		for(int i=1;sum!=n;i++) {
			sum+=i;
			cnt++;
			if(sum>n) {
				sum-=i;
				i=0;
				cnt--;
			}
			/*
			 * if(sum==n) { break; }
			 */
		}
		System.out.println(cnt);
	}
}
