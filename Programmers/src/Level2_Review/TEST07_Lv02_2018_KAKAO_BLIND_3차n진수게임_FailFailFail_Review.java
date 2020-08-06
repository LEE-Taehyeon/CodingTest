package Level2_Review;

//참고 풀이
public class TEST07_Lv02_2018_KAKAO_BLIND_3차n진수게임_FailFailFail_Review {
	public static void main(String[] args) {
		int n = 13;
		int t = 10;
		int m = 100;
		int p = 100;
		String result = solution(n, t, m, p);

		System.out.println(result);

	}

	public static String solution(int n, int t, int m, int p) {
		StringBuilder answer = new StringBuilder();//answer를 String으로 선언하는 것보다 훨씬 빠르다.
		
		StringBuilder sb = new StringBuilder("0");
		String[] alpha = { "A", "B", "C", "D", "E", "F" };

		for (int i = 1; sb.length() < t * m; i++) {
			StringBuilder sbReverse = new StringBuilder();
			int share = i;

			while (share > 0) {
				int remain = share % n;
				share /= n;

				if (remain >= 10 && remain<=15) {
					sbReverse.append(alpha[remain - 10]);
				} else {
					sbReverse.append(remain);
				}
			}
			sb.append(sbReverse.reverse());
		}
		
		// System.out.println(sb);
		int count = 0;
		int idx = p - 1;
		while (count != t) {
			answer.append(sb.charAt(idx));
			idx += m;
			count++;
		}

		return answer.toString();
	}
}
