package String_Review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준(10769)_행복한지 슬픈지
public class TEST09_String_10769_Review {
	static int happy = 0;
	static int sad = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String sentence = br.readLine();
		int happy = 0;
		int sad = 0;
		
		for(int i=0;i<sentence.length();i++) {
			int findIndex = sentence.indexOf(":-", i);
			if(findIndex==-1) {
				break;
			}else {
				if(sentence.substring(findIndex).length()>=3) {
					switch (sentence.charAt(findIndex+2)) {
					case ')':{
						happy++;
						break;
					}
					case '(':{
						sad++;
						break;
					}
					default:
						break;
					}
				}
				i=findIndex+2;
			}
		}
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


}
