package Graph;

//다익스트라(Dijkstra) 알고리즘
public class Dijkstra_Algorithm {
	static int[][] arr;
	static boolean[] visit;
	static int[] distance;
	static int num;
	static int max = 10000000;
	public static void main(String[] args) {
		visit = new boolean[6];
		distance = new int[6];
		
		arr = new int[][]{ { 0, 2, 5, 1, max, max },
						   { 2, 0, 3, 2, max, max },
						   { 5, 3, 0, 3, 1, 5 },
						   { 1, 2, 3, 0, 1, max },
						   { max, max, 1, 1, 0, 2 },
						   { max, max, 5, max, 2, 0 } };
		
		
		num = arr.length;
		dijkstra(0);
		
		for(int i:distance) {
			System.out.print(i+" ");
		}
		
	}
	
	private static void dijkstra(int start) {
		for(int i=0;i<num;i++) {
			distance[i] = arr[start][i];
		}
		
		visit[start] = true;
		
		for(int i=0;i<num;i++) {
			int current = getSmallIndex();
			visit[current] = true;
			
			for(int j=0;j<num;j++) {
				if(!visit[j]) {
					if(distance[current] + arr[current][j] < distance[j]) {
						distance[j] = distance[current] + arr[current][j];
					}
				}
			}
		}
		
	}
	
	private static int getSmallIndex() {
		int min = max;
		int minIndex = 0;
		
		for(int i=0;i<num;i++) {
			if(distance[i]<min && !visit[i]) {
				min = distance[i];
				minIndex = i;
			}
		}
		return minIndex;
	}

}
