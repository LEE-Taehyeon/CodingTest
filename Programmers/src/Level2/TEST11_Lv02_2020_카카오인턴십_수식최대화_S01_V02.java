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
		for (int i = 0; i < expression.length(); i++) {//숫자와 부호를 따로 저장하기 위한 작업
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

		char[] signArr = { '*', '+', '-' };
		sel = new int[3];
		permutationSort(signArr, 0, numList, signList);//부호의 우선순위 설정 - 조합 알고리즘

		return max;
	}

	private static void permutationSort(char[] arr, int depth, List<Long> numList, List<Character> signList) {
		if (depth == sel.length) {
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
		}//해당 list의 숫자와 부호를 지워가며 사칙연산의 결과를 저장하고자 해당 list들 복사
		
		
		for (int i = 0; i < sel.length; i++) {
			for (int j = 0; j < signListCopy.size(); j++) {
				if (sel[i] == signListCopy.get(j)) {//우선순위에 맞는 부호일 때

					switch (signListCopy.get(j)) {
					case '*': {
						numListCopy.set(j, numListCopy.get(j)*numListCopy.get(j+1));//해당 연산을 한 후 j번째 값을 대체
						break;
					}
					case '-': {
						numListCopy.set(j, numListCopy.get(j)-numListCopy.get(j+1));
						break;
					}
					case '+': {
						numListCopy.set(j, numListCopy.get(j)+numListCopy.get(j+1));
						break;
					}

					}
					numListCopy.remove(j+1);//j+1번째 원소는 연산에 참여했으므로 원소 삭제
					signListCopy.remove(j);//해당 부호도 연산에 사용했으므로 원소 삭제
					j=-1;//앞에서부터 다시 연산을 하기 위한 j값 설정
				}
			}
		}
		
		if(Math.abs(numListCopy.get(0))>max) {//가장 앞에있는 값이 연산 후 결과값. 그 값이 max보다 클때 max값을 해당 값으로 변경
			max = Math.abs(numListCopy.get(0));
		}
	}
}
