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
        
        backtracking(0, n, data);//8명을 줄세우는 경우의 수 모두 탐색 - 8!
        
        answer = cnt;
        return answer;
    }
	private static void backtracking(int depth, int n, String[] data) {
		if(depth==8) {//8명 모두 줄을 세울때마다 isPossible을 통해 조건에 부합하는지 확인
			if(isPossible(n, data)) {//조건에 부합하면 cnt++
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
			char[] condition = data[i].toCharArray();//조건을 배열로 선언
			int from = 0;
			int to = 0;//from과 to는 조건에 해당하는 캐릭터
			int cond = condition[4] - '0';//조건에 떨어진 만큼의 거리
			
			for(int j=0;j<8;j++) {//한 줄로 세운 8명 중 조건에 맞는 두 캐릭터의 위치 구하기
				if(position[j]==condition[0]) {
					from = j;
				}
				if(position[j]==condition[2]) {
					to = j;
				}
			}
			
			int gap = Math.abs(from-to)-1;//두 캐릭터 위치의 차이 '-1'을 해주어야 몇 칸 떨어져있는지 알 수 있다.
			
			switch(condition[3]) {//조건에 부합하는지 확인 부합하지 않으면 false 리턴
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
		return true;//모든 조건에 맞는 줄세우기 경우이면 true 리턴
	}
}
