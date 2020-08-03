package Level2;

import java.util.Arrays;

//프로그래머스(Lv2)_Summer/Winter coding(~2018):소수 만들기  -- 조합으로 풀어보기
public class TEST04_Lv2_Summer_Winter_Coding_소수만들기_S02 {
	static int cnt = 0;
	public static void main(String[] args) {
		int[] nums = { 1,2,7,6,4 };
		int result = solution(nums);
		System.out.println(result);

	}
	public static int solution(int[] nums) {
        int answer = 0;
        int[] sel = new int[3];
        combination(nums, sel, 0, 0);
        
        answer = cnt;

        return answer;
    }
	private static void combination(int[] nums, int[] sel, int i, int j) {
		if(j==sel.length) {
			//System.out.println(Arrays.toString(sel));
			int num = 0;
			for(int k=0;k<sel.length;k++) {
				num+=sel[k];
			}
			//System.out.println(num);
			if(isDecimalNum(num)) {
				cnt++;
			}
			return;
		}
		if(i==nums.length) {
			return;
		}
		
		sel[j] = nums[i];
		combination(nums, sel, i+1, j+1);
		combination(nums, sel, i+1, j);
		
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
