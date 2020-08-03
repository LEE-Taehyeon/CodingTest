package Graph_Review;

import java.util.LinkedList;

//0번 노드 없음. -> 0번 노드 하고싶으면 크기를 바꿔야함
//그래프 알고리즘 구현_ArrayList이용
public class Graph_LinkedList_Review {
	public static void main(String[] args) {	

		int size = 6;
		listGraph list_graph = new listGraph(size);
		
		list_graph.putDouble(1, 2);
		list_graph.putDouble(1, 3);
		list_graph.putDouble(2, 3);
		list_graph.putDouble(2, 4);
		list_graph.putDouble(3, 4);
		list_graph.putDouble(3, 5);
		list_graph.putDouble(4, 5);
		list_graph.putDouble(4, 6);
		
		System.out.println(list_graph.getListGraph());
		System.out.println(list_graph.getNode(5));
		
		list_graph.printGraph();

	}
}

class listGraph{
	public LinkedList<LinkedList<Integer>> list_graph;

	public listGraph(int size) {
		this.list_graph = new LinkedList<LinkedList<Integer>>();
		
		for(int i=0;i<=size;i++) {
			list_graph.add(new LinkedList<Integer>());
		}
	}
	
	public LinkedList<LinkedList<Integer>> getListGraph(){
		return list_graph;
	}
	
	public LinkedList<Integer> getNode(int x) {
		return list_graph.get(x);
	}
	
	public void putDouble(int x, int y) {
		list_graph.get(x).add(y);
		list_graph.get(y).add(x);
	}
	
	public void putSingle(int x, int y) {
		list_graph.get(x).add(y);
	}
	
	public void printGraph() {
		for(int i=1;i<list_graph.size();i++) {
			System.out.print("정점 "+i+"의 인접 리스트");
			
			for(int j=0;j<list_graph.get(i).size();j++) {
				System.out.print("-> "+list_graph.get(i).get(j));
			}
			System.out.println();
		}
	}	
}