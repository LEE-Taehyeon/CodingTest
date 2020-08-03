package Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//백준(1316)_그룹 단어 체커
public class TEST07_Search_1316 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.valueOf(br.readLine());
		int answer = 0;
		
		Label:for(int i=0;i<testCase;i++) {
			char[] inputCharArr = br.readLine().toCharArray();
			int[] arr = new int[26];
			int beforeNum = 0;
			int cnt = 1;
			
			for(int j=0;j<inputCharArr.length;j++) {
				if(arr[inputCharArr[j]-'a']==0) {
					arr[inputCharArr[j]-'a'] = cnt++;
					beforeNum = arr[inputCharArr[j]-'a'];
				}else if(arr[inputCharArr[j]-'a']<beforeNum) {
					continue Label;
				}
			}
			answer++;
		}		
		System.out.println(answer);
	}
}
/*
 * BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.valueOf(br.readLine());
		int cnt = 0;
		
		for(int i=0;i<testCase;i++) {
			char[] inputCharArr = br.readLine().toCharArray();
			List<Character> inputAlzipList = new ArrayList<Character>();
			inputAlzipList.add(inputCharArr[0]);

			for(int j=0;j<inputCharArr.length-1;j++) {
				if(inputCharArr[j]!=inputCharArr[j+1]) {
					inputAlzipList.add(inputCharArr[j+1]);
				}
			}

			if(inputAlzipList.size()==1) {
				continue;
			}
			for(int j=1;j<inputAlzipList.size();j++) {
				String[] compareStrArr = new String[j];
				String str = Character.toString(inputAlzipList.get(j));
				for(int m=0;m<j;m++) {
					compareStrArr[m] = Character.toString(inputAlzipList.get(m));
				}
				
				if(Arrays.asList(compareStrArr).contains(str)) {
					cnt++;
					break;
				}
			}
			
			Label:for(int j=0;j<inputAlzipList.size()-1;j++){
				for(int k=j+1;k<inputAlzipList.size();k++){
					if(inputAlzipList[j]==inputAlzipList[k]){
						cnt++;
						break Label;
					}
				}
			}
		}
 *		System.out.println(testCase-cnt);
 */

/*
 * BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.valueOf(br.readLine());
		int cnt = 0;

		for (int i = 0; i < testCase; i++) {
			char[] inputCharArr = br.readLine().toCharArray();
			List<Character> inputAlzipList = new ArrayList<Character>();
			inputAlzipList.add(inputCharArr[0]);

			for (int j = 0; j < inputCharArr.length - 1; j++) {
				if (inputCharArr[j] != inputCharArr[j + 1]) {
					inputAlzipList.add(inputCharArr[j + 1]);
				}
			}

			if (inputAlzipList.size() == 1) {
				continue;
			}

			Label: for (int j = 0; j < inputAlzipList.size() - 1; j++) {
				for (int k = j + 1; k < inputAlzipList.size(); k++) {
					if (inputAlzipList.get(j) == inputAlzipList.get(k)) {
						cnt++;
						break Label;
					}
				}
			}
		}
		System.out.println(testCase - cnt);
 */
