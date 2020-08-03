package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준(3187)_양치기 꿍
public class TEST02_BFS_3187 {
	static int r;
	static int c;
	static char[][] map;
	static boolean[][] visit;
	static int[] dx= {1, 0, -1, 0};
	static int[] dy= {0, 1, 0, -1};
	static int sheep;
	static int wolf;
	static Queue<Node> queue = new LinkedList<Node>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		r = Integer.valueOf(stk.nextToken());
		c = Integer.valueOf(stk.nextToken());
		
		map = new char[r][c];
		visit= new boolean[r][c];
		
		for(int i=0;i<r;i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(map[i][j]=='#' || visit[i][j]) {
					continue;
				}else {
					bfs(i, j);
				}
			}
		}
		System.out.println(sheep+" "+wolf);
		

	}

	private static void bfs(int x, int y) {
		int v = 0;
		int k = 0;
		
		visit[x][y] = true;
		queue.add(new Node(x, y));
		
		while(!queue.isEmpty()) {
			Node cur =  queue.poll();
			
			if(map[cur.x][cur.y]=='v') {
				v++;
			}
			if(map[cur.x][cur.y]=='k') {
				k++;
			}
			
			for(int i=0;i<4;i++) {
				int nx = cur.x+dx[i];
				int ny = cur.y+dy[i];
				
				if(!isRange(nx, ny) || visit[nx][ny] || map[nx][ny]=='#') {
					continue;
				}else {
					visit[nx][ny] = true;
					queue.add(new Node(nx, ny));
				}
			}
			
		}
		if(v>=k) {
			wolf += v;
		}else {
			sheep += k;
		}
		
	}

	private static boolean isRange(int x, int y) {
		if(x<0 || y<0 || x>=r || y>=c) {
			return false;
		}else {
			return true;
		}
		
	}

}
class Node{
	int x;
	int y;
	
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}