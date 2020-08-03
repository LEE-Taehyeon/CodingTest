package Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//백준(1302)_베스트 셀러
public class TEST10_Search_1302 {
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
		System.out.println(map);
		
		List<String> keySetList = new ArrayList<String>(map.keySet());
		Collections.sort(keySetList, (o1, o2) -> map.get(o1)<map.get(o2)?1:(map.get(o1)==map.get(o2)?o1.compareTo(o2):-1));
		System.out.println(map);
		/*
		 * 위랑 똑같음 이 방법이 훨씬 빠름.
		Collections.sort(keySetList, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(map.get(o1)<map.get(o2)) {
					return 1;
				}else {
					if(map.get(o1)==map.get(o2)) {
						return o1.compareTo(o2);
					}else {
						return -1;
					}
				}
			}
			
		});
		*/	
		System.out.println(keySetList.get(0));
	}

}


