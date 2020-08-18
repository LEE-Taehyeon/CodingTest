package Level3;

//프로그래머스(징검다리 건너기)
public class TEST03_2019_카카오개발자_겨울인턴십_징검다리건너기_S01_V02_FailFailFail {
	public static void main(String[] args) {
		//int[] stones = { 2, 4, 5, 3, 2, 1, 4, 2, 5, 1 };
		int[] stones = { 10,8,11,3,2 };
		int k = 3;
		int result = solution(stones, k);
		System.out.println(result);

	}
	public static int solution(int[] stones, int k) {
        int answer = 0;
        int min = Integer.MAX_VALUE;
        
        
        for(int i=0;i<=stones.length-k;i++) {
        	int max = stones[i];
        	int idx = 0;
        	
        	for(int j=i+1;j<k+i;j++) {
        		if(stones[j]>max) {
        			max = stones[j];
        			idx = j;
        		}
        	}
        	
        	if(idx != 0) {
        		i = idx;
        	}
        	
        	if(max<min) {
        		min = max;
        	}
        	
        }
        answer = min;
        
        return answer;
    }
}
