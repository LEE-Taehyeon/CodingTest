package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 알고리즘(한 줄로 서기)
public class TEST04_Greedy_1138 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nPeople = Integer.valueOf(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int[] peopleArr = new int[nPeople];
		for(int i=0;i<peopleArr.length;i++) {
			peopleArr[i] = Integer.valueOf(st.nextToken());
		}

		int[] answer = solution(nPeople, peopleArr);
		for(int i=0;i<answer.length;i++) {
			if(i!=answer.length-1) {
				System.out.print(answer[i]+" ");
			}else {
				System.out.print(answer[i]);
			}
			
		}
		
	}

	private static int[] solution(int nPeople, int[] peopleArr) {
		int[] arr = new int[nPeople];
		
		int num = 0;
		int notZero = 0;
		
		for(int i=0;i<peopleArr.length;i++) {
			for(int j=0;j<arr.length;j++) {	
				if(peopleArr[i]!=num) {
					if(arr[j]==0) {
						num++;//값이 비어있을때 num을 증가시켜 숫자 넣을 자리를 하나 증가시킨다.
					}
					if(arr[j]!=0) {
						notZero++;//값이 있으면 그자리에 대체해서 넣을 수 없으므로 하나 뒤에 넣으려는 작업
					}
				}else {
					if(arr[j]!=0) {
						notZero++;//값이 있으면 그자리에 대체해서 넣을 수 없으므로 하나 뒤에 넣으려는 작업
					}else {
						break;
					}
				}
			}
			arr[num+notZero] = i+1;
			num = 0;
			notZero = 0;
		}
		return arr;
	}

}
