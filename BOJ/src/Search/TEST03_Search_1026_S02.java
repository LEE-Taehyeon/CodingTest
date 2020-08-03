package Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//백준(1026)_보물
public class TEST03_Search_1026_S02 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int arrSize = Integer.valueOf(br.readLine());
		int[] arrA = new int[arrSize];
		int[] arrB = new int[arrSize];
		StringTokenizer stkA = new StringTokenizer(br.readLine());
		StringTokenizer stkB = new StringTokenizer(br.readLine());

		for(int i=0;i<arrSize;i++) {
			arrA[i] = Integer.valueOf(stkA.nextToken());
			arrB[i] = Integer.valueOf(stkB.nextToken());
		}
		Arrays.sort(arrA);
		int sum = 0;
		int maxIndex = 0;
		
		for(int i=0;i<arrA.length;i++) {
			int max = -1;
			for(int j=0;j<arrB.length;j++) {
				if(max<arrB[j]) {
					max = arrB[j];
					maxIndex = j;
				}
			}
			arrB[maxIndex] = -1;
			sum+=arrA[i]*max;
		}
		System.out.println(sum);
	}
}
