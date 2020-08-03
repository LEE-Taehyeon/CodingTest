package Graph;

import java.util.LinkedList;

//0번 노드 없음. -> 0번 노드 하고싶으면 크기를 바꿔야함
//DFS 구현_ArrayList이용
public class DFS_LinkedList {
	public static void main(String[] args) {
		int size = 6;
		ListDFS list_graph = new ListDFS(size);
		

		list_graph.putDouble(1, 2);
		list_graph.putDouble(1, 3);
		list_graph.putDouble(2, 3);
		list_graph.putDouble(2, 4);
		list_graph.putDouble(3, 4);
		list_graph.putDouble(3, 5);
		list_graph.putDouble(4, 5);
		list_graph.putDouble(4, 6);

		/*
		list_graph.putDouble(1, 2);
		list_graph.putDouble(1, 3);
		list_graph.putDouble(1, 4);
		list_graph.putDouble(2, 3);
		*/
		
		System.out.println(list_graph.getNode(5));
		list_graph.printGraph();
		
		list_graph.dfs(5);
		
	}
}

class ListDFS{
	private LinkedList<LinkedList<Integer>> listGraph;
	private boolean[] visit;

	public ListDFS(int size) {
		this.listGraph = new LinkedList<LinkedList<Integer>>();
		
		for(int i=0;i<=size;i++) {
			listGraph.add(new LinkedList<Integer>());
		}
		
		this.visit = new boolean[size+1];
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
	
	public void dfs(int x) {
		this.visit[x] = true;
		System.out.print(x+" ");
		
		for(int i:listGraph.get(x)) {
			if(!visit[i]) {
				dfs(i);
			}
		}
	}
	
}
