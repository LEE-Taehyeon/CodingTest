package Level2;

import java.util.HashMap;
import java.util.Map;

//프로그래머스(Lv2)_소수찾기
public class TEST38_Lv2_소수찾기 {
	static String[] SEL;
	static int MINORITY = 0;
	static Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	public static void main(String[] args) {
		String numbers = "0117";
		int result = solution(numbers);
		System.out.println(result);

	}
	public static int solution(String numbers) {
        int answer = 0;
        String[] arr = numbers.split("");
        for(int i=1;i<=arr.length;i++) {
        	SEL = new String[i];
        	permutation(arr, 0);
        }
        answer = MINORITY;
        System.out.println(map);
        return answer;
    }
	private static void permutation(String[] arr, int depth) {
		if(depth==SEL.length) {
			for(int i=0;i<SEL.length;i++) {
				SEL[i] = arr[i];
			}
			findMinority(SEL);
			return;
		}
		
		for(int i=depth;i<arr.length;i++) {
			swap(arr, depth, i);
			permutation(arr, depth+1);
			swap(arr, depth, i);
		}
		
	}
	
	private static void findMinority(String[] sel) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<sel.length;i++) {
			sb.append(sel[i]);
		}
		
		int num = Integer.valueOf(sb.toString());
		
		if(map.containsKey(num)) {
			return;
		}else {
			map.put(num, 1);
			MINORITY++;
			
			if(num==1 || num==0) {
				MINORITY--;
				return;
			}
			
			for(int i=2;i<num;i++) {
				if(num%i==0) {
					MINORITY--;
					break;
				}
			}
			System.out.println("num:"+num);
		}
		
	}
	
	private static void swap(String[] arr, int depth, int i) {
		String temp = arr[depth];
		arr[depth] = arr[i];
		arr[i] = temp;
	}
}
