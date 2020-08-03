package Sort_Review;

public class MergeSort_Review {
	static int[] mergeArr = new int[10];
	public static void main(String[] args) {
		int[] arr = { 5, 1, 7, 10, 6, 9, 2, 4, 3, 8 };
		merge(arr, 0, arr.length-1);

		for (int i : arr) {
			System.out.println(i);
		}

	}

	private static void merge(int[] arr, int m, int n) {
		if(m<n) {
			int middle = (m+n)/2;
			merge(arr, m, middle);
			merge(arr, middle+1, n);
			mergeSort(arr, m, middle, n);
		}
	}

	private static void mergeSort(int[] arr, int m, int middle, int n) {
		int i = m;
		int j = middle + 1;
		int k = m;
		
		while(i<=middle && j<=n) {
			if(arr[i]<arr[j]) {
				mergeArr[k] = arr[i];
				i++;
			}else {
				mergeArr[k] = arr[j];
				j++;
			}
			k++;
		}
		
		if(i>middle) {
			for(int t=j;t<=n;t++) {
				mergeArr[k] = arr[t];
				k++;
			}
		}else {
			for(int t=i;t<=middle;t++) {
				mergeArr[k] = arr[t];
				k++;
			}
		}
		
		for(int t=m;t<=n;t++) {
			arr[t] = mergeArr[t];
		}
	}


}
