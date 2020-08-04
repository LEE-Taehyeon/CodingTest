package Level2;

public class TEST05_Lv2_2017_카카오본선_단체사진찍기_FailFailFail {
	static char[] chrecters = { 'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T' };
	static char[] position = new char[8];
	static boolean[] visit = new boolean[8];
	static int cnt = 0;//프로그래머스에서 실행시 함수 내에서 초기화를 시켜주어야 한다.
	public static void main(String[] args) {
		int n = 2;
		String[] data = { "N~F=0", "R~T>2" };
		int result = solution(n, data);
		System.out.println(result);

	}
	public static int solution(int n, String[] data) {
        int answer = 0;
        
        backtracking(0, n, data);
        
        answer = cnt;
        return answer;
    }
	private static void backtracking(int depth, int n, String[] data) {
		if(depth==8) {
			if(isPossible(n, data)) {
				cnt++;
			}
			return;
		}
		
		for(int i=0;i<8;i++) {
			if(!visit[i]) {
				visit[i] = true;
				position[depth] = chrecters[i];
				backtracking(depth+1, n, data);
				visit[i] = false;
			}
		}
		
	}
	private static boolean isPossible(int n, String[] data) {
		for(int i=0;i<n;i++) {
			char[] condition = data[i].toCharArray();
			int from = 0;
			int to = 0;
			int cond = condition[4] - '0';
			
			for(int j=0;j<8;j++) {
				if(position[j]==condition[0]) {
					from = j;
				}
				if(position[j]==condition[2]) {
					to = j;
				}
			}
			
			int gap = Math.abs(from-to)-1;
			
			switch(condition[3]) {
			case '=':{
				if(gap!=cond) {
					return false;
				}
				break;
			}
			case '>':{
				if(gap<=cond) {
					return false;
				}
				break;
			}
			case '<':{
				if(gap>=cond) {
					return false;
				}
				break;
			}
			}
			
		}
		return true;
	}
}
