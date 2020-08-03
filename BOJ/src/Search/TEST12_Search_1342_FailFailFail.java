package Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

//백준(1342)_행운의 문자열 - 메모리 초과
public class TEST12_Search_1342_FailFailFail {
	static Map<String, Integer> map = new HashMap<String, Integer>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] charArr = br.readLine().toCharArray();
		char[] output = new char[charArr.length];
		boolean[] visited = new boolean[charArr.length];
		perm(charArr, output, visited, 0, charArr.length, charArr.length);
		System.out.println(map);
		System.out.println(map.size());
		

	}
	
	
	public static void perm(char[] arr, char[] output, boolean[] visited, int depth, int n, int r) {
	    if (depth == r) {
	    	isLuckyString(output);
	        return;
	    }
	 
	    for (int i=0; i<n; i++) {
	        if (visited[i] != true) {
	            visited[i] = true;
	            output[depth] = arr[i];
	            perm(arr, output, visited, depth + 1, n, r);
	            visited[i] = false;;
	        }
	    }
	}


	private static void isLuckyString(char[] output) {
		for(int i=0;i<output.length-1;i++) {
			if(output[i]!=output[i+1]) {
				sb.append(output[i]);
				if(i==output.length-2) {
					map.put(sb.toString(), 1);
				}
			}else {
				sb.delete(0, sb.length());
				break;
			}
		}
		
	}
}
