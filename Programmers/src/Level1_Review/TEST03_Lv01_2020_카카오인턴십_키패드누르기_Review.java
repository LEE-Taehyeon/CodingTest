package Level1_Review;

public class TEST03_Lv01_2020_카카오인턴십_키패드누르기_Review {
	public static void main(String[] args) {
		int[] numbers = {8,0};
		String hand = "right";
		String result = solution(numbers, hand);
		
		System.out.println(result);

	}
	public static String solution(int[] numbers, String hand) {
        String answer = "";
        int[][] hands = { {3,2,1,0},
        				  {1,2,3,4},
        				  {0,1,2,3},
        				  {1,2,3,4},
        				  {2,1,2,3},
        				  {1,0,1,2},
        				  {2,1,2,3},
        				  {3,2,1,2},
        				  {2,1,0,1},
        				  {3,2,1,2},
        				  {4,3,2,1}};//해당 위치에서 2,5,8,0이 들어왔을때의 거리
        int left = 10;
        int right = 10;
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<numbers.length;i++) {
        	if(numbers[i]%3==1) {//왼쪽 엄지에 해당하는 키패드(1,4,7)
        		sb.append("L");
        		left = numbers[i];
        	}else if(numbers[i]!=0 && numbers[i]%3==0) {//오른쪽 엄지에 해당하는 키패드(3,6,9)
        		sb.append("R");
        		right = numbers[i];
        	}else {//가운데에 해당하는 키패드(2,5,8,0)
        		int left_distance;
        		int right_distance;
        		
        		if(numbers[i]==0) {//키패드가 0일때
        			left_distance = hands[left][3];//왼손의 엄치 위치에서 0까지의 거리
        			right_distance = hands[right][3];//오른손의 엄지 위치에서 0까지의 거리
        			
        			if(left_distance==right_distance) {//0까지의 거리가 왼손, 오른손이 같다면
        				if(hand.equals("right")) {
        					sb.append("R");
        					right = numbers[i];
        				}else {
        					sb.append("L");
        					left = numbers[i];
        				}
        			}else {//다르다면
        				if(left_distance<right_distance) {
        					sb.append("L");
        					left = numbers[i];
        				}else {
        					sb.append("R");
        					right = numbers[i];
        				}
        			}
        		}else {//키패드가 2,5,8 일때
        			int column = (numbers[i]-2)/3;//위의 거리를 미리 저장한 배열(hands)에서 2는 0번 열, 5는 1번열, 8은 2번열이므로 이를 계산
        			left_distance = hands[left][column];
        			right_distance = hands[right][column];
        			
        			if(left_distance==right_distance) {
        				if(hand.equals("right")) {
        					sb.append("R");
        					right = numbers[i];
        				}else {
        					sb.append("L");
        					left = numbers[i];
        				}
        			}else {
        				if(left_distance<right_distance) {
        					sb.append("L");
        					left = numbers[i];
        				}else {
        					sb.append("R");
        					right = numbers[i];
        				}
        			}
        		}
        	}
        }
        
        answer = sb.toString();
        return answer;
    }
}
