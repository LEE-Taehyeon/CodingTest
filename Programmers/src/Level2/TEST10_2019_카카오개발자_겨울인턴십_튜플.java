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
        	if(!Character.isDigit(ch)) {//숫자가 아니면 map에 저장
        		if(!sb.toString().equals("")) {//이때 StringBuilder가 ""이면 저장하지 않기 위한
        			if(map.containsKey(sb.toString())) {//원소 저장
            			map.put(sb.toString(), map.get(sb.toString())+1);
            		}else {
            			map.put(sb.toString(), 1);
            		}
            		sb.delete(0, sb.length());
        		}
        	}else {//charAt()원소가 숫자이면 StringBuilder에 계속 붙여나가기(해당 원소가 두자리수 이상일 경우)
        		sb.append(ch);
        	}
        }
        
        //System.out.println(map);
        
        List<String> keySetList = new ArrayList<String>(map.keySet());
        
        Collections.sort(keySetList, new Comparator<String>() {//map value값을 기준으로 내림차순 정렬

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
        
        //map의 key값 배열로 복사
        answer = new int[keySetList.size()];
        for(int i=0;i<answer.length;i++) {
        	answer[i] = Integer.valueOf(keySetList.get(i));
        }
        
        return answer;
    }
}
