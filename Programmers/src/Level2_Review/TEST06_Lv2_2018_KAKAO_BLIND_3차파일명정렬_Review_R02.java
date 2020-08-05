package Level2_Review;

import java.util.Arrays;
import java.util.Comparator;

//head와 number 구분하기 다른방법
public class TEST06_Lv2_2018_KAKAO_BLIND_3차파일명정렬_Review_R02 {
	public static void main(String[] args) {
		String[] files = { "img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG" };
		//String[] files = { "A-10 Thunderbolt II", "B-50 Superfortress", "F-5 Freedom Fighter", "F-14 Tomcat" };	
		//String[] files = { "F15", "f0014", "FF16", "A0001", "foo010bar020.zip" };
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
				
				String head1 = o1.split("[0-9]+")[0].toUpperCase();
				String head2 = o2.split("[0-9]+")[0].toUpperCase();
				int compareNum = head1.compareTo(head2);
				
				if(compareNum==0) {
					int number1 = findNum(head1, o1);
					int number2 = findNum(head2, o2);
					return number1-number2;
				}else {
					return compareNum;
				}
			}

			private int findNum(String head, String o) {
				String number = "";
				for(int i=head.length();i<o.length();i++) {
					char ch = o.charAt(i);
					if(!(ch>='0' && ch<='9')) {
						break;
					}
					number+=ch;
				}
				return Integer.valueOf(number);
			}

		});
        
        return files;
    }
}
