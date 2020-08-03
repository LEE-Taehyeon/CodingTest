package String;

public class StringMatch {

	public static void main(String[] args) {
		String parent = "AGESCEGAGEGSAGER";
		String pattern = "AGE";
		String result = solution(parent, pattern);
		System.out.println(result);
	}

	private static String solution(String parent, String pattern) {
		char[] parentCharArr = parent.toCharArray();
		char[] patternCharArr = pattern.toCharArray();
		String answer = "";
		
		for(int i=0;i<parentCharArr.length;i++) {
			boolean run = true;
			for(int j=0;j<patternCharArr.length;j++) {
				if(parentCharArr[i+j]!=patternCharArr[j]) {
					run = false;
					break;
				}
			}
			if(run) {
				answer += i+",";
			}
		}
		return answer;
	}

}
