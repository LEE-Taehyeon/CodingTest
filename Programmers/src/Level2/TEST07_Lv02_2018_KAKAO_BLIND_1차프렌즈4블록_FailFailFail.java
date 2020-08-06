package Level2;

public class TEST07_Lv02_2018_KAKAO_BLIND_1차프렌즈4블록_FailFailFail {
	static int[] dx = { 0, 0, 1, 1 };
	static int[] dy = { 0, 1, 0, 1 };
	static char[][] map;
	static boolean[][] visit;

	public static void main(String[] args) {
		int m = 4;
		int n = 5;
		String[] board = { "CCBDE", "AAADE", "AAABF", "CCBBF" };
		// String[] board = { "TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"
		// };
		int result = solution(m, n, board);

		System.out.println(result);

	}

	public static int solution(int m, int n, String[] board) {
		int answer = 0;
		visit = new boolean[m][n];
		map = new char[m][n];

		for (int i = 0; i < board.length; i++) {
			map[i] = board[i].toCharArray();//board의 문자열 배열을 모두 char타입 2차원배열로 변경
		}

		while (true) {
			int cnt = 0;
			for (int i = 0; i < m - 1; i++) {
				for (int j = 0; j < n - 1; j++) {
					if (map[i][j] != '.') {//해당 지점의 블록이 '.' 아니면 탐색
						boolean flag = true;

						for (int k = 0; k < 4; k++) {//해당지점에서 3가지 방향(사실상 4가지 방향_자기자신도 포함)을 모두 탐색
							int nx = i + dx[k];
							int ny = j + dy[k];
							if (map[i][j] != map[nx][ny]) {//하나라도 일치하지 않은 것이 있다면 flag를 false로 바꾼다.
								flag = false;
								break;
							}
						}
						if (!flag) {//만약 flag가 false면(3가지 방향에서 하나라도 일치하지 않으면) 다음 블록으로 넘어가기 위한 작업
							continue;
						}

						for (int k = 0; k < 4; k++) {
							int nx = i + dx[k];
							int ny = j + dy[k];
							if (!visit[nx][ny]) {//해당지점 기준 (자기자신을 포함한)4가지 블록 중 방문하지 않은 곳만 카운팅
								cnt++;
								visit[nx][ny] = true;
							}
						}
					}
				}

			}//해당 블록을 처음부터 끝까지 한 번 전체탐색

			/*
			 * for (int i = 0; i < m; i++) { for (int j = 0; j < n; j++) {
			 * System.out.print(map[i][j] + " "); } System.out.println(); }
			 */

			/*
			 * for (int i = 0; i < m; i++) { for (int j = 0; j < n; j++) {
			 * System.out.print(visit[i][j] + " "); } System.out.println(); }
			 */

			for (int i = 0; i < m; i++) {//방문한 곳을 '.'로 바꾸기 위한 작업  - 블록 없애기
				for (int j = 0; j < n; j++) {
					if (visit[i][j]) {
						map[i][j] = '.';
					}
				}
			}

			answer += cnt;
			if (cnt == 0) {//만약 전체 탐색을 했는데 4블록이 없는 경우 while문 탈출
				break;
			}
			bfsDownBlock(m, n);//블록 내리기
		}

		return answer;
	}

	private static void bfsDownBlock(int m, int n) {
		for (int i = m - 2; i >= 0; i--) {//밑에서 부터 블록을 탐색
			// 밑에서 부터 탐색하는 이유 : 
			// T
			// F
			// .
			// .  같은 경우 위에서 부터 탐색하면 내가 생각한 코드로는 블록을 내리지 못한다.
			for (int j = 0; j < n; j++) {
				int k = 1;
				int l = 0;
				//i+l - 해당지점
				//i+k - 해당지점의 밑지점
				//해당지점에 블록이 존재하고 그 밑의 지점에 블록이 존재하지 않으면 즉, 블록을 내려야 하는 상황
				//둘의 위치를 변경
				//i+k<m : 범위를 넘어서지 않기위한 작업
				while (i + k < m && map[i + l][j] != '.' && map[i + k][j] == '.') {
					map[i + k][j] = map[i + l][j];
					map[i + l][j] = '.';
					boolean temp = visit[i + k][j];
					visit[i + k][j] = visit[i + l][j];
					visit[i + l][j] = temp;//둘의 방문여부도 변경
					k++;
					l++;
				}
			}
		}
	}

}
