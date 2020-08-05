package Level2_Review;

import java.util.Arrays;
import java.util.Comparator;

//head와 number 구분하기 다른방법
public class TEST06_Lv2_2018_KAKAO_BLIND_3차파일명정렬_Review_R01 {
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
				
				String[] file1 = findHeadAndNum(o1);
				String[] file2 = findHeadAndNum(o2);
				
				int compareNum = file1[0].compareTo(file2[0]);
				if(compareNum==0) {
					return Integer.valueOf(file1[1])-Integer.valueOf(file2[1]);
				}else {
					return compareNum;
				}
			}

			private String[] findHeadAndNum(String o1) {
				String[] file = new String[2];
				String head = "";
				String number = "";
				int idx = 0;
				
				while(idx<o1.length()) {//head구하기
					char ch = o1.charAt(idx);
					/*
					if(ch>='0' && ch<='9') {
						break;
					}
					*/
					if(Character.isDigit(ch)) {//ch를 숫자로 바꿀 수 있으면 break;
						break;
					}
					head+=ch; 
					idx++;
				}
				
				while(idx<o1.length()) {//number구하기
					//주의 idx++이기 때문에 while(true)로 해주게 되면 문자열을 넘어서 체크하게 된다. 따라서 while문 조건을 문자열길이를 넘지 않도록
					char ch = o1.charAt(idx);
					/*
					if(!(ch>='0' && ch<='9')) {
						break;
					}
					*/
					if(!Character.isDigit(ch)) {//ch를 숫자로 바꾸지 못하면 break; 
						break;
					}
					number+=ch; 
					idx++;
				}

				file[0] = head.toUpperCase();
				file[1] = number;
				return file;
			}
		});
        
        return files;
    }
}
