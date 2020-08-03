package String;

public class KMP {
	public static void main(String[] args) {
		String parent = "ABCDABCABCDE";
		String pattern = "ABCD";
		String result = kmp(parent, pattern);
		System.out.println(result);
	}

	private static String kmp(String parent, String pattern) {
		int[] pi = getPi(pattern);
		String answer = "";
		char[] parentCharArr = parent.toCharArray();
		char[] patternCharArr =  pattern.toCharArray();
		int j = 0;
		
		for(int i=0;i<parent.length();i++) {
			while(j>0 && patternCharArr[j]!=parentCharArr[i]) {
				j = pi[j-1];
			}
			if(patternCharArr[j]==parentCharArr[i]) {
				if(j==patternCharArr.length-1) {
					j = pi[j-1];
					answer += i-(patternCharArr.length-1) +", ";
				}else {
					j++;
				}
			}
		}
		return answer;
	}

	private static int[] getPi(String pattern) {
		char[] patternCharArr = pattern.toCharArray();
		int[] pi = new int[pattern.length()];
		int j = 0;
		
		for(int i=1;i<patternCharArr.length;i++) {
			while(j>0 && patternCharArr[j]!=patternCharArr[i]) {
				j = pi[j-1];
			}
			if(patternCharArr[j]==patternCharArr[i]) {
				pi[i] = ++j;
			}
		}
		return pi;
	}
}
