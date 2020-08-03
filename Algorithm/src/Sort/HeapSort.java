package Sort;

//정렬 - 힙정렬
public class HeapSort {
	public static void main(String[] args) {
		int[] arr = { 5, 1, 7, 10, 6, 9, 2 , 4, 3, 8 };
		
		for(int i=1;i<arr.length;i++) {
			int c = i;
			do {
				int root = (c-1)/2;
				if(arr[root]<arr[c]) {
					int temp = arr[root];
					arr[root] = arr[c];
					arr[c] = temp;
				}
				c = root;
			}while(c!=0);
		}

		for(int i=arr.length-1;i>=0;i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			
			int root = 0;
			int c = 1;
			do {
				c = 2*root+1;//왼쪽 자식 노드
				if(c<i-1 && arr[c]<arr[c+1]) {//c<i-1이 있는 이유:바뀐 노드 값과는 비교 대상이 아니기 때문.
					c++;
				}
				if(c<i && arr[root]<arr[c]) {
					temp = arr[c];
					arr[c] = arr[root];
					arr[root] = temp;
					/*
					 *    4
					 *  9  10
					 *  일 때, 10은 이미 바꾼 것이어서 위치가 고정.
					 *  이때, 위의 if문에서는 9와 10을 비교하여 더 큰 값을 채택한 후 4와 바꾸는 작업을 하면 안되기 때문에
					 *  if 조건문에 c<i-1이 된다. c(=2*root+1)이 왼쪽 자식노드를 가리키기 때문에.
					 *  그러나 이 조건문에서는 4가 9보다는 작을 수 있기 때문에 바꿔줘야 한다.
					 *  따라서 c<i인 것이다.
					 */
				}
				root = c;
			}while(c<i);
		}
		
		for(int i:arr) {
			System.out.print(i+" ");
		}

	}

}
