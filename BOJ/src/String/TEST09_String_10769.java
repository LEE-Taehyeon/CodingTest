package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준(10769)_행복한지 슬픈지
public class TEST09_String_10769 {
	static int happy = 0;
	static int sad = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String sentence = br.readLine();
		
		for(int i=0;i<sentence.length();i++) {
			char ch = sentence.charAt(i);
			if(ch==':') {//예제 2번과 같은 경우를 판별하기 위해 ":"만을 찾으려고 하였다. 
				if(sentence.substring(i).length()>=3) {//i번째에서 자른 문자열의 길이가 3이상이어야 한다.(예제 2번과 같은 경우)
					checkEmotion(sentence.substring(i, i+3));
					i+=2;
				}else {
					break;
				}
			}else {
				continue;
			}
		}
		printEmotion();
	}
	
	private static void printEmotion() {
		if(happy>sad) {
			System.out.println("happy");
		}else if(happy<sad) {
			System.out.println("sad");
		}else if(happy!=0 && happy==sad) {
			System.out.println("unsure");
		}else if(happy==0 && sad==0) {
			System.out.println("none");
		}
		
	}
	
	private static void checkEmotion(String substring) {
		char[] charArr = substring.toCharArray();
		if(charArr[1]=='-' && charArr[2]==')') {
			happy++;
		}else if(charArr[1]=='-' && charArr[2]=='(') {
			sad++;
		}
	}

}
