package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//CircularShift(환형 시픝)_알고리즘책 p659
public class CircularShift {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int totalTestCase = Integer.valueOf(br.readLine());
		
		for(int i=0;i<totalTestCase;i++) {
			int answer = 0;
			int testCase = Integer.valueOf(br.readLine());
			String parent = br.readLine();
			String pattern = br.readLine();
			 for(int j=0;j<testCase;j++) {
				 if(j!=0) {
					 parent = pattern;
					 pattern = br.readLine();
				 }
				 answer += kmp(parent+parent, pattern, j);
			 }
			System.out.println(answer);
		}
	}

	private static int kmp(String parent, String pattern, int clockOrReverse) {
		int[] pi = getPi(pattern);
		char[] parentCharArr = parent.toCharArray();
		char[] patternCharArr = pattern.toCharArray();
		int j = 0;
		int ck = clockOrReverse;
		int answer = 0;
		
		for(int i=0;i<parentCharArr.length;i++) {
			if(j>0 && parentCharArr[i]!=patternCharArr[j]) {
				j = pi[j-1];
			}
			if(parentCharArr[i]==patternCharArr[j]) {
				if(j==patternCharArr.length-1) {
					if(ck%2!=0) {
						answer += i-(patternCharArr.length-1);
						break;
					}else {
						answer += (parentCharArr.length-1-i);
						break;
					}
				}else {
					++j;
				}
			}
		}
		return answer;
	}

	private static int[] getPi(String pattern) {
		int[] pi = new int[pattern.length()];
		char[] patternCharArr = pattern.toCharArray();
		int j = 0;
		
		for(int i=1;i<patternCharArr.length;i++) {
			if(j>0 && patternCharArr[i]!=patternCharArr[j]) {
				j = pi[j-1];
			}
			if(patternCharArr[i]==patternCharArr[j]) {
				pi[i] = ++j;
			}
		}
		return pi;
	}

}
