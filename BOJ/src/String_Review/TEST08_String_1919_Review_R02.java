package String_Review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//백준(1919)_애너그램 만들기
public class TEST08_String_1919_Review_R02 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputAStr = br.readLine();
		String inputBStr = br.readLine();
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i=0;i<inputAStr.length();i++) {
			char inputAChar = inputAStr.charAt(i);
			if(!map.containsKey(inputAChar)) {
				map.put(inputAChar, 1);
			}else {
				map.put(inputAChar, map.get(inputAChar)+1);
			}
		}
		
		for(int i=0;i<inputBStr.length();i++) {
			char inputBChar = inputBStr.charAt(i);
			if(!map.containsKey(inputBChar)) {
				map.put(inputBChar, -1);
			}else {
				map.put(inputBChar, map.get(inputBChar)-1);
			}
		}
		
		Set<Character> keySet = map.keySet();
		Iterator<Character> iter = keySet.iterator();
		int sum = 0;
		while(iter.hasNext()) {
			char key = iter.next();
			sum += Math.abs(map.get(key));
		}
		System.out.println(sum);
		
	}
}
