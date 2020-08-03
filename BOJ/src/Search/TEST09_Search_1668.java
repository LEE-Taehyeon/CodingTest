package Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준(1668)_트로피 진열
public class TEST09_Search_1668 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.valueOf(br.readLine());
		int[] trophys = new int[testCase];
		
		for(int i=0;i<trophys.length;i++) {
			trophys[i] = Integer.valueOf(br.readLine());
		}
		
		int bigger = trophys[0];
		int cnt = 1;
		for(int i=1;i<trophys.length;i++) {
			if(bigger<trophys[i]) {
				cnt++;
				bigger = trophys[i];
			}
		}
		System.out.println(cnt);
		
		bigger = trophys[trophys.length-1];
		cnt = 1;
		for(int i=trophys.length-2;i>=0;i--) {
			if(bigger<trophys[i]) {
				cnt++;
				bigger = trophys[i];
			}
		}
		System.out.println(cnt);
	}

}
