package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//백준 알고리즘(DNA)
public class TEST03_Greedy_5585_FailFailFail {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] dna = new int[2];//{입력DNA의 개수, 입력 DNA의 길이 변수}
		
		for(int i=0;i<st.countTokens();i++) {
			dna[i] = Integer.valueOf(st.nextToken());
		}

		List<String> list = new ArrayList<String>();
		for(int i=0;i<dna[0];i++) {
			String dnaName = br.readLine();
			list.add(dnaName);
		}
		
		int answer = solution(dna, list);
		System.out.println(answer);
	}

	private static int solution(int[] dna, List<String> list) {
		int result = 0;
		
		
		
		return result;
	}

}
