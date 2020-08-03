package Graph;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

//최소 비용 신장 트리_칼루스칼 알고르짐
public class Kruskal_Algorithm {
	public static void main(String[] args) {
		int[] arr = new int[8];
		
		for(int i=0;i<arr.length;i++) {
			arr[i] = i;
		}
		
		List<Node> list = new LinkedList<Node>();
		list.add(new Node(1, 7, 12));
		list.add(new Node(1, 4, 28));
		list.add(new Node(1, 2, 67));
		list.add(new Node(1, 5, 17));
		list.add(new Node(1, 6, 22));
		list.add(new Node(2, 4, 24));
		list.add(new Node(2, 5, 62));
		list.add(new Node(3, 5, 20));
		list.add(new Node(3, 6, 37));
		list.add(new Node(3, 7, 26));
		list.add(new Node(4, 7, 13));
		list.add(new Node(5, 6, 45));
		list.add(new Node(5, 7, 73));
		
		Collections.sort(list, new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				if(o1.getDistance()>o2.getDistance()) {
					return 1;
				}else if(o1.getDistance()<o2.getDistance()) {
					return -1;
				}else {
					return 0;
				}
			}
		});
		
		/*
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).getDistance());
		}
		*/
		
		int sum = 0;
		for(int i=0;i<list.size();i++) {
			if(findParent(arr, list.get(i).getNode1(), list.get(i).getNode2())!=1) {//같은 부모가 아니면 : 사이클을 막기위한 작업
				//System.out.println("list.get(i).getDistance(): "+list.get(i).getDistance());
				sum+=list.get(i).getDistance();//거리를 더해주고
				unionParent(arr, list.get(i).getNode1(), list.get(i).getNode2());//부모를 같게 만들어 준다.
			}
		}
		System.out.println(sum);

	}

	private static int findParent(int[] arr, int i, int j) {
		i = getParent(arr, i);
		j = getParent(arr, j);
		if(i==j) {
			return 1;
		}else {
			return 0;
		}
		
	}

	private static void unionParent(int[] arr, int i, int j) {
		i = getParent(arr, i);
		j = getParent(arr, j);
		if(i<j) {
			arr[j] = i;
		}else {
			arr[i] = j;
		}
		
	}

	private static int getParent(int[] arr, int i) {
		if(arr[i]==i) {
			return i;
		}else {
			return arr[i] = getParent(arr, arr[i]);
		}
	}
}

class Node{
	public int node1;
	public int node2;
	public int distance;
	
	public Node(int node1, int node2, int distance) {
		this.node1 = node1;
		this.node2 = node2;
		this.distance = distance;
	}

	public int getNode1() {
		return node1;
	}

	public void setNode1(int node1) {
		this.node1 = node1;
	}

	public int getNode2() {
		return node2;
	}


	public void setNode2(int node2) {
		this.node2 = node2;
	}


	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	
}
