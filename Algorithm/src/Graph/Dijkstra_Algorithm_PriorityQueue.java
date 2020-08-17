package Graph;

import java.util.PriorityQueue;

//다익스트라 알고리즘(우선순위 큐 이용)
public class Dijkstra_Algorithm_PriorityQueue {
	static int[][] arr;
	static boolean[] visit;
	static int[] distance;
	static int num;
	static int max = 10000000;
	public static void main(String[] args) {
		arr = new int[6][6];
		visit = new boolean[6];
		distance = new int[6];
		
		
		arr = new int[][]{ { 0, 2, 5, 1, max, max },
						   { 2, 0, 3, 2, max, max },
						   { 5, 3, 0, 3, 1, 5 },
						   { 1, 2, 3, 0, 1, max },
						   { max, max, 1, 1, 0, 2 },
						   { max, max, 5, max, 2, 0 } };
		
		
		num = arr.length;
		
		for(int i=0;i<num;i++) {
			distance[i] = max;
		}
		
		dijkstra(0);
		
		for(int i:distance) {
			System.out.print(i+" ");
		}
		System.out.println();

	}

	public static void dijkstra(int start) {
		PriorityQueue<Node3> pq = new PriorityQueue<Node3>();
		distance[start] = 0;
		pq.offer(new Node3(start, 0));
		
		while(!pq.isEmpty()) {
			int current = pq.peek().index;
			int cost = pq.peek().distance;
			
			pq.poll();
			
			if(cost>distance[current]) {
				continue;
			}
			
			for(int i=0;i<arr.length;i++) {
				if(arr[current][i]!=0 && distance[i] > distance[current] + arr[current][i]) {//distance[i] : 한 번에 갈 때의 비용
					distance[i] = distance[current] + arr[current][i];
					pq.offer(new Node3(i, distance[i]));
				}
			}
			
			for(int i:distance) {
				System.out.print(i+" ");
			}
			System.out.println();
			
		}
	}
}

class Node3 implements Comparable<Node3>{
	public int index;
	public int distance;
	
	public Node3(int index, int distance) {
		this.index = index;
		this.distance = distance;
	}
	
	@Override
	public int compareTo(Node3 o) {//Node3으로 우선순위 큐를 만들었기 때문에 compareTo메소드를 재정의 해야한다.++
		return this.distance - o.distance;
	}
	
}
