package Graph;

//이진트리 탐색(BinaryTree Traversal) - 전위, 중위, 후위
//           (1)
//    (2)          (3)
// (4)  (5)      ()   (7)
//() ()()(10)   ()()(13)()    
//
//preOrder(Root, Left, Right) - 1 2 4 5 10 3 7 13 
//inOrder(Left, Root, Right) - 4 2 5 10 1 3 13 7 
//postOrder(Left, Right, Root) - 4 10 5 2 13 7 3 1 
public class BinaryTree_Traversal {
	public static void main(String[] args) {
		Tree t = new Tree();
		Node1 n10 = t.makeNode1(null, 10, null);
		Node1 n13 = t.makeNode1(null, 13, null);
		Node1 n4 = t.makeNode1(null, 4, null);	
		Node1 n5 = t.makeNode1(null, 5, n10);
		Node1 n7 = t.makeNode1(n13, 7, null);
		Node1 n2 = t.makeNode1(n4, 2, n5);
		Node1 n3 = t.makeNode1(null, 3, n7);
		Node1 n1 = t.makeNode1(n2, 1, n3);

		t.setRoot(n1);

		t.preOrder(t.getRoot());
		System.out.println();
		t.inOrder(t.getRoot());
		System.out.println();

		// 같다
		t.postOrder(t.getRoot());
		System.out.println();
		t.postOrder(n1);
	}
}

class Node1 {
	public int data;
	public Node1 left;
	public Node1 right;
}

class Tree {
	public Node1 root;

	public Node1 getRoot() {
		return root;
	}

	public void setRoot(Node1 root) {
		this.root = root;
	}

	public Node1 makeNode1(Node1 left, int data, Node1 right) {
		Node1 Node1 = new Node1();
		Node1.data = data;
		Node1.left = left;
		Node1.right = right;
		return Node1;
	}

	public void preOrder(Node1 Node1) {
		if (Node1 != null) {
			System.out.print(Node1.data + " ");
			preOrder(Node1.left);
			preOrder(Node1.right);
		}
	}

	public void inOrder(Node1 Node1) {
		if (Node1 != null) {
			inOrder(Node1.left);
			System.out.print(Node1.data + " ");
			inOrder(Node1.right);
		}
	}

	public void postOrder(Node1 Node1) {
		if (Node1 != null) {
			postOrder(Node1.left);
			postOrder(Node1.right);
			System.out.print(Node1.data + " ");
		}
	}
}