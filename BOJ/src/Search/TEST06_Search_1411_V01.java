package Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준(1411)_비슷한 단어
public class TEST06_Search_1411_V01 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.valueOf(br.readLine());
		String[] inputStrArr = new String[testCase];

		for (int i = 0; i < inputStrArr.length; i++) {
			inputStrArr[i] = br.readLine();
		}

		int cnt = 0;
		for (int i = 0; i < inputStrArr.length; i++) {
			Label: for (int j = i + 1; j < inputStrArr.length; j++) {
				
				String str = inputStrArr[i];
				String strCompare = inputStrArr[i];
				if (str.length() != inputStrArr[j].length()) {
					continue;
				} else {
					char[] charArr = new char[26];
					for (int k = 0; k < str.length(); k++) {
						char ch1 = str.charAt(k);
						char ch2 = inputStrArr[j].charAt(k);
						
						if (charArr[ch1 - 'a'] != 0) {
							if(charArr[ch1 - 'a'] != ch2) {
								continue Label;
							}
						} else {
							charArr[ch1 - 'a'] = ch2;
							strCompare = str.replace(Character.toString(ch1), Character.toString(ch2));
						}
					}
					
					if (strCompare.equals(inputStrArr[j])) {
						cnt++;
					}
				}

			}
		}
		System.out.println(cnt);
	}
}
