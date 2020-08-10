package Level2;

import java.util.Arrays;
import java.util.Comparator;

// -- 절반 정도 맞음 - 틀린이유: 이전 코드에서 foo010bar020.zip 같은 경우 010bar020을 숫자로 인식하였기 때문에. -> 52번재 줄 추가
public class TEST06_Lv2_2018_KAKAO_BLIND_3차파일명정렬_S01_V02 {
	public static void main(String[] args) {
		//String[] files = { "img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG" };
		String[] files = { "F15", "f0014", "FF16", "A0001", "foo010bar020.zip" };
		String[] result = solution(files);
		
		for(String str:result) {
			System.out.println(str);
		}
		
	}
	public static String[] solution(String[] files) {
        String[] answer = {};
        
        Arrays.sort(files, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				String[] file1 = subStringFile(o1);
				String[] file2 = subStringFile(o2);
				
				int compareNum = file1[0].compareTo(file2[0]);
				
				if(compareNum==0) {
					return Integer.valueOf(file1[1])-Integer.valueOf(file2[1]);
				}else {
					return compareNum;
				}
				
			}

			private String[] subStringFile(String str) {
				int beginIndex = str.length();
				int endIndex = 0;
				
				for(int i=0;i<str.length();i++) {
					char ch = str.charAt(i);
					
					if(ch>='0' && ch<='9') {//문자열의 탐색하는데 해당 문자가 숫자이면 if문 안을 수행
						if(beginIndex>i) {//최초의 숫자가 나타날 때의 index값을 저장하기 위한 조건
							beginIndex = i;
						}
						if(endIndex<i) {//마지막 숫자가 나타날 때의 index값을 저장하기 위한 조건
							endIndex = i;
						}
					}else if(endIndex!=0 && !(ch>='0' && ch<='9')) {//endIndex가 0이 아니고(즉, 이전에 숫자가 나타났고) 이후 문자가 숫자가 아니면 break; -> 조건에 맞는모든 숫자탐색
						break;
					}//위의 else if문이 없으면 foo010bar020.zip 과 같은 문자열이 들어왔을 경우, 010bar020까지 number로 취급한다. 
				}
				
				String[] file = {str.substring(0, beginIndex).toUpperCase(), str.substring(beginIndex, endIndex+1), str.substring(endIndex+1)};
				
				return file;
			}
		});
        
        return files;
    }
}
