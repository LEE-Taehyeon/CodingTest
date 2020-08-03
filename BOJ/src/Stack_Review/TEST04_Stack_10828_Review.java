package Stack_Review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//백준(10828)_스택
public class TEST04_Stack_10828_Review {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.valueOf(br.readLine());
		int[] stkArr = new int[testCase];//스택역할을 해줄 배열, 배열의 최대 크기는 testCase를 넘지 않는다. 원소를 넣고 빼고 하는 작업이 반복되므로
		int top = -1;//원소를 삽입/삭제 작업을 반복했을 때의 현재 배열의 index를 가리킨다
		
		for(int i=0;i<testCase;i++) {
			String promp = br.readLine();
			switch(promp) {
			case "pop":{
				System.out.println(top==-1?-1:stkArr[top]);//top==-1인 경우 배열에 원소가 없는 것을 의미(스택이 비어있는 경우)
				top = top<=-1?top:--top;
				break;
			}
			case "size":{
				System.out.println(top+1);
				break;
			}
			case "empty":{
				System.out.println(top==-1?1:0);
				break;
			}
			case "top":{
				System.out.println(top==-1?-1:stkArr[top]);
				break;
			}
			default:{//push일 경우
				top++;
				stkArr[top] = Integer.valueOf(promp.substring(5));
			}
			}
		}
	}
}
