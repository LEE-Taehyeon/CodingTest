package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//백준(10026)_적록색약
public class TEST04_BFS_10026 {
	static int r;
	static boolean[][] visit;
	static boolean[][] visit1;
	static char[][] map;
	static char currentColor;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int rgbCnt = 0;
	static int notRGBCnt = 0;
	static Queue<Node2> queue = new LinkedList<Node2>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		r = n;
		visit = new boolean[n][n];
		visit1 = new boolean[n][n];
		map = new char[n][n];
		
		for(int i=0;i<n;i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(visit[i][j]) {
					continue;
				}else {
					bfsRGB(i, j);
				}
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(visit1[i][j]) {
					continue;
				}else {
					bfsNotRGB(i, j);
				}
			}
		}
		
		
		System.out.println(rgbCnt+" "+notRGBCnt);
		
	}
	private static void bfsNotRGB(int x, int y) {
		visit1[x][y] = true;
		queue.offer(new Node2(x, y));
		currentColor = map[x][y];
		
		while(!queue.isEmpty()) {
			Node2 cur = queue.poll();
			
			for(int i=0;i<4;i++) {
				int nx = cur.x+dx[i];
				int ny = cur.y+dy[i];
				
				if(currentColor=='R' || currentColor=='G') {
					if(!isRange(nx, ny) || visit1[nx][ny] || (map[nx][ny]!='R' && map[nx][ny]!='G')) {
						continue;
					}else {
						visit1[nx][ny] = true;
						queue.offer(new Node2(nx, ny));
					}
				}else {
					if(!isRange(nx, ny) || visit1[nx][ny] || map[nx][ny]!='B') {
						continue;
					}else {
						visit1[nx][ny] = true;
						queue.offer(new Node2(nx, ny));
					}
				}
			}
			
		}
		notRGBCnt++;
		
		
	}
	private static void bfsRGB(int x, int y) {
		visit[x][y] = true;
		queue.offer(new Node2(x, y));
		currentColor = map[x][y];
		
		while(!queue.isEmpty()) {
			Node2 cur = queue.poll();
			
			for(int i=0;i<4;i++) {
				int nx = cur.x+dx[i];
				int ny = cur.y+dy[i];
				
				if(!isRange(nx, ny) || visit[nx][ny] || map[nx][ny]!=currentColor) {
					continue;
				}else {
					visit[nx][ny] = true;
					queue.offer(new Node2(nx, ny));
				}
			}
			
		}
		rgbCnt++;
		
	}
	private static boolean isRange(int nx, int ny) {
		if(nx<0 || ny<0 || nx>=r || ny>=r) {
			return false;
		}
		return true;
	}

}
class Node2{
	public int x;
	public int y;
	
	public Node2(int x, int y) {
		this.x = x;
		this.y = y;
	}	
}