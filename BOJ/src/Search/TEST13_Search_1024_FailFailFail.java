package Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준(1024)_수열의 합 - 3 4 5 6 / 5 6 7 구분을 못하겠다.
public class TEST13_Search_1024_FailFailFail {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(stk.nextToken());
		int l = Integer.valueOf(stk.nextToken());
		boolean run = true;
		int start = 0;
		
		while(run) {
			start++;
			int end = start + (l-1);
			int length = l;
			while(true) {
				int plus = start+end;
				int sum = plus%2==0?(plus/2)*length:(plus/2)*length+length/2;
				//System.out.println("plus:"+plus+" sum:"+sum);
				if(sum==n) {
					if(end-start>100) {
						System.out.println(-1);
					}else {
						for(int i=start;i<=end;i++) {
							System.out.print(i+" ");
						}
					}
					//run = false;
					//break;
				}else if(sum>n) {
					//System.out.println(-1);
					break;
				}else if(start>n/l) {
					System.out.println(-1);
					run = false;
					break;
				}
				end++;
				length++;
			}
		}
		
		
	}

}
