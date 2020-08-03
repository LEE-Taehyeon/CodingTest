package Level2;

//프로그래머스(Lv2)_Summer/Winter coding(~2018):소수 만들기  -- 소수 판별하는 것 수정
public class TEST04_Lv2_Summer_Winter_Coding_소수만들기_S01_V02 {
	public static void main(String[] args) {
		int[] nums = { 1,2,7,6,4 };
		int result = solution(nums);
		System.out.println(result);

	}
	public static int solution(int[] nums) {
        int answer = 0;

        for(int i=0;i<nums.length-2;i++) {
        	for(int j=i+1;j<nums.length-1;j++) {
        		for(int k=j+1;k<nums.length;k++) {
        			int num = nums[i] + nums[j] + nums[k];
        			if(isDecimalNum(num)) {
        				answer++;
        			}
        		}
        	}
        }

        return answer;
    }
	private static boolean isDecimalNum(int num) {
		for(int i=2;i<num;i++) {
			if(num%i==0) {
				return false;
			}
		}
		return true;
	}
}
