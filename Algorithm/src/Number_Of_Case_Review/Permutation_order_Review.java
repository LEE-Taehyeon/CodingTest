package Number_Of_Case_Review;

import java.util.Arrays;

//순열 - 중복X(abc, acb, bac, bca, ...,) : 사전순으로 출력
public class Permutation_order_Review {
	static int[] sel;
	static boolean[] visit = new boolean[3];
	public static void main(String[] args) {
		int[] arr = {1,2,3};
		
		for(int i=1;i<=3;i++) {
			sel = new int[i];
			permutation(arr, 0);
		}
		
		
	}
	private static void permutation(int[] arr, int depth) {
		if(depth==sel.length) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		
		for(int i=0;i<arr.length;i++) {
			if(!visit[i]) {
				visit[i] = true;
				sel[depth] = arr[i];
				permutation(arr, depth+1);
				visit[i] = false;
			}
		}
		
	}

}

