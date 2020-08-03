package Sort_Review;

//정렬 - 삽입정렬
public class InsertSort_Review {
	public static void main(String[] args) {
		int[] arr = { 5, 1, 7, 10, 6, 9, 2 , 4, 3, 8 };
		int j=0;
		
		for(int i=1;i<arr.length;i++) {
			int temp = arr[i];
			for(j=i-1;j>=0 && temp<arr[j];j--) {
				arr[j+1] = arr[j];
			}
			arr[j+1] = temp;
		}
		
		for(int i:arr) {
			System.out.println(i);
		}
	}

}
