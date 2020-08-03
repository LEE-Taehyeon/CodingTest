package Search_Review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//백준(1302)_베스트 셀러
public class TEST10_Search_1302_Review_R01 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int bookCnt = Integer.valueOf(br.readLine());
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		for(int i=0;i<bookCnt;i++) {
			String bookname = br.readLine();
			if(map.containsKey(bookname)) {
				map.put(bookname, map.get(bookname)+1);
			}else {
				map.put(bookname, 1);
			}
		}
		
		
		// ① max값 찾고 map.keySet을 list에 넣어 오름차순 정렬 한 다음, max 값과 오름차순 한 list의 str에 해당되는 map의 value값을 비교
		List<String> keySetList = new ArrayList<String>(map.keySet());
		
		int max = 0;
		for(int i:map.values()){
			if(max<i) {
				max = i;
			}
		}
		
		Collections.sort(keySetList);
		for(String str:keySetList) {
			if(map.get(str)==max) {
				System.out.println(str);
				break;
			}
		}
	}

}


