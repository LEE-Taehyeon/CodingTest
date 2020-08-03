package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//백준(2583)_영역 구하기
public class TEST03_BFS_2583 {
	static int r;
	static int c;
	static boolean[][] visit;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static Queue<Node1> queue = new LinkedList<Node1>();
	static List<Integer> list = new ArrayList<Integer>();
	static int block;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		r = Integer.valueOf(stk.nextToken());
		c = Integer.valueOf(stk.nextToken());
		block = Integer.valueOf(stk.nextToken());
		
		visit = new boolean[r][c];
			
		for(int i=0;i<block;i++) {
			String location = br.readLine();
			block_area(location);
		}

		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(!visit[i][j]) {
					bfs(i, j);
				}
			}
		}
		
		System.out.println(list.size());
		Collections.sort(list);
		for(int i:list) {
			System.out.print(i+" ");
		}

	}
	private static void bfs(int x, int y) {
		visit[x][y] = true;
		queue.offer(new Node1(x, y));
		int area = 1;
		
		while(!queue.isEmpty()) {
			Node1 cur = queue.poll();
			for(int i=0;i<4;i++) {
				int nx = cur.x+dx[i];
				int ny = cur.y+dy[i];
				
				if(!isRange(nx, ny) || visit[nx][ny]) {
					continue;
				}else {
					visit[nx][ny] = true;
					queue.offer(new Node1(nx, ny));
					area++;
				}
			}
		}
		list.add(area);
		
		
	}
	private static boolean isRange(int nx, int ny) {
		if(nx<0 || nx>=r || ny<0 || ny>=c ) {
			return false;
		}else {
			return true;
		}
	}
	
	private static void block_area(String location) {
		StringTokenizer stk = new StringTokenizer(location);
		int xFront = Integer.valueOf(stk.nextToken());
		int yFront = Integer.valueOf(stk.nextToken());
		int xBack = Integer.valueOf(stk.nextToken());
		int yBack = Integer.valueOf(stk.nextToken());
		
		for(int j=r-yBack;j<r-yFront;j++) {
			for(int i=xFront;i<xBack;i++) {
				visit[j][i] = true;
			}
		}

	}

}
class Node1{
	public int x;
	public int y;
	
	public Node1(int x, int y) {
		this.x = x;
		this.y = y;
	}
}