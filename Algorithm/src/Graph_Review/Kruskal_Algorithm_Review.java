package Graph_Review;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Kruskal_Algorithm_Review {
	public static void main(String[] args) {
		int[] arr = new int[8];
		
		for(int i=0;i<arr.length;i++) {
			arr[i] = i;
		}
		
		List<Node> list = new LinkedList<Node>();
		list.add(new Node(1, 2, 67));
		list.add(new Node(1, 4, 28));
		list.add(new Node(1, 5, 17));
		list.add(new Node(1, 6, 22));
		list.add(new Node(2, 4, 99));
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
				if(o1.getDistance()==o2.getDistance()) {
					return 0;
				}else {
					if(o1.getDistance()>o2.getDistance()) {
						return 1;
					}else {
						return -1;
						
					}
				}
			}
		});
		
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).getDistance());
		}
		
		int sum = 0;
		for(int i=0;i<list.size();i++) {
			if(findParent(arr, list.get(i).getX(), list.get(i).getY())!=1) {
				System.out.print(list.get(i).getDistance()+" ");
				unionParentMerge(arr, list.get(i).getX(), list.get(i).getY());//같은 부모의 idx값을 모두 같게 만들기.
				sum += list.get(i).getDistance();
			}
		}
		
		System.out.println(sum);

	}

	private static void unionParentMerge(int[] arr, int node1, int node2) {
		int before = arr[arr[node1]];
		int after = arr[arr[node2]];
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==before) {
				arr[i] = after;
			}
		}
	}
	
	/*
	private static void unionParent(int[] arr, int i, int j) {
		i = getParent(arr, i);
		j = getParent(arr, j);
		if(i<j) {
			arr[j] = i;
		}else {
			arr[i] = j;
		}
	}
	*/

	private static int findParent(int[] arr, int i, int j) {
		i = getParent(arr, i);
		j = getParent(arr, j);
		if(i==j) {
			return 1;
		}else {
			return 0;
		}
	}

	private static int getParent(int[] arr, int i) {
		if(arr[i]==i) {
			return i;
		}else {
			return arr[i]=getParent(arr, arr[i]);
		}
	}
}
class Node{
	public int x;
	public int y;
	public int distance;
	
	
	public Node(int x, int y, int distance) {
		this.x = x;
		this.y = y;
		this.distance = distance;
	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public int getDistance() {
		return distance;
	}


	public void setDistance(int distance) {
		this.distance = distance;
	}
	
}