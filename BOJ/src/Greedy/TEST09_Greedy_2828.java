package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준(2828)_사과 담기 게임
public class TEST09_Greedy_2828 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(stk.nextToken());//N칸의 수
		int m = Integer.valueOf(stk.nextToken());//바구니 M칸의 수
		int apples = Integer.valueOf(br.readLine());//떨어지는 사과 수
	
		int currentPosition = 1;//바구니 현재 위치
		int coverArea = currentPosition + (m - 1);//바구니의 현재위치에서 커버가능한 마지막 위치
		int moveCnt = 0;//사과를 담기위해 몇 번 이동했는지

		for (int i = 0; i < apples; i++) {
			int appleDrop = Integer.valueOf(br.readLine());//사과가 떨어지는 위치
			
			/*
			 * 사과가 바구니의 왼쪽 끝부분의 위치보다 앞쪽에 떨어진다면, 
			 * 예를 들어 사과는 1에 떨어지고 바구니의 왼쪽 끝부분 위치가 3이라면
			 */
			if (appleDrop < currentPosition) {
				int move = currentPosition - appleDrop;//이동해야하는 칸수는 바구니의 왼쪽 끝부분-사과가 떨어지는 위치
				currentPosition = appleDrop;
				coverArea = currentPosition + (m - 1);//이후 바구니의 왼쪽, 오른쪽 끝부분의 위치를 조정
				moveCnt += move;//총 이동횟수를 구하기 위해 매법 이동할 때마다 이동한 횟수를 더한다.
			} else if (coverArea < appleDrop) {
				/*
				 * 사과가 바구니의 오른쪽 끝부분의 위치보다 뒤쪽에 떨어진다면, 
				 * 예를 들어 사과는 5에 떨어지고 바구니의 오른쪽 끝부분 위치는 3이라면
				 * 위에서 말하는 바구니의 위
				 */
				int move = appleDrop - coverArea;//이동해야하는 칸수는 사과가 떨어지는 위치 - 바구니의 오른쪽 끝부분
				currentPosition += move;
				coverArea = appleDrop;//이후 바구니의 왼쪽, 오른쪽 끝부분의 위치를 조정
				moveCnt += move;//총 이동횟수를 구하기 위해 매법 이동할 때마다 이동한 횟수를 더한다.
			}
		}
		
		System.out.println(moveCnt);
	}

}
