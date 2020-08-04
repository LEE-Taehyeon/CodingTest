package Level2;

import java.util.Arrays;
import java.util.Comparator;

// -- 절반 정도 맞음 - 틀린이유: 이전 코드에서 foo010bar020.zip 같은 경우 010bar020을 숫자로 인식하였기 때문에. -> 52번재 줄 추가
public class TEST06_Lv2_2018_KAKAO_BLIND_3차파일명정렬_V02 {
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
					
					if(ch>='0' && ch<='9') {
						if(beginIndex>i) {
							beginIndex = i;
						}
						if(endIndex<i) {
							endIndex = i;
						}
					}else if(endIndex!=0 && !(ch>='0' && ch<='9')) {//해당 코드를 넣어주므로서 해결
						break;
					}
				}
				
				String[] file = {str.substring(0, beginIndex).toUpperCase(), str.substring(beginIndex, endIndex+1), str.substring(endIndex+1)};
				
				return file;
			}
		});
        
        return files;
    }
}
