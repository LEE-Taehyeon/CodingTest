package Level1;

//참고 풀이
public class TEST07_Lv01_2018_KAKAO_BLIND_1차비밀지도 {
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

			while (share > 0) {//몫이 0일때까지 계속해서 나누고 나머지를 더해가기 위한 작업
				int remain = share % n;
				share /= n;

				if (remain >= 10 && remain<=15) {//나머지가 10이상 15이하 일때 A~F를 더하기 위한 if문
					sbReverse.append(alpha[remain - 10]);
				} else {//아니면 그냥 더한다
					sbReverse.append(remain);
				}
			}
			sb.append(sbReverse.reverse());//나머지를 거꾸로 더했으므로 다시 뒤집어서 더해준다.
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
