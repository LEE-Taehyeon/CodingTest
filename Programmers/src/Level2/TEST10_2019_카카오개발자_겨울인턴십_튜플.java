package Level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//프로그래머스(튜플)
public class TEST10_2019_카카오개발자_겨울인턴십_튜플 {
	public static void main(String[] args) {
		String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
		int[] result = solution(s);
		
		for(int i:result) {
			System.out.println(i);
		}

	}
	public static int[] solution(String s) {
        int[] answer = {};
        Map<String, Integer> map = new HashMap<String, Integer>();
        StringBuilder sb = new StringBuilder();
        
        for(int i=2;i<s.length()-1;i++) {
        	char ch = s.charAt(i);
        	if(!Character.isDigit(ch)) {
        		if(!sb.toString().equals("")) {
        			if(map.containsKey(sb.toString())) {
            			map.put(sb.toString(), map.get(sb.toString())+1);
            		}else {
            			map.put(sb.toString(), 1);
            		}
            		sb.delete(0, sb.length());
        		}
        	}else {
        		sb.append(ch);
        	}
        }
        
        //System.out.println(map);
        
        List<String> keySetList = new ArrayList<String>(map.keySet());
        
        Collections.sort(keySetList, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return map.get(o2)-map.get(o1);
				/*
				if(map.get(o1)==map.get(o2)) {
					return 0;
				}else {
					return map.get(o1)<map.get(o2)?1:-1;
				}
				*/
			}
		});
        
        answer = new int[keySetList.size()];
        for(int i=0;i<answer.length;i++) {
        	answer[i] = Integer.valueOf(keySetList.get(i));
        }
        
        return answer;
    }
}
