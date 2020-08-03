package Search_Review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

//백준(1302)_베스트 셀러
public class TEST10_Search_1302_Review_R02 {
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
		
		
		// ② May.Entry<String, Integer> 로 비교
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		
		int max = 0;
		for(int i:map.values()){
			if(max<i) {
				max = i;
			}
		}
		
		List<String> list = new ArrayList<String>();
		
		for(Map.Entry<String, Integer> entry :entrySet) {
			if(entry.getValue()==max) {
				list.add(entry.getKey());
			}
		}
		Collections.sort(list);
		System.out.println(list.get(0));
	}

}


