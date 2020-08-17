package Level2;

import java.util.ArrayList;
import java.util.List;

//프로그래머스(수식최대화) - 10.0(실패)
public class TEST11_Lv02_2020_카카오인턴십_수식최대화_S01_V01 {
	static int[] sel;
	static boolean[] visit = new boolean[3];
	static int max = 0;

	public static void main(String[] args) {
		String expression = "100-200*300-500+20";
		long result = solution(expression);
		System.out.println(result);

	}

	public static long solution(String expression) {
		long answer = 0;
		List<Integer> numList = new ArrayList<Integer>();
		List<Character> signList = new ArrayList<Character>();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < expression.length(); i++) {
			char ch = expression.charAt(i);
			if (!Character.isDigit(ch)) {
				numList.add(Integer.valueOf(sb.toString()));
				sb.delete(0, sb.length());
				signList.add(ch);
			} else {
				sb.append(ch);
			}
		}
		numList.add(Integer.valueOf(sb.toString()));

		System.out.println(numList);
		System.out.println(signList);

		char[] signArr = { '*', '+', '-' };
		sel = new int[3];
		permutationSort(signArr, 0, numList, signList);

		return max;
	}

	private static void permutationSort(char[] arr, int depth, List<Integer> numList, List<Character> signList) {
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

	private static void calc(List<Integer> numList, List<Character> signList) {
		List<Integer> numListCopy = new ArrayList<Integer>();
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
				}
			}
			System.out.println(signListCopy);
			System.out.println(numListCopy);
		}
		if(signListCopy.size()==1) {
			switch (signListCopy.get(0)) {
			case '*': {
				numListCopy.set(0, numListCopy.get(0)*numListCopy.get(1));
				//System.out.println(numListCopy.remove(j+1));
				break;
			}
			case '-': {
				numListCopy.set(0, numListCopy.get(0)-numListCopy.get(1));
				//System.out.println(numListCopy.remove(j+1));
				break;
			}
			case '+': {
				numListCopy.set(0, numListCopy.get(0)+numListCopy.get(1));
				//System.out.println(numListCopy.remove(j+1));
				break;
			}
			}
		}
		
		System.out.println("Math.abs(numListCopy.get(0)):"+Math.abs(numListCopy.get(0)));
		if(Math.abs(numListCopy.get(0))>max) {
			max = Math.abs(numListCopy.get(0));
		}
	}
}
