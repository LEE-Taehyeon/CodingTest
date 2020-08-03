package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//백준(11651)_좌표 정렬하기2
public class TEST02_Sort_11651 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.valueOf(br.readLine());
		Cordinate[] cordinates = new Cordinate[testCase];
		
		for(int i=0;i<testCase;i++) {
			String[] inputStrArr = br.readLine().split(" ");
			cordinates[i] = new Cordinate(Integer.valueOf(inputStrArr[0]), Integer.valueOf(inputStrArr[1]));
		}
		Arrays.sort(cordinates);
		for(int i=0;i<testCase;i++) {
			System.out.println(cordinates[i].getX()+" "+cordinates[i].getY());
		}

	}

	public static class Cordinate implements Comparable<Cordinate> {
		private int x;
		private int y;
		
		public Cordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		@Override
		public int compareTo(Cordinate o) {
			return y>o.y?1:(y==o.y?(x>o.x?1:(x==o.x?0:-1)):-1);
		}
	}
}
