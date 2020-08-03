package Sort;

public class MergeSort {
	static int[] mergeArr = new int[10];//10은 arr의 크기
	public static void main(String[] args) {
		int[] arr = { 3,1,2};
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
			if(arr[i]<=arr[j]) {
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
				mergeArr[k]=arr[t];
				k++;
			}
		}else {
			for(int t=i;t<=middle;t++) {
				mergeArr[k]=arr[t];
				k++;
			}
		}
		
		for(int t=m;t<=n;t++) {
			arr[t] = mergeArr[t];
		}
		
	}
}
