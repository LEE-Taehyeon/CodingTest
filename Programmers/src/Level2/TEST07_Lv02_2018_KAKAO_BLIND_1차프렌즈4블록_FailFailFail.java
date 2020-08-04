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
		//String[] board = { "TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ" };
		int result = solution(m, n, board);

		System.out.println(result);

	}

	public static int solution(int m, int n, String[] board) {
		int answer = 0;
		visit = new boolean[m][n];
		map = new char[m][n];

		for (int i = 0; i < board.length; i++) {
			map[i] = board[i].toCharArray();
		}

		while (true) {
			int cnt = 0;
			for (int i = 0; i < m - 1; i++) {
				for (int j = 0; j < n - 1; j++) {
					if (!visit[i][j] || map[i][j] != '.') {
						boolean flag = true;

						for (int k = 0; k < 4; k++) {
							int nx = i + dx[k];
							int ny = j + dy[k];
							if (map[i][j] != map[nx][ny]) {
								flag = false;
								break;
							}
						}
						if (!flag) {
							continue;
						}

						for (int k = 0; k < 4; k++) {
							int nx = i + dx[k];
							int ny = j + dy[k];
							if (!visit[nx][ny]) {
								cnt++;
								visit[nx][ny] = true;
							}
						}
					}
				}
				
			}
			
			/*
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
			*/
			
			/*
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(visit[i][j] + " ");
				}
				System.out.println();
			}
			*/

			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (visit[i][j]) {
						map[i][j] = '.';
					}
				}
			}
			
			answer += cnt;
			if (cnt == 0) {
				break;
			}
			bfsDownBlock(m, n);
		}

		return answer;
	}

	private static void bfsDownBlock(int m, int n) {
		for(int i=m-2;i>=0;i--) {
			for(int j=0;j<n;j++) {
				int k = 1;
				int l = 0;
				while(i+k<m && map[i+l][j]!='.' && map[i+k][j]=='.') {
					map[i+k][j] = map[i+l][j];
					map[i+l][j] = '.';
					boolean temp = visit[i+k][j];
					visit[i+k][j] = visit[i+l][j];
					visit[i+l][j] = temp;
					k++;
					l++;
				}
			}
		}
	}

}
