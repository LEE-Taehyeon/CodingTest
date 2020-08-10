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
        String[] str1 = new String[n];//2진수를 저장하기 위한 배열1
        String[] str2 = new String[n];//2진수를 저장하기 위한 배열2
        
        toBinaryMethod(arr1, str1, n);
        toBinaryMethod(arr2, str2, n);//해당 배열의 원소를 2진수로 변환 및 저장
        
        for(int i=0;i<n;i++) {
        	StringBuilder sb = new StringBuilder();
        	for(int j=0;j<n;j++) {
        		char ch1 = str1[i].charAt(j);
        		char ch2 = str2[i].charAt(j);
        		
        		if(ch1=='1' || ch2=='1') {//둘 중 하나라도 1이면 1(#)
        			sb.append("#");
        		}else {//아니면 0( )(공백)
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
			}//몫이 0보다 작을 때까지 나머지를 계속 더하기(단, 여기서의 2진수는 계속해서 거꾸로 이어붙여 나간다.)
			
			while(sb.length()<n) {//만약 2진수의 수가 n보다 작다면 그 갯수만큼 0을 붙여준다.
				sb.append("0");
			}
			
			str1[i] = sb.reverse().toString();//그렇게 구한 2진수는 거꾸로 이어붙였으므로 뒤집어서 리턴
		}
	}
}
