package Graph;

//다익스트라(Dijkstra) 알고리즘
public class FloydWarshall_Algorithm {
	static int[][] arr;
	static int max = 10000000;
	public static void main(String[] args) {
		arr = new int[][]{ { 0, 2, 5, 1, max, max },
						   { 2, 0, 3, 2, max, max },
						   { 5, 3, 0, 3, 1, 5 },
						   { 1, 2, 3, 0, 1, max },
						   { max, max, 1, 1, 0, 2 },
						   { max, max, 5, max, 2, 0 } };
		floydWarshall();
		
		
	}
	private static void floydWarshall() {
		int[][] floydWarshallArr = new int[arr.length][arr.length];
		
		//배열 복사
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				floydWarshallArr[i][j] = arr[i][j];
			}
		}
		
		
		for(int k=0;k<floydWarshallArr.length;k++) {//k : 거쳐가는 노드
			for(int i=0;i<floydWarshallArr.length;i++) {// i : 출발 노드
				for(int j=0;j<floydWarshallArr[i].length;j++) {//j : 도착 노드
					if(floydWarshallArr[i][k] + floydWarshallArr[k][j] < floydWarshallArr[i][j]) {//i-k-j(i에서 k를 거쳐 j로 가는) 비용이 i-j(i에서j로 바로 가는)비용보다 작다면 
						floydWarshallArr[i][j] = floydWarshallArr[i][k] + floydWarshallArr[k][j]; //값을 갱신
					}
				}
			}
		}
		
		//출력
		for(int i=0;i<floydWarshallArr.length;i++) {
			for(int j=0;j<floydWarshallArr[i].length;j++) {
				System.out.print(floydWarshallArr[i][j]+" ");
			}
			System.out.println();
		}
		
	}
}
