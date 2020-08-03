package Level2;

//프로그래머스(Lv2)_가장 큰 정삭각형 찾기 -> 처음에 BFS로 풀려고했는데 이 문제는 DP를 이용하여 풀어야 하는 문제였다.
public class TEST40_Lv2_가장큰정사각형찾기 {
	public static void main(String[] args) {
		int[][] board = { {0,1,1,1},
						  {1,1,1,1},
						  {1,1,1,1},
						  {0,0,1,0} };
		
		int result = solution(board);
		System.out.println(result);

	}
	
	public static int solution(int[][] board) {
		int answer = 1234;
		int left = 0;
		int up = 0;
		int leftAndUp = 0;
		
		for(int i=1;i<board.length;i++) {
			for(int j=1;j<board[i].length;j++) {
				if(board[i][j]==1) {
					left = board[i][j-1];
					up = board[i-1][j];
					leftAndUp = board[i-1][j-1];
					
					board[i][j] = Math.min(left, Math.min(up, leftAndUp))+1;
				}
			}
		}
		
		int max = 0;
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				if(max<board[i][j]) {
					max = board[i][j];
				}
			}
		}
		
		answer = max*max;

		return answer;
	}
}