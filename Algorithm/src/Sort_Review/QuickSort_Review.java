package Sort_Review;

public class QuickSort_Review {
	public static void main(String[] args) {
		int[] arr = { 5, 1, 7, 10, 6, 9, 2 , 4, 3, 8 , 10};
		quick_sort(arr, 0, arr.length-1);

		
		for(int i:arr) {
			System.out.println(i);
		}

	}

	private static void quick_sort(int[] arr, int start, int end) {
		int pivot = start;
		int i = start + 1;
		int j = end;
		int temp = 0;
		
		if(start>=end) {
			return;
		}
		
		while(i<=j) {
			while(i<end && arr[pivot]>arr[i]) {
				i++;
			}
			while(arr[pivot]<=arr[j] && j>start) {
				j--;
			}
			if(i>j) {
				temp = arr[j];
				arr[j] = arr[pivot];
				arr[pivot] = temp;
			}else {
				temp = arr[j]; 
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		
		quick_sort(arr, start, j-1);
		quick_sort(arr, j+1, end);
		
	}
}
