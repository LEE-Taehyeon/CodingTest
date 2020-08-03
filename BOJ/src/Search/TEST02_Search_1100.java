package Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준알고리즘(1100)_하얀 칸
public class TEST02_Search_1100 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strArr = new String[8];
		
		for(int i=0;i<strArr.length;i++) {
			strArr[i] = br.readLine();
		}
		
		int cnt = 0;
		
		for(int i=0;i<strArr.length;i++) {
			if(i%2==0) {
				for(int j=0;j<strArr[i].length();j++) {
					if(strArr[i].charAt(j)=='F' && j%2==0) {
						cnt++;
					}
				}
			}else {
				for(int j=0;j<strArr[i].length();j++) {
					if(strArr[i].charAt(j)=='F' && j%2==1) {
						cnt++;
					}
				}
			}
		}
		System.out.println(cnt);
	}
}
