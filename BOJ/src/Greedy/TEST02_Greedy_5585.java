package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 알고리즘(거스름돈)
public class TEST02_Greedy_5585 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int price = 1000-Integer.valueOf(br.readLine());
		int[] money = {500,100,50,10,5,1};//거스름돈의 단위가 정해져 있으므로 배열에 넣는다.
		
		int answer = solution(price, money);
		System.out.println(answer);

	}

	private static int solution(int price, int[] money) {
		int result = 0;
		int num = 0;
		
		while(price>0) {
			int share = price / money[num];//돈을 money의 원소하나씩 차례대로 나눈후
			price -= share*money[num];//해당값(몫*돈 단위)을 뺀다.
			result += share;//result에 몫을 더한다.
			num++;
		}
		return result;
	}

}
