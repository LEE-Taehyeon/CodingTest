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
		dijkstra(0);//1번 노드(index:0)에서 시작하여 각 노드로 가는 최단경로 찾기
		
		for(int i:distance) {
			System.out.print(i+" ");
		}
		
	}
	
	private static void dijkstra(int start) {
		for(int i=0;i<num;i++) {//최초 arr의 값을 distance에 넣어준다
			distance[i] = arr[start][i];
		}
		
		visit[start] = true;//시작하는 노드를 true로 갱신
		
		for(int i=0;i<num;i++) {
			int current = getSmallIndex();
			visit[current] = true;
			
			for(int j=0;j<num;j++) {
				if(!visit[j]) {
					if(distance[current] + arr[current][j] < distance[j]) {//distance[current] : 시작노드(1번노드)에서 current노드로 가는 direct비용
																		   //arr[current][j] : current노드에서 j노드로 가는 direct비용
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
