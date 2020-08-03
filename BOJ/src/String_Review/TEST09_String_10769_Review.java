package String_Review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준(10769)_행복한지 슬픈지
public class TEST09_String_10769_Review {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = br.readLine();
		int happy = 0;
		int sad = 0;
		int beginIndex = 0;
		
		while(beginIndex<inputStr.length()) {
			beginIndex = inputStr.indexOf(":-", beginIndex);//happy든 sad든  :- 까지는 일치하므로 indexOf로 :- 찾기
			//단, 뒤에 인자로 시작 인덱스를 넣어주므로서 이전에 찾았던 표정은 다시 검토X
			
			if(beginIndex==-1) {//해당 문자(":-") 찾지못함 -> while 탈출
				break;
			}else {
				char ch = inputStr.charAt(beginIndex+2);//":-" 이후 문자가 )인지, (인지 판별하기 위해 시작 인덱스+2를 판별
				if(ch==')') {
					happy++;
				}else if(ch=='(') {
					sad++;
				}
			}
			beginIndex+=3;//시작 인덱스를 앞으로 당기기위한 작업 -> 18번째 줄과 관련
 		}
		
		if(happy>sad) {
			System.out.println("happy");
		}else if(happy<sad) {
			System.out.println("sad");
		}else if(happy!=0 && happy==sad) {
			System.out.println("unsure");
		}else {
			System.out.println("none");
		}
		
	}
}
