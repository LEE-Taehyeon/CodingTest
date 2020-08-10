package Level2_Review;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

//프로그래머스(튜플) - 다른풀이
public class TEST10_2019_카카오개발자_겨울인턴십_튜플_Review {
	public static void main(String[] args) {
		String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
		int[] result = solution(s);
		
		for(int i:result) {
			System.out.println(i);
		}

	}
	public static int[] solution(String s) {
        int[] answer = {};
        StringTokenizer stk = new StringTokenizer(s, "{}");
        List<String> list = new ArrayList<String>();
        
        while(stk.hasMoreTokens()) {
        	String token = stk.nextToken();
        	System.out.println("token:"+token);
        	if(!token.equals(",")) {
        		list.add(token);
        	}
        }
        
        Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.length()-o2.length();
			}
        	
		});
        
        Set<String> set = new HashSet<String>();
        
        int cnt = 0;
        answer = new int[list.size()];
        for(String str:list) {
        	for(String str2:str.split(",")) {
        		System.out.println("str2:"+str2);
        		if(set.add(str2)) {
        			answer[cnt++] = Integer.valueOf(str2);
        		}
        	}
        }
        
        return answer;
    }
}
