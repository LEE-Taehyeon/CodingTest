package Graph;

import java.util.LinkedList;

//0번 노드 없음. -> 0번 노드 하고싶으면 크기를 바꿔야함
//그래프 알고리즘 구현_ArrayList이용
public class Graph_LinkedList {
	public static void main(String[] args) {
		int size = 6;
		ListGraph list_graph = new ListGraph(size);
		
		list_graph.putDouble(1, 2);
		list_graph.putDouble(1, 3);
		list_graph.putDouble(2, 3);
		list_graph.putDouble(2, 4);
		list_graph.putDouble(3, 4);
		list_graph.putDouble(3, 5);
		list_graph.putDouble(4, 5);
		list_graph.putDouble(4, 6);
		
		System.out.println(list_graph.getNode(5));
		list_graph.printGraph();
	}
}

class ListGraph{
	private LinkedList<LinkedList<Integer>> listGraph;

	public ListGraph(int size) {
		this.listGraph = new LinkedList<LinkedList<Integer>>();
		
		for(int i=0;i<=size;i++) {
			listGraph.add(new LinkedList<Integer>());
		}
	}
	
	public LinkedList<LinkedList<Integer>> getGraph(){
		return this.listGraph;
	}
	
	public LinkedList<Integer> getNode(int i){
		return this.listGraph.get(i);
	}
	
	public void putDouble(int x, int y) {
		listGraph.get(x).add(y);
		listGraph.get(y).add(x);
	}
	
	public void putSingle(int x, int y) {
		listGraph.get(x).add(y);
	}
	
	public void printGraph() {
		for(int i=1;i<listGraph.size();i++) {
			System.out.print("정점 "+i+" 의 인접리스트");
			
			for(int j=0;j<listGraph.get(i).size();j++) {
				System.out.print(" -> "+listGraph.get(i).get(j));
			}
			System.out.println();
		}
	}
	
}
