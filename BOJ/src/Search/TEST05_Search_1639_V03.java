package Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준(1639)_행운의 티켓
public class TEST05_Search_1639_V03 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputStrArr = br.readLine().split("");
		int[] inputIntArr = new int[inputStrArr.length];
		
		for(int i=0;i<inputIntArr.length;i++) {
			inputIntArr[i] = Integer.valueOf(inputStrArr[i]);
		}
		
		int length = inputStrArr.length%2==0?inputStrArr.length:inputStrArr.length-1;
		
		int answer = 0;
		Label:for(int i=length;i>=2;i-=2) {
			int left = 0; int right = 0; int start = 0; int j = 0; int cnt = 0;
			while(i+j<=inputStrArr.length) {
				while(cnt<i) {
					if(cnt<i/2) {
						left+=inputIntArr[j++];
						cnt++;
					}else {
						right+=inputIntArr[j++];
						cnt++;
					}
				}
				if(left==right) {
					answer = i;
					break Label;
				}else {
					left = 0;
					right = 0;
					cnt = 0;
					j = ++start;
				}
			}
		}
		System.out.println(answer);
	}
}
