package Level3;

//프로그래머스(징검다리 건너기)
public class TEST03_2019_카카오개발자_겨울인턴십_징검다리건너기_S02 {
	public static void main(String[] args) {
		//int[] stones = { 2, 4, 5, 3, 2, 1, 4, 2, 5, 1 };
		int[] stones = { 1,1,1,1 };
		int k = 4;
		int result = solution(stones, k);
		System.out.println(result);

	}
	
	public static int solution(int[] stones, int k) {        
        int max = 0;
        int min = Integer.MAX_VALUE;
        
        for(int i:stones) {
        	max = Math.max(max, i);
        	min = Math.min(min, i);
        }
        
        if(max==min) {
        	return min;
        }
        
        while(min<max) {
        	int mid = (min + max)/2;
        	if(canCross(stones, k, mid)) {
        		min = mid + 1;
        	}else {
        		max = mid;
        	}
        }
 
        return min-1;
    }
	
	private static boolean canCross(int[] stones, int k, int mid) {
		int cnt = 0;
		
		for(int i:stones) {
			if(i<mid) {
				cnt++;
			}else {
				cnt = 0;
			}
			if(cnt == k) {
				return false;
			}
		}
		return true;
	}
}