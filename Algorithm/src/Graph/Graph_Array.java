package Graph;

//0번 노드 없음. -> 0번 노드 하고싶으면 크기를 바꿔야함
//그래프 알고리즘 구현_배열이용
public class Graph_Array {
	public static void main(String[] args) {
		int size = 6;
		ArrGraph arr_graph = new ArrGraph(size);
		
		arr_graph.putDouble(1, 2);
		arr_graph.putDouble(1, 3);
		arr_graph.putDouble(2, 3);
		arr_graph.putDouble(2, 4);
		arr_graph.putDouble(3, 4);
		arr_graph.putDouble(3, 5);
		arr_graph.putDouble(4, 5);
		arr_graph.putDouble(4, 6);
		
		arr_graph.getNode(5);
		arr_graph.printGraph();
	}
}

class ArrGraph{
	private int[][] arrGraph;

	public ArrGraph(int size) {
		this.arrGraph = new int[size][size];

	}
	
	public int[][] getGraph(){
		return this.arrGraph;
	}
	
	public void getNode(int i){
		for(int j=0;j<arrGraph[i-1].length;j++) {
			if(arrGraph[i-1][j]==1) {
				System.out.print((j+1)+" ");
			}
		}
		System.out.println();
	}

	
	public void putDouble(int x, int y) {
		arrGraph[x-1][y-1] = arrGraph[y-1][x-1] = 1;
	}
	
	public void putSingle(int x, int y) {
		arrGraph[x-1][y-1] = 1;
	}
	
	public void printGraph() {
		for(int i=0;i<arrGraph.length;i++) {			
			for(int j=0;j<arrGraph[i].length;j++) {
				System.out.print(arrGraph[i][j]+" ");
			}
			System.out.println();
		}
	}
	
}
