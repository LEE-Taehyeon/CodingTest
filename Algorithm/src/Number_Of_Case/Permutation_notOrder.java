package Number_Of_Case;

import java.util.Arrays;

//순열 - 중복X(abc, acb, bac, bca, ...,) : 단, 사전순으로 출력이 되지 않음.
public class Permutation_notOrder {
	static int[] sel;
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		
		for(int i=1;i<=3;i++) {//nPr -> r이 2에 해당
			sel = new int[i];
			//permutation(arr, 0);// nPr - 중복X
			overlapPermutation(arr, 0);// nPr - 중복O
		}
		
	}
	private static void permutation(int[] arr, int depth) {
		if(depth==sel.length) {
			for(int k=0;k<sel.length;k++) {
				sel[k] = arr[k];
			}
			
			System.out.println(Arrays.toString(sel)); // nPr
			//System.out.println(Arrays.toString(arr)); // nPn
			return;
		}
		
		
		for(int i=depth;i<arr.length;i++) {
			swap(arr, depth, i);
			permutation(arr, depth+1);
			swap(arr, depth, i);
		}

	}
	private static void swap(int[] arr, int depth, int i) {
		int temp = arr[depth];
		arr[depth] = arr[i];
		arr[i] = temp;
		
	}
	
	private static void overlapPermutation(int[] arr, int depth) {
		if(depth==sel.length) {
			System.out.println(Arrays.toString(sel)); // nPr 중복O
			return;
		}
		
		for(int i=0;i<arr.length;i++) {
			sel[depth] = arr[i];
			overlapPermutation(arr, depth+1);
		}
	}
}
