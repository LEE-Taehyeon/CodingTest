package Level2;

import java.util.Arrays;
import java.util.Comparator;

// -- 절반 정도 맞음
public class TEST06_Lv2_2018_KAKAO_BLIND_3차파일명정렬_V01 {
	public static void main(String[] args) {
		//String[] files = { "img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG" };
		String[] files = { "F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat" };
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
				
				int beginIndex = o1.length();
				int endIndex = 0;
				for(int i=0;i<o1.length();i++) {
					char ch = o1.charAt(i);
					
					if(ch>='0' && ch<='9') {
						if(beginIndex>i) {
							beginIndex = i;
						}
						if(endIndex<i) {
							endIndex = i;
						}
					}
				}
				String head1 = o1.substring(0, beginIndex).toUpperCase();
				int number1 = Integer.valueOf(o1.substring(beginIndex, endIndex+1));
				
				beginIndex = o2.length();
				endIndex = 0;
				for(int i=0;i<o2.length();i++) {
					char ch = o2.charAt(i);
					
					if(ch>='0' && ch<='9') {
						if(beginIndex>i) {
							beginIndex = i;
						}
						if(endIndex<i) {
							endIndex = i;
						}
					}
				}
				String head2 = o2.substring(0, beginIndex).toUpperCase();
				int number2 = Integer.valueOf(o2.substring(beginIndex, endIndex+1));
				
				if(head1.equals(head2)) {
					if(number1==number2) {
						return 0;
					}else {
						if(number1>number2) {
							return 1;
						}else {
							return -1;
						}
					}
				}else {
					return head1.compareTo(head2);
				}
			}
		});
        
        return files;
    }
}
