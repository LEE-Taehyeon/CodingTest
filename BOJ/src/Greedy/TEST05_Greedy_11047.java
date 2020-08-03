package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 알고리즘(동전 0)
public class TEST05_Greedy_11047 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int moneyNum = Integer.valueOf(st.nextToken());//돈 종류의 갯수
		int money = Integer.valueOf(st.nextToken());//돈의 크기(?)(얼마인지)
		int[] arrMoney = new int[moneyNum];
		
		for(int i=0;i<arrMoney.length;i++) {
			arrMoney[i] = Integer.valueOf(br.readLine());
		}
		
		int answer = solution(arrMoney, money);
		System.out.println(answer);
		
	}

	private static int solution(int[] arrMoney, int money) {
		int result = 0;
		
		for(int i=arrMoney.length-1;i>=0;i--) {
			while(arrMoney[i]<=money) {
				double share = money/arrMoney[i];
				money -= share*arrMoney[i];
				result += share;
			}
		}
		return result;
	}



}
