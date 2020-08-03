package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준(2752)_세 수 정렬
public class TEST01_Sort_2752 {
	static int[] mergeArr = new int[3];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int[] arr = new int[3];
		int i=0;
		while(stk.hasMoreTokens()) {
			arr[i++] = Integer.valueOf(stk.nextToken());
		}
		
		//bubbleSort(arr);
		//selectSort(arr);
		//inserSort(arr);
		//quickSort(arr, 0, arr.length-1);
		merge(arr, 0, arr.length-1);

		for(int k:arr) {
			System.out.println(k);
		}
		
	}

	private static void merge(int[] arr, int i, int j) {
		if(i<j) {
			int middle = (i+j)/2;
			merge(arr, i, middle);
			merge(arr, middle+1, j);
			mergeSort(arr, i, middle, j);
		}
		
	}

	private static void mergeSort(int[] arr, int i, int middle, int j) {
		int m = i;
		int l = middle+1;
		int k = i;		
		
		while(m<=middle && l<=j) {
			if(arr[m]<=arr[l]) {
				mergeArr[k] = arr[m];
				m++;
			}else {
				mergeArr[k] = arr[l];
				l++;
			}
			k++;
		}
		if(m>middle) {
			for(int t=l;t<=j;t++) {
				mergeArr[k] = arr[t];
				k++;
			}
		}else {
			for(int t=m;t<=middle;t++) {
				mergeArr[k] = arr[t];
				k++;
			}
		}
		
		for(int t=i;t<=j;t++) {
			arr[t]=mergeArr[t];
		}
		
	}

	private static void quickSort(int[] arr, int start, int end) {
		int i = start+1;
		int pivot = start;
		int j = end;
		int temp;
		
		if(start>=end) {
			return;
		}
		
		while(i<=j) {
			while(i<arr.length && arr[pivot]>arr[i]) {
				i++;
			}
			while(arr[pivot]<=arr[j] && j>start) {
				j--;
			}
			if(i>j) {
				temp = arr[j];
				arr[j] = arr[start];
				arr[start] = temp;
			}else {
				temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		
		quickSort(arr, start, j-1);
		quickSort(arr, j+1, end);
		
		
	}

	private static void inserSort(int[] arr) {
		int temp = 0;
		int j = 0;
		for(int i=0;i<arr.length;i++) {
			temp = arr[i];
			for(j = i-1;j>=0 && temp<arr[j];j--) {
				arr[j+1] = arr[j];
			}
			arr[++j] = temp;
		}
		
	}

	private static void selectSort(int[] arr) {
		int temp = 0;
		int j = 0;
		int minIndex = 0;
		for(int i=0;i<arr.length;i++) {
			minIndex = i;
			for(j=i;j<arr.length;j++) {
				if(arr[minIndex]>arr[j]) {
					minIndex = j;
				}
			}
			temp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = temp;
		}
		
	}

	private static void bubbleSort(int[] arr) {
		int temp = 0;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length-1-i;j++) {
				if(arr[j]>arr[j+1]) {
					temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}

}
