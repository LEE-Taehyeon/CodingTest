package Sort_Review;

//정렬 - 힙정렬
public class HeapSort_Review {
	public static void main(String[] args) {
		int[] arr = { 5, 1, 7, 10, 6, 9, 2 , 4, 3, 8 };
		int temp = 0;
		
		for(int i=1;i<arr.length;i++) {
			int c = i;
			do {
				int root = (c-1)/2;
				if(arr[root]<arr[c]) {
					temp = arr[root];
					arr[root] = arr[c];
					arr[c] = temp;
				}
				c = root;
			}while(c!=0);
		}
		
		for(int i=arr.length-1;i>=0;i--) {
			temp = arr[i];
			arr[i] = arr[0];
			arr[0] = temp;
			
			int c = 1;
			int root = 0;
			do {
				c = (2*root)+1;
				if(c<i-1 && arr[c]<arr[c+1]) {
					c++;
				}
				if(c<i && arr[root]<arr[c]) {
					temp = arr[c];
					arr[c] = arr[root];
					arr[root] = temp;
				}
				root = c;
			}while(c<i);
		}
		
		for(int i:arr) {
			System.out.print(i+" ");
		}

	}

}
