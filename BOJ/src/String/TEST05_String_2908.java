package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준(2908)_상수
public class TEST05_String_2908 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputStrArr = br.readLine().split(" ");
		String maxNum = "";
		
		for(int i=2;i>=0;i--) {
			char frontStrCh = inputStrArr[0].charAt(i);
			char backStrCh = inputStrArr[1].charAt(i);
			
			if(frontStrCh>backStrCh) {
				maxNum = inputStrArr[0];
				break;
			}else if(frontStrCh<backStrCh) {
				maxNum = inputStrArr[1];
				break;
			}
		}//두 수 중 거꾸로 비교했을 때 더 큰 수 찾기
		
		StringBuilder sb = new StringBuilder();
		for(int i=2;i>=0;i--) {
			sb.append(maxNum.charAt(i));
		}
		System.out.println(sb.toString());
	}
}
