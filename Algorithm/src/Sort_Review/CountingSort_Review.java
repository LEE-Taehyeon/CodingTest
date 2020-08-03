package Sort_Review;

//정렬 - 계수정렬
public class CountingSort_Review {
	public static void main(String[] args) {
		int[] arr = { 1,5,3,4,1,3,2,5,1,3,
					  4,2,1,5,3,2,4,2,1,5,
					  3,2,4,2,1,3,1,2,1,3 };
		int[] sortArr = new int[5];
		
		for(int i=0;i<arr.length;i++) {
			sortArr[arr[i]-1]++;
		}
		
		for(int i=0;i<sortArr.length;i++) {
			for(int j=0;j<sortArr[i];j++) {
				System.out.print((i+1)+" ");
			}
		}
	}
}

