package Level3;

//프로그래머스(자물쇠와 열쇠)  --  54.0(실패)-> ketRatation이란 변수를 새로 주기때문에 계속 한번만 회전하게 된다.
//                                    따라서 31번째 수정:key = keyRatate(key)로
public class TEST02_2020_KAKAO_BLIND_자물쇠와열쇠_S01_V02_FailFailFail {
	static int n;
	static int m;

	public static void main(String[] args) {
		int[][] key = { { 1, 0, 1, 0 },
						{ 0, 1, 1, 1 },
						{ 0, 0, 1, 0 },
						{ 0, 1, 0, 0 } };
		int[][] lock = { { 1, 1, 1, 1, 1 },
						 { 0, 1, 0, 1, 1 },
						 { 1, 0, 0, 0, 1 },
						 { 1, 1, 0, 1, 1 },
						 { 1, 0, 1, 1, 1 } };
		boolean result = solution(key, lock);
		System.out.println(result);

	}

	public static boolean solution(int[][] key, int[][] lock) {
		n = lock.length;
		m = key.length;
		for (int i = 0; i < 4; i++) {
			if(i!=0) {//최초 처음에는 회전안시키기 위함
				key = keyRotate(key);
			}
			
			for (int j = 0; j < n + (m - 1); j++) {
				for (int k = 0; k < n + (m - 1); k++) {
					if (unLock(key, lock, j, k)) {
						return true;
					}
				}
			}

		}
		return false;
	}

	private static boolean unLock(int[][] keyRotation, int[][] lock, int j, int k) {
		int[][] lockExpansion = new int[n + (m - 1) * 2][n + (m - 1) * 2];//lock배열 확장
		
		for (int x = m - 1; x < m + n - 1; x++) {
			for (int y = m - 1; y < m + n - 1; y++) {
				lockExpansion[x][y] = lock[x - (m - 1)][y - (m - 1)];//확장된 lock배열 가운데 lock배열 대입
			}
		}
		
		for (int x = 0; x < m; x++) {
			for (int y = 0; y < m; y++) {
				lockExpansion[x + j][y + k] += keyRotation[x][y];//key배열을 해당 시작위치에서부터 확장된 lock배열과 합
			}
		}

		

		/*
		for (int i = 0; i < lockExpansion.length; i++) {
			for (int s = 0; s < lockExpansion.length; s++) {
				System.out.print(lockExpansion[i][s] + " ");
			}
			System.out.println();
		}
		System.out.println("--------------------------------------");
		*/
		
		for (int x = m - 1; x < m + n - 1; x++) {
			for (int y = m - 1; y < m + n - 1; y++) {
				if (lockExpansion[x][y] != 1) {//확장된 lock배열의 가운데 lock배열이 위치한 모든원소 중 하나라도 1이 아니면 false리턴
					return false;
				}
			}
		}

		return true;//모든 원소가 1이면 true리턴
	}

	private static int[][] keyRotate(int[][] key) {//key배열 시계방향으로 90도 회전
		int m = key.length;
		int[][] temp = new int[m][m];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				temp[i][j] = key[m - 1 - j][i];
			}
		}
		return temp;
	}
}
