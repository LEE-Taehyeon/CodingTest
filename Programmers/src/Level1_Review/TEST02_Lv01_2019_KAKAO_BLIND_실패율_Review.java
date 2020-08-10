package Level1_Review;

import java.util.Arrays;
import java.util.Comparator;

//프로그래머스(Lv2)_실패율
public class TEST02_Lv01_2019_KAKAO_BLIND_실패율_Review {
	public static void main(String[] args) {
		int N = 5;
		int[] stages = { 2, 2, 2, 6, 2, 2, 2, 3 };
		int[] result = solution(N, stages);

		for (int i : result) {
			System.out.println(i);
		}

	}

	public static int[] solution(int N, int[] stages) {
		int[] answer = new int[N];
		int[] stageArr = new int[N];//입력된 stages에서 각 스테이지가 몇개인지를 배열에 저장
		double[] failure = new double[N];//실패율 저장 배열 , 배열의 크기를 하나라도 줄이기 위해 배열크기를 N+1이 아닌 N으로 선언.(stage 1 = index 0)
		Integer[] idx = new Integer[N];//출력하고자하는 것은 index이다. 이를 임의로 재정렬하여 출력하고자 하기 때문에 int타입이 아닌 Integer타입으로 선언
		int size = stages.length;

		for (int i = 0; i < N; i++) {//스테이지 number를 index에 맞게 저장(stage1 = index0). 추후 재배열에 사용
			idx[i] = i;
		}

		for (int i = 1; i <= N; i++) {//입력 stages배열에서 해당 stage의 갯수를 저장하기 위한 작업
			for (int j = 0; j < size; j++) {
				if (i == stages[j]) {
					stageArr[i - 1]++;
				}
			}
		}

		/*
		 * for(int i:stageArr) { System.out.println(i); }
		 */

		failure[0] = (double) stageArr[0] / size;
		for (int i = 1; i < stageArr.length; i++) {//실패율 계산
			if(size - stageArr[i-1]==0) {//분모가 0인 경우, 실패율 0.0 대입
				failure[i] = 0.0;
			}else {
				failure[i] = (double) stageArr[i] / (size - stageArr[i - 1]);//(해당스테이지의 플레이어 수)/(현재 남아있는 플레이어 수 - 이전 스테이지의 플레이어 수)
			}
			size -= stageArr[i - 1];
		}

		/*
		for (double d : failure) {
			System.out.println(d);
		}
		*/

		Arrays.sort(idx, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {//실패율에 따라 재정의
				if (failure[o1] - failure[o2] !=0) {
					return (failure[o1] - failure[o2] > 0) ? -1 : 1;//실패율이 높은 순으로 정의
				} else {
					return o1 - o2;//실패율이 같다면 작은 번호의 stage순으로 출력 
				}
			}
		});

		for(int i=0;i<N;i++) {//stage번호 answer에 저장
			answer[i] = idx[i]+1;//index0이 stage1에 해당하므로 해당 index번호에 +1을 해서 저장
		}

		return answer;
	}
}
