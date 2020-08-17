package Level2;

import java.util.ArrayList;
import java.util.List;

//프로그래머스(수식최대화) - long타입으로 선언하니 성공
public class TEST11_Lv02_2020_카카오인턴십_수식최대화_S01_V02 {
	static int[] sel;
	static boolean[] visit = new boolean[3];
	static long max = 0;

	public static void main(String[] args) {
		String expression = "100-8-2";
		long result = solution(expression);
		System.out.println(result);

	}

	public static long solution(String expression) {
		List<Long> numList = new ArrayList<Long>();
		List<Character> signList = new ArrayList<Character>();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < expression.length(); i++) {
			char ch = expression.charAt(i);
			if (!Character.isDigit(ch)) {
				numList.add(Long.valueOf(sb.toString()));
				sb.delete(0, sb.length());
				signList.add(ch);
			} else {
				sb.append(ch);
			}
		}
		numList.add(Long.valueOf(sb.toString()));

		System.out.println(numList);
		System.out.println(signList);

		char[] signArr = { '*', '+', '-' };
		sel = new int[3];
		permutationSort(signArr, 0, numList, signList);

		return max;
	}

	private static void permutationSort(char[] arr, int depth, List<Long> numList, List<Character> signList) {
		if (depth == sel.length) {
			// cnt++;
			//System.out.println(Arrays.toString(sel));
			for(int i=0;i<sel.length;i++) {
				System.out.print((char)sel[i]+" ");
			}
			System.out.println();
			calc(numList, signList);
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (!visit[i]) {
				visit[i] = true;
				sel[depth] = arr[i];
				permutationSort(arr, depth + 1, numList, signList);
				visit[i] = false;
			}
		}

	}

	private static void calc(List<Long> numList, List<Character> signList) {
		List<Long> numListCopy = new ArrayList<Long>();
		List<Character> signListCopy = new ArrayList<Character>();
		for(int i=0;i<numList.size();i++) {
			numListCopy.add(numList.get(i));
		}
		for(int i=0;i<signList.size();i++) {
			signListCopy.add(signList.get(i));
		}
		
		System.out.println("--------------");
		
		for (int i = 0; i < sel.length; i++) {
			for (int j = 0; j < signListCopy.size(); j++) {
				if (sel[i] == signListCopy.get(j)) {

					switch (signListCopy.get(j)) {
					case '*': {
						numListCopy.set(j, numListCopy.get(j)*numListCopy.get(j+1));
						//System.out.println(numListCopy.remove(j+1));
						break;
					}
					case '-': {
						numListCopy.set(j, numListCopy.get(j)-numListCopy.get(j+1));
						//System.out.println(numListCopy.remove(j+1));
						break;
					}
					case '+': {
						numListCopy.set(j, numListCopy.get(j)+numListCopy.get(j+1));
						//System.out.println(numListCopy.remove(j+1));
						break;
					}

					}
					numListCopy.remove(j+1);
					signListCopy.remove(j);
					j=-1;//수정
				}
			}
			System.out.println(signListCopy);
			System.out.println(numListCopy);
		}
		
		System.out.println("Math.abs(numListCopy.get(0)):"+Math.abs(numListCopy.get(0)));
		if(Math.abs(numListCopy.get(0))>max) {
			max = Math.abs(numListCopy.get(0));
		}
	}
}
