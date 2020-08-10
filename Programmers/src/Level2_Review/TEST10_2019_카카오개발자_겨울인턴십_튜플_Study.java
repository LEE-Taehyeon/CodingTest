package Level2_Review;

import java.util.StringTokenizer;

//프로그래머스(튜플)
public class TEST10_2019_카카오개발자_겨울인턴십_튜플_Study {
	public static void main(String[] args) {
		String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
		StringTokenizer stk = new StringTokenizer(s, "}{");
		
		while(stk.hasMoreTokens()) {
			System.out.println(stk.nextToken());
		}

	}
}
