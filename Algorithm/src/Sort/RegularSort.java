package Sort;

//알고리즘 - 일반적인 정렬
public class RegularSort {
	public static void main(String[] args) {
		int[] arr = { 5, 1, 7, 10, 6, 9, 2 , 4, 3, 8 };
		int temp = 0;//정렬을 위한 변수, 임시 저장소

		for(int i=1;i<arr.length;i++) {
			for(int j=0;j<i;j++) {
				if(arr[i]<arr[j]) {
					temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
		
		for(int i:arr) {
			System.out.println(i);
		}
	}

}
