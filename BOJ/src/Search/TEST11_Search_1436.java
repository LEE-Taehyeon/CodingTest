package Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준(1436)_영화감독 숌
public class TEST11_Search_1436 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int inputValue = Integer.valueOf(br.readLine());
		int answer = 666;
		int cnt = 0;
		
		while(true) {
			if(String.valueOf(answer).indexOf("666")>=0) {
				cnt++;
			}
			if(cnt==inputValue) {
				System.out.println(answer);
				break;
			}
			answer++;
		}

	}

}
