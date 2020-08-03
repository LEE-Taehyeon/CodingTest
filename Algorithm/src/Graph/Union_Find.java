package Graph;

//Union Find 구현
public class Union_Find {
	public static void main(String[] args) {
		int[] arr = new int[11];
		
		for(int i=1;i<arr.length;i++) {
			arr[i] = i;
		}
		String no = "NO";
		String yes = "YES";
		
		unionParent(arr, 1, 2);
		unionParent(arr, 2, 3);
		unionParent(arr, 3, 4);
		unionParent(arr, 5, 6);
		unionParent(arr, 7, 8);
		unionParent(arr, 8, 9);
		unionParent(arr, 9, 10);
		
		System.out.println("1과 5는 연결되어 있나요? "+ (findParent(arr, 1, 5)==0?no:yes));
		unionParent(arr, 1, 5);
		System.out.println("1과 5는 연결되어 있나요? "+ (findParent(arr, 1, 5)==0?no:yes));


	}

	private static int findParent(int[] arr, int i, int j) {
		i = getParent(arr, i);
		j = getParent(arr, j);
		if(i==j) {
			return 1;
		}else {
			return 0;
		}
	}

	private static void unionParent(int[] arr, int i, int j) {
		i = getParent(arr, i);
		j = getParent(arr, j);
		if(i<j) {
			arr[j] = i;
		}else {
			arr[i] = j;
		}
		
	}

	private static int getParent(int[] arr, int i) {
		if(arr[i]==i) {
			return i;
		}else {
			return arr[i] = getParent(arr, arr[i]);
		}
	}

}
