package Level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//백준(Lv2)_카카오프렌즈컬러링북
public class TEST39_Lv2_카카오프렌즈컬러링북 {
	static int r;
	static int c;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static boolean[][] visit;
	static Queue<Node> queue = new LinkedList<Node>();
	static List<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) {
		int m = 4;
		int n = 4;
		int[][] picture = { {0,0,0,0},
				{0,0,0,0},{0,0,0,0},{0,0,0,0}
		
		};
		int[] result = solution(m, n, picture);
		for (int i : result) {
			System.out.print(i + " ");
		}

	}

	public static int[] solution(int m, int n, int[][] picture) {
		r = m;
		c = n;
		visit = new boolean[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!visit[i][j] && picture[i][j] != 0) {
					bfs(i, j, picture);
				}
			}
		}

		int[] answer = new int[2];
		answer[0] = list.size();
		
		Collections.sort(list);
		if(list.size()==0) {
			answer[1] = 0;
		}else {
			answer[1] = list.get(list.size() - 1);
		}
		
		return answer;

	}

	private static void bfs(int x, int y, int[][] picture) {
		visit[x][y] = true;
		queue.offer(new Node(x, y));
		int area = 1;

		while (!queue.isEmpty()) {
			Node cur = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (!isRange(nx, ny) || visit[nx][ny] || picture[nx][ny] != picture[x][y]) {
					continue;
				} else {
					visit[nx][ny] = true;
					queue.offer(new Node(nx, ny));
					area++;
				}
			}

		}
		list.add(area);

	}

	private static boolean isRange(int nx, int ny) {
		if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
			return false;
		} else {
			return true;
		}
	}
}

class Node {
	public int x;
	public int y;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
