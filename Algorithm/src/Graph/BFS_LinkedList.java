package Graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

//0번 노드 없음. -> 0번 노드 하고싶으면 크기를 바꿔야함
//BFS 구현_ArrayList이용
public class BFS_LinkedList {
	public static void main(String[] args) {
		int size = 6;
		ListBFS list_graph = new ListBFS(size);
		

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

		list_graph.bfs(3);
	}
}

class ListBFS{
	private LinkedList<LinkedList<Integer>> listGraph;
	private int n;

	public ListBFS(int size) {
		this.n = size;
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
	
	public void bfs(int s) {
		boolean[] visit = new boolean[n+1];//해당 노드에 방문했다는 것(방문하면 true)을 인덱스로 구분짓기 위함
		Queue<Integer> queue = new LinkedList<Integer>();
		
		visit[s] = true;
		queue.offer(s);
		
		while(!queue.isEmpty()) {
			s = queue.poll();
			System.out.print(s+" ");

			Iterator<Integer> iter = listGraph.get(s).listIterator();
			while(iter.hasNext()) {
				int k = iter.next();
				
				if(!visit[k]) {
					visit[k] = true;
					queue.offer(k);
				}
			}
			
		}

	}	
}
