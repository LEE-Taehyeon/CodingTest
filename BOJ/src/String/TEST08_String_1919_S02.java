package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//백준(1919)_애너그램 만들기
public class TEST08_String_1919_S02 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] inputACharArr = br.readLine().toCharArray();
		char[] inputBCharArr = br.readLine().toCharArray();
		
		Map<Character, Integer> mapA = new HashMap<Character, Integer>();
		Map<Character, Integer> mapB = new HashMap<Character, Integer>();
		
		for(int i=0;i<inputACharArr.length;i++) {
			if(!mapA.containsKey(inputACharArr[i])) {
				mapA.put(inputACharArr[i], 1);
			}else {
				mapA.put(inputACharArr[i], mapA.get(inputACharArr[i])+1);
			}
		}
		for(int i=0;i<inputBCharArr.length;i++) {
			if(!mapB.containsKey(inputBCharArr[i])) {
				mapB.put(inputBCharArr[i], 1);
			}else {
				mapB.put(inputBCharArr[i], mapB.get(inputBCharArr[i])+1);
			}
		}
		System.out.println(mapA);
		System.out.println(mapB);
		
		Set<Character> keySet = mapA.keySet();
		Iterator<Character> iter = keySet.iterator();
		
		while(iter.hasNext()) {
			char ch = iter.next();
			if(mapB.containsKey(ch)) {
				if(mapA.get(ch)>mapB.get(ch)) {
					mapA.put(ch, mapA.get(ch)-mapB.get(ch));
					mapB.put(ch, 0);
				}else if(mapA.get(ch)<mapB.get(ch)) {
					mapB.put(ch, mapB.get(ch)-mapA.get(ch));
					mapA.put(ch, 0);
				}else {
					mapA.put(ch, 0);
					mapB.put(ch, 0);
				}
			}
		}
		System.out.println(mapA);
		System.out.println(mapB);
		Set<Character> keySetA = mapA.keySet();
		Iterator<Character> iterA = keySetA.iterator();
		int answer = 0;
		while(iterA.hasNext()) {
			char ch = iterA.next();
			answer += mapA.get(ch);
		}
		
		System.out.println(answer);
		Set<Character> keySetB = mapB.keySet();
		Iterator<Character> iterB = keySetB.iterator();
		while(iterB.hasNext()) {
			char ch = iterB.next();
			answer+= mapB.get(ch);
		}
		System.out.println(answer);
		
	}
}
