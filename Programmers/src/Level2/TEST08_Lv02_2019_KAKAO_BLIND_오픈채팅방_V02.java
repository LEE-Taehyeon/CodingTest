package Level2;

import java.util.HashMap;
import java.util.Map;

//프로그래머스_오픈채팅방
//접근방식 바꿈
public class TEST08_Lv02_2019_KAKAO_BLIND_오픈채팅방_V02 {
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
        Map<String, String> map = new HashMap<String, String>();//key값으로 id를 value값으로 닉네임을 저장하는 map 선언(map은 key값의 중복저장이 허락되지 않기 때문에)
        int size = 0;//answer의 크기를 지정하기 위한 변수 -> answer의 크기는 입력배열 record에서 Enter, Leave의 갯수이다.
        
        for(int i=0;i<record.length;i++) {
        	String[] strArr = record[i].split(" ");
        	if(strArr[0].equals("Enter")) {
        		map.put(strArr[1], strArr[2]);//id의 닉네임을 저장
        		size++;//answer의 크기를 알기 위한 작업(Enter, Leave 일때만)
        	}else if(strArr[0].equals("Change")) {
        		map.put(strArr[1], strArr[2]);
        	}else {
        		size++;//answer의 크기를 알기 위한 작업(Enter, Leave 일때만)
        	}
        }
        
        int j = 0;
        answer = new String[size];
        for(int i=0;i<record.length;i++) {//해당하는 지시어에 맞는 출력값 저장
        	String[] strArr = record[i].split(" ");
        	if(strArr[0].equals("Enter")) {
        		answer[j++] = map.get(strArr[1])+"님이 들어왔습니다.";
        	}else if(strArr[0].equals("Leave")) {
        		answer[j++] = map.get(strArr[1])+"님이 나갔습니다.";
        	}
        }
        
        return answer;
    }
}
