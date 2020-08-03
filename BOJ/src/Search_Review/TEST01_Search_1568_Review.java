package Search_Review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준알고리즘(1568)_새
public class TEST01_Search_1568_Review {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		int num = 1;
		
		while(n>0) {
			if(n>=num) {
				n-=num;
				num++;
				cnt++;
			}else {
				num = 1;
			}
		}
		
		System.out.println(cnt);
	}
}
