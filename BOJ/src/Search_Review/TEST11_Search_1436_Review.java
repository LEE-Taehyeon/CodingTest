package Search_Review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준(1436)_영화감독 숌
public class TEST11_Search_1436_Review {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int inputValue = Integer.valueOf(br.readLine());
		int answer = 666;
		int cnt = 0;
		
		while(cnt!=inputValue) {
			int num = answer;
			int cnt666 = 0;
			while(num>0) {
				if(num%10==6) {
					cnt666++;
				}else {
					cnt666 = 0;
				}
				num/=10;
				if(cnt666>=3) {
					cnt++;
					break;
				}
			}
			answer++;
		}
		System.out.println(answer-1);
		
	}

}
