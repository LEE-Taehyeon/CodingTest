package Level3;

//프로그래머스(징검다리 건너기) - 정확성 2개 틀림 / 효율성 0.0
public class TEST03_2019_카카오개발자_겨울인턴십_징검다리건너기_S01_V01_FailFailFail {
	public static void main(String[] args) {
		//int[] stones = { 2, 4, 5, 3, 2, 1, 4, 2, 5, 1 };
		int[] stones = { 1, 1, 1, 3, 2, 1, 4, 2, 5, 1 };
		int k = 3;
		int result = solution(stones, k);
		System.out.println(result);

	}
	public static int solution(int[] stones, int k) {
        int answer = 0;
        int max = 0;
        int min = 200001;
        int idx = 0;
        
        for(int i=0;i<stones.length-k;i++) {
        	if(i>idx) {
        		max = 0;
        	}
        	for(int j=i;j<stones.length && j<k+i;j++) {
        		if(stones[j]>max) {
        			max = stones[j];
        			idx = j;
        		}
        	}
        	
        	//System.out.println("max:"+max);
        	if(max<min) {
        		min = max;
        	}
        	
        }
        //System.out.println(min);
        answer = min;
        
        return answer;
    }
}
