package Sort;

public class QuickSort {
	public static void main(String[] args) {
		int[] arr = { 11, 2,1,9,4,3,6,5,7,10,8 };
		//int[] arr = { 11, 22,12,15,13,14 };
		int start = 0;
		int end = arr.length-1;
		quick_sort(arr, start, end);
		
		for(int i:arr) {
			System.out.println(i);
		}

	}

	private static void quick_sort(int[] arr, int start, int end) {
		int pivot = start;
		int i = start + 1;
		int j = end;
		int temp = 0;
		
		if(start>=end) {//정렬하려는 배열의 원소크기가 1인 경우
			return;
		}
		while(i<=j) {
			while(i<end && arr[i]<arr[pivot]) {//피벗보다 큰 값을 선택하기 위한
				i++;
			}
			while(arr[j]>=arr[pivot] && j>start) {//피벗보다 작은 값을 선택하기 위한
				j--;
			}
			if(i>j) {//엇갈렸다면
				temp = arr[j];
				arr[j] = arr[start];//i와 바꾸는 것이 아니라 start와 바꾸기 때문에 if(i>arr.legth){i=start}문 없어도 됨
				arr[start] = temp;
			}else {
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		quick_sort(arr, start, j-1);
		quick_sort(arr, j+1, end);
	}
}
