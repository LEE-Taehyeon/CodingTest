package Level1_Review;

//프로그래머스_[1차]비밀지도
public class TEST01_Lv01_2018_KAKAO_BLIND_1차비밀지도_Review {
	public static void main(String[] args) {
		int n = 5;
		int[] arr1 = { 9, 20, 28, 18, 11 };
		int[] arr2 = { 30, 1, 21, 17, 28 };
		String[] result = solution(n, arr1, arr2);
		
		for(String str:result) {
			System.out.println(str);
		}
		
	}
	public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String[] str1 = new String[n];
        String[] str2 = new String[n];
        
        toBinaryMethod(arr1, str1, n);
        toBinaryMethod(arr2, str2, n);    
        
        for(int i=0;i<n;i++) {
        	StringBuilder sb = new StringBuilder();
        	for(int j=0;j<n;j++) {
        		char ch1 = str1[i].charAt(j);
        		char ch2 = str2[i].charAt(j);
        		
        		if(ch1=='1' || ch2=='1') {
        			sb.append("#");
        		}else {
        			sb.append(" ");
        		}
        	}
        	answer[i] = sb.toString();
        }
        return answer;
    }
	
	private static void toBinaryMethod(int[] arr1, String[] str1, int n) {
		for(int i=0;i<n;i++) {
			StringBuilder sb = new StringBuilder();
			int share = Integer.valueOf(arr1[i]);
			
			while(share>0) {
				int remain = share%2;
				share/=2;
				sb.append(remain);
			}
			
			while(sb.length()<n) {
				sb.append("0");
			}
			
			str1[i] = sb.reverse().toString();
		}
	}
}
