package Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//백준알고리즘(1026)_보물
public class TEST03_Search_1026_S01 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num = br.readLine();
		String[] arrAStr = br.readLine().split(" ");
		String[] arrBStr = br.readLine().split(" ");
		int[] arrA = new int[Integer.valueOf(num)];
		int[] arrB = new int[Integer.valueOf(num)];
		
		for(int i=0;i<arrAStr.length;i++) {
			arrA[i] = Integer.valueOf(arrAStr[i]);
			arrB[i] = Integer.valueOf(arrBStr[i]);
		}
		Arrays.sort(arrA);
		Arrays.sort(arrB);//B배열의 위치를 변경하면 안됨.
		
		int sum = 0;
		for(int i=0;i<arrA.length;i++) {
			sum+=arrA[i]*arrB[arrB.length-1-i];
		}
		
		System.out.println(sum);
	}

}
