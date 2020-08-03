package Number_Of_Case;

import java.util.Arrays;

//재귀함수_조합 = nCr(중복X) / nHr(중복O)
public class Combination {
	public static void main(String[] args) {
		String[] strArr = { "a", "b", "c"};

		System.out.println("-----------조합-----------");
		
		for(int i=1;i<=strArr.length;i++) {
			String[] sel = new String[i];
			comb(strArr, sel, 0, 0);
		}
		
		System.out.println("-----------중복 조합-----------");
		
		for(int i=1;i<=strArr.length;i++) {
			String[] sel = new String[i];
			reComb(strArr, sel, 0, 0);
		}

	}

	private static void comb(String[] strArr, String[] sel, int i, int j) {//i:2개를 다 뽑았나 확인하는 ,  j:주어진 배열을 끝까지 다 돌았나 확인.
		if(j==sel.length) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		if(i==strArr.length) {
			return;
		}
		sel[j] = strArr[i];
		comb(strArr, sel, i+1, j+1);//맨 처음 하나를 뽑으면 그 다음 원소를 순차적으로 뽑게끔 하는 재귀함수
		comb(strArr, sel, i+1, j);//맨 처음 원소를 그 다음(b, c) 원소로 뽑으려고 하는 재귀함수
	}
	
	private static void reComb(String[] strArr, String[] sel, int i, int j) {//i:2개를 다 뽑았나 확인하는 ,  j:주어진 배열을 끝까지 다 돌았나 확인.
		if(j==sel.length) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		if(i==strArr.length) {
			return;
		}
		sel[j] = strArr[i];
		comb(strArr, sel, i, j+1);// 이 부분이 위의 조합과 다른 부분이다.
		comb(strArr, sel, i+1, j);
	}
}
