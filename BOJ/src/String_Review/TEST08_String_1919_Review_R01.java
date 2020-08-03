package String_Review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준(1919)_애너그램 만들기
public class TEST08_String_1919_Review_R01 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStrA = br.readLine();
		String inputStrB = br.readLine();
		
		int[] arr = new int[26];//알파벳을 저장하기 위한 배열
		
		for(int i=0;i<inputStrA.length();i++) {
			arr[inputStrA.charAt(i)-'a']++;
		}
		for(int i=0;i<inputStrB.length();i++) {
			arr[inputStrB.charAt(i)-'a']--;
		}
		int sum = 0;
		for(int i=0;i<arr.length;i++) {
			sum += Math.abs(arr[i]);
		}
		System.out.println(sum);
	}
}
