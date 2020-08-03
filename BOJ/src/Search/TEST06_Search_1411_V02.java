package Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준(1411)_비슷한 단어
public class TEST06_Search_1411_V02 {
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
				if (inputStrArr[i].length() != inputStrArr[j].length()) {
					continue;
				} else {
					char[] arrAtoB = new char[26];
					char[] arrBtoA = new char[26];
					StringBuffer sb = new StringBuffer();
					for (int k = 0; k < inputStrArr[i].length(); k++) {
						char ch1 = inputStrArr[i].charAt(k);
						char ch2 = inputStrArr[j].charAt(k);

						if (arrAtoB[ch1 - 'a'] != 0 && arrBtoA[ch2 - 'a'] != 0) {
							sb.append(ch2);
						} else if (arrAtoB[ch1 - 'a'] == 0 && arrBtoA[ch2 - 'a'] == 0) {
							arrAtoB[ch1 - 'a'] = ch2;
							arrBtoA[ch2 - 'a'] = ch1;
							sb.append(ch2);
						} else {
							continue Label;
						}
					}

					if (sb.toString().equals(inputStrArr[j])) {
						cnt++;
					}
				}

			}
		}
		System.out.println(cnt);
	}
}
