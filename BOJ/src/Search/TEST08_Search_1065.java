package Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준(1065)_한수
public class TEST08_Search_1065 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int inputInteger = Integer.valueOf(br.readLine());
		int cnt = 0;
		
		if(inputInteger<=99) {
			System.out.println(inputInteger);
		}else {
			for(int i=111;i<=inputInteger;i++) {
				int firstNum = i/100;
				int secondNum = (i/10)%10;
				int lastNum = i%10;
				
				if(firstNum-secondNum==secondNum-lastNum) {
					cnt++;
				}
			}
			System.out.println(99+cnt);
		}

	}

}
