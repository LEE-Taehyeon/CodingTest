package Sort_Review;

//정렬 - 선택정렬
public class SelectSort_Review {
	public static void main(String[] args) {
		int[] arr = { 5, 1, 7, 10, 6, 9, 2, 4, 3, 8 };
		int temp = 0;
		int minIndex = 0;
		
		for(int i=0;i<arr.length;i++) {
			minIndex = i;
			for(int j=i;j<arr.length;j++) {
				if(arr[minIndex]>arr[j]) {
					minIndex = j;
				}
			}
			temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
		
		for(int i:arr) {
			System.out.println(i);
		}
	}

}
