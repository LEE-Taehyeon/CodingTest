package Greedy_Review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준(1439)_뒤집기
public class TEST06_Greedy_1439_Review {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] inputCharArr = br.readLine().toCharArray();
		int cnt = 1;
		char compare = inputCharArr[0];
		
		for(char ch:inputCharArr) {
			if(ch!=compare) {
				cnt++;
				compare = ch;
			}
		}
		System.out.println(cnt/2);

	}

}
