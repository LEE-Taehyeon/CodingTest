package Search;

//이분탐색 알고리즘 - 재귀함수 이용
public class Binary_Search_Algorithm_V02 {
	public static void main(String[] args) {
		int[] arr = { 2, 8, 10, 16, 35, 44, 62, 68, 71, 78, 92, 95, 99, 100 };
		int num = 92;
		
		int max = arr.length-1;
		int min = 0;//min, max는 인덱스를 뜻함
		
		System.out.println(binarySearch(arr, num, max, min));//배열 index 0부터 시작
	}

	private static int binarySearch(int[] arr, int num, int max, int min) {//배열 arr에서 k번째 수가 어디에 위치하는지 구하기
		
		
		while(min<max) {
			int mid = (max + min) / 2;
			System.out.println(arr[mid]);
			
			if(arr[mid]>num) {
				return binarySearch(arr, num, mid-1, min);
			}else if(arr[mid]<num) {
				return binarySearch(arr, num, max, mid+1);
			}else {
				return min;
			}
		}
		
		return -1;//해당 숫자가 없는 경우

	}

}
