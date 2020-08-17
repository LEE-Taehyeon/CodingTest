package Level1_Review;

public class TEST03_Lv01_2020_카카오인턴십_키패드누르기_Review_anotherSol {
	public static void main(String[] args) {
		int[] numbers = {8,0};
		String hand = "right";
		String result = solution(numbers, hand);
		
		System.out.println(result);

	}
	public static String solution(int[] numbers, String hand) {
        String answer = "";
        int left_r = 3;
        int left_c = 0;
        int right_r = 3;
        int right_c = 2;//키패드를 이차원배열로 보았을때 즉, 1번 키패드는 (0,0)에 위치.
        //따라서 처음 시작위치를 지정한 것.
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<numbers.length;i++) {
        	if(numbers[i]%3==1) {//키패드가 1,4,7 일때,
        		sb.append("L");
        		left_r = numbers[i]/3;
        		left_c = 0;
        	}else if(numbers[i]%3==0){//키패드가 3,6,9,0 일때
        		if(numbers[i]==0) {//키패드가 0일 때
        			int left_distance = Math.abs(left_r-3)+Math.abs(left_c-1);//좌표의 거리를 계산 한것.
        			int right_distance = Math.abs(right_r-3)+Math.abs(right_c-1);
        			
        			//이후 과정은 이전 풀이와 비슷. 다만 좌표를 설정하는 부분이 조금 다르다.
        			if(left_distance==right_distance) {
        				if(hand.equals("right")) {
        					sb.append("R");
            				right_r = 3;
            				right_c = 1;//0의 좌표인 (3,1)을 저장
        				}else {
        					sb.append("L");
            				left_r = 3;
            				left_c = 1;
        				}
        			}else {
        				if(left_distance>right_distance) {
            				sb.append("R");
            				right_r = 3;
            				right_c = 1;
            			}else {
            				sb.append("L");
            				left_r = 3;
            				left_c = 1;
            			}
        			}
        		}else {
        			sb.append("R");
        			right_r = (numbers[i]-3)/3;
        			right_c = 2;
        		}
        	}else {
        		int left_distance = Math.abs(left_r-((numbers[i]-2)/3))+Math.abs(left_c-1);
    			int right_distance = Math.abs(right_r-((numbers[i]-2)/3))+Math.abs(right_c-1);
    			if(left_distance==right_distance) {
    				if(hand.equals("right")) {
    					sb.append("R");
        				right_r = ((numbers[i]-2)/3);
        				right_c = 1;
    				}else {
    					sb.append("L");
        				left_r = ((numbers[i]-2)/3);
        				left_c = 1;
    				}
    			}else {
    				if(left_distance>right_distance) {
        				sb.append("R");
        				right_r = ((numbers[i]-2)/3);
        				right_c = 1;
        			}else {
        				sb.append("L");
        				left_r = ((numbers[i]-2)/3);
        				left_c = 1;
        			}
    			}
    			
        	}
        }
        
        answer = sb.toString();
        
        return answer;
    }
}
