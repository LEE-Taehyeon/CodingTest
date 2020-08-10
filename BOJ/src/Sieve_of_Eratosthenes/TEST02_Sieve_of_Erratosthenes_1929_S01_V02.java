package Sieve_of_Eratosthenes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//백준(1929)
public class TEST02_Sieve_of_Erratosthenes_1929_S01_V02 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int m = Integer.valueOf(stk.nextToken());
		int n = Integer.valueOf(stk.nextToken());
		int[] arr = new int[n + 1];

		for (int i = 2; i <= n; i++) {
			arr[i] = i;
		}

		for (int i = 2; i <= n; i++) {
			if (arr[i] == 0) {
				continue;
			}
			for (int j = i + i; j <= n; j += i) {
				arr[j] = 0;
			}
		}

		for (int i = m; i <= n; i++) {
			if (arr[i] != 0) {
				bw.write(arr[i]+ "\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
		
	}
}
