package Graph_Review;

//0번 노드 없음. -> 0번 노드 하고싶으면 크기를 바꿔야함
//그래프 알고리즘 구현_배열 이용
public class Graph_Array_Review {
	public static void main(String[] args) {

		int size = 6;
		arrayGraph arr_graph = new arrayGraph(size);
		
		arr_graph.putDouble(1, 2);
		arr_graph.putDouble(1, 3);
		arr_graph.putDouble(2, 3);
		arr_graph.putDouble(2, 4);
		arr_graph.putDouble(3, 4);
		arr_graph.putDouble(3, 5);
		arr_graph.putDouble(4, 5);
		arr_graph.putDouble(4, 6);
		
		System.out.println(arr_graph.getArrayGraph());
		arr_graph.getNode(5);
		
		arr_graph.printGraph();

	}
}

class arrayGraph{
	public int[][] array_graph;

	public arrayGraph(int size) {
		this.array_graph = new int[size][size];
	}
	
	public int[][] getArrayGraph() {
		return array_graph;
	}
	
	public void getNode(int x) {
		for(int i=0;i<array_graph[x-1].length;i++) {
			if(array_graph[x-1][i]==1) {
				System.out.print(array_graph[x-1][i]+" ");
			}
		}
		System.out.println();
	}
	
	public void putDouble(int x, int y) {
		array_graph[x-1][y-1] = array_graph[y-1][x-1] = 1;
	}
	
	public void putSingle(int x, int y) {
		array_graph[x-1][y-1] = 1;
	}
	
	public void printGraph() {
		for(int i=0;i<array_graph.length;i++) {
			for(int j=0;j<array_graph[i].length;j++) {
				System.out.print(array_graph[i][j]+" ");
			}
			System.out.println();
		}
	}
}

