package Sort;

//정렬 - 버블정렬
public class BubbleSort {
	public static void main(String[] args) {
		int[] arr = { 5, 1, 7, 10, 6, 9, 2 , 4, 3, 8 };
		int temp = 0;//정렬을 위한 변수, 임시 저장소
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		for(int i:arr) {
			System.out.println(i);
		}

	}

}
