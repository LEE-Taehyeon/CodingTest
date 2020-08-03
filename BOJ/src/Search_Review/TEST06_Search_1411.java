package Search_Review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준(1411)_비슷한 단어
public class TEST06_Search_1411 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.valueOf(br.readLine());
		String[] transformAlpha = new String[testCase];

		for(int i=0;i<testCase;i++) {
			String inputStr = br.readLine();
			int[] arr = new int[26];
			transformAlpha[i] = "";
			int num = 0;
			for(int j=0;j<inputStr.length();j++) {
				if(arr[inputStr.charAt(j)-'a']==0) {
					arr[inputStr.charAt(j)-'a'] = ++num;
				}
				transformAlpha[i] += arr[inputStr.charAt(j)-'a'];
			}
		}
		
		int cnt = 0;
		for(int i=0;i<testCase-1;i++) {
			for(int j=i+1;j<testCase;j++) {
				if(transformAlpha[i].equals(transformAlpha[j])) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);

	}
}
