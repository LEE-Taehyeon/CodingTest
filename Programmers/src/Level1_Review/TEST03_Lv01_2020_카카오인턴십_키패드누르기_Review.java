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
        				  {4,3,2,1}};
        int left = 10;
        int right = 10;
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<numbers.length;i++) {
        	if(numbers[i]%3==1) {
        		sb.append("L");
        		left = numbers[i];
        	}else if(numbers[i]!=0 && numbers[i]%3==0) {
        		sb.append("R");
        		right = numbers[i];
        	}else {
        		/*
        		System.out.println("left:"+left);
        		System.out.println("right:"+right);
        		*/
        		int left_distance;
        		int right_distance;
        		
        		if(numbers[i]==0) {
        			left_distance = hands[left][3];
        			right_distance = hands[right][3];
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
        		}else {
        			int column = (numbers[i]-2)/3;
        			left_distance = hands[left][column];
        			right_distance = hands[right][column];
        			/*
        			System.out.println("left:"+left);
        			System.out.println("right:"+right);
        			System.out.println("column:"+column);
        			System.out.println("left_distance:"+left_distance);
        			System.out.println("right_distance:"+right_distance);
        			*/
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
        	//System.out.println(sb);
        }
        
        //System.out.println(sb);
        answer = sb.toString();
        return answer;
    }
}
