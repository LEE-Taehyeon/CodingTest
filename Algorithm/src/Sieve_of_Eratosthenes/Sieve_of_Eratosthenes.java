package Sieve_of_Eratosthenes;

//에라토스테네스의 체:대량의 숫자가 소수인지 판별하기 위한 알고리즘
public class Sieve_of_Eratosthenes {
	public static void main(String[] args) {
		int[] arr = new int[1001];
		
		for(int i=0;i<arr.length;i++) {
			arr[i] = i;
		}
		
		for(int i=2;i<arr.length;i++) {
			if(arr[i]==0) {
				continue;
			}
			for(int j=i+i;j<arr.length;j+=i) {//이대로 그냥 구현해도 되지만, 조건이 조금만 달라져도(ex.백준_2960번 문제) 이 부분 수정해야함.
											  //j값의 시작이라던지, 아래의 조건을 붙인다던지
				arr[j] = 0;
				/*
				if(arr[j]!=0) {
					arr[j] = 0;
				}
				*/
			}
		}
		
		for(int i=2;i<arr.length;i++) {
			if(arr[i]!=0) {
				System.out.print(arr[i]+" ");
			}
		}

	}

}
