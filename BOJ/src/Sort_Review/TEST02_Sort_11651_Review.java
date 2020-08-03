package Sort_Review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

//백준(11651)_좌표 정렬하기2
public class TEST02_Sort_11651_Review {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.valueOf(br.readLine());
		Cordinate[] cordinates = new Cordinate[testCase];
		
		for(int i=0;i<testCase;i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			cordinates[i] = new Cordinate(Integer.valueOf(stk.nextToken()), Integer.valueOf(stk.nextToken()));
		}
		
		Arrays.sort(cordinates, new Comparator<Cordinate>() {

			@Override
			public int compare(Cordinate o1, Cordinate o2) {
				if(o1.y!=o2.y) {
					return o1.y-o2.y;
				}else {
					return o1.x-o2.x;
				}
			}
		});
		for(Cordinate cor : cordinates) {
			System.out.println(cor.toString());
		}
		
	}

	public static class Cordinate {
		private int x;
		private int y;
		
		public Cordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return x+" "+y;
		}
	}
}
