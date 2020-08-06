package Level2;

import java.util.ArrayList;
import java.util.List;

//싹다 실패(시간이 오래걸림) & 시간초과.
//일단 틀린이유 : 출력할 때 answer의 index를 i로 증가시켰다. & 예제 입력처럼 Leave가 마지막일 경우 올바른 출력을 하지 못함.
//현재코드 수정해서 테스트 24까지는 해결(시간은 오래걸림) 단, 이후 테스트케이스는 시간초과
public class TEST08_Lv02_2019_KAKAO_BLIND_오픈채팅방_V01 {
	public static void main(String[] args) {
		/*
		String[] record = { "Enter uid1234 Muzi",
							"Enter uid4567 Prodo",
							"Leave uid1234",
							"Enter uid1234 Prodo",
							"Change uid4567 Ryan" };
							*/
		String[] record = { "Enter uid1234 Muzi",
							"Change uid1234 Ryan",
							"Enter uid4567 Prodo",
							"Leave uid1234",
							"Enter uid1234 Prodo",
							"Enter uid2345 Prodo",
							"Change uid4567 Ryan",
							"Leave uid4567"};
		String[] result = solution(record);
		for(String str:result) {
			System.out.println(str);
		}
	}
	public static String[] solution(String[] record) {
        String[] answer = {};
        List<String> list = new ArrayList<String>();
        String[][] recordArr = new String[record.length][3];
        int cnt = 0;
        
        for(int i=0;i<record.length;i++) {
        	if(record[i].charAt(0)=='L') {
        		record[i] = record[i]+" 1";
        	}else if(record[i].charAt(0)=='C') {
        		cnt++;
        	}
        	recordArr[i] = record[i].split(" ");
        }        
        
        for(int i=recordArr.length-1;i>=0;i--) {
        	if(!list.contains(recordArr[i][1]) && recordArr[i][0].equals("Leave")) {
        		continue;
        	}else {
        		if(!list.contains(recordArr[i][1])) {
        			list.add(recordArr[i][1]);
        			for(int j=recordArr.length-1;j>=0;j--) {//i-1에서 recordArr.length-1로 바꿔서 처음부터 돌림
        				if(recordArr[i][1].equals(recordArr[j][1])){
        					recordArr[j][2] = recordArr[i][2];
        				}
        			}
        		}
        	}
        }
        

        for(int i=0;i<recordArr.length;i++) {
        	for(int j=0;j<recordArr[i].length;j++) {
        		System.out.print(recordArr[i][j]+" ");
        	}
        	System.out.println();
        }

        
        answer = new String[record.length-cnt];
        int idx = 0;
        for(int i=0;i<recordArr.length;i++) {
        	if(recordArr[i][0].equals("Enter")) {
        		answer[idx] = recordArr[i][2]+"님이 들어왔습니다.";
        		idx++;
        	}else if(recordArr[i][0].equals("Leave")) {
        		answer[idx] = recordArr[i][2]+"님이 나갔습니다.";
        		idx++;
        	}
        }
        
        return answer;
    }
}
