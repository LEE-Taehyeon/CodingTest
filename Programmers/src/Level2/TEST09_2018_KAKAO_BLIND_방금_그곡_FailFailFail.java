package Level2;

import java.util.ArrayList;
import java.util.List;

//프로그래머스(Lv2)_방금 그곡
public class TEST09_2018_KAKAO_BLIND_방금_그곡_FailFailFail {
	public static void main(String[] args) {
		String m = "CC#BCC#BCC#BCC#B";
		//String[] musicinfos = { "12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF" };
		String[] musicinfos = { "03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B" };
		String result = solution(m, musicinfos);

		System.out.println(result);

	}

	public static String solution(String m, String[] musicinfos) {
		String answer = "";
		String m_transform = sound_transform(m);//sound_transform메소드 : 음에 #이 붙은 음을 하나의 음으로 변경하기 위한 메소드(ex. C# -> c)
		
		List<String> musicList = new ArrayList<String>();//문제 조건에 맞는 음악제목 저장하기 위한 리스트 선언.
		List<Integer> timeList = new ArrayList<Integer>();//문제 조건에 맞는 음악재생시간 저장하기 위한 리스트 선언.
		
		for (int i = 0; i < musicinfos.length; i++) {
			String[] musicInfoArr = musicinfos[i].split(",");
			String sound_transform = sound_transform(musicInfoArr[3]);//sound_transform메소드 : 음에 #이 붙은 음을 하나의 음으로 변경하기 위한 메소드(ex. C# -> c)
			int timeGap = calc_time_gap(musicInfoArr[0], musicInfoArr[1]);//재생시간을 분단위로 구하기
			String music_transform = "";

			music_transform = music_transform(sound_transform, timeGap);//재생시간만큼의 해당 곡정보 재설정

			if (music_transform.contains(m_transform)) {//조건에 맞다면
				musicList.add(musicInfoArr[2]);
				timeList.add(timeGap);//음악제목과 재생시간 저장
			}
		}

		if (musicList.size() == 0) {
			answer = "(None)";
		} else if (musicList.size() == 1) {
			answer = musicList.get(0);
		} else {
			int max = 0;
			int idx = 0;
			for (int i = 0; i < timeList.size(); i++) {//조건에 맞는 음악이 여러개일 경우, 재생된 시간이 제일 긴 음악제목 출력. 같다면 먼저 재생된 음악 출력
				if (timeList.get(i) > max) {
					max = timeList.get(i);
					idx = i;
				}
			}
			answer = musicList.get(idx);
		}

		/*
		answer = "(None)";
		int time = 0;
		for (int i = 0; i < musicinfos.length; i++) {
			String[] musicInfoArr = musicinfos[i].split(",");
			int timeGap = calc_time_gap(musicInfoArr[0], musicInfoArr[1]);//재생시간을 분단위로 구하기
			
			
			if(timeGap>time) {//재생시간이 더 길때만 조건체크
				String sound_transform = sound_transform(musicInfoArr[3]);
				String music_transform = "";

				music_transform = music_transform(sound_transform, timeGap);
				if(music_transform.indexOf(m_transform)>=0) {
					answer = musicInfoArr[2];
					time = timeGap;
				}
			}
		}
		*/

		return answer;
	}
	
	//재생시간만큼의 곡정보 출력
	private static String music_transform(String sound_transform, int timeGap) {
		int share = timeGap / sound_transform.length();
		int remain = timeGap % sound_transform.length();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < share; i++) {//재생시간 / 음의 길이 (몫)만큼 String 더하기
			sb.append(sound_transform);
		}
		for (int i = 0; i < remain; i++) {//재생시간 % 음의 길이 (나머지)만큼 잘라서 String 더하기
			char ch = sound_transform.charAt(i);
			sb.append(ch);
		}

		return sb.toString();
	}

	//재생시간 구하기
	private static int calc_time_gap(String start, String end) {
		String start_hour = start.split(":")[0];
		String start_minute = start.split(":")[1];
		String end_hour = end.split(":")[0];
		String end_minute = end.split(":")[1];
		int hour = Integer.valueOf(end_hour) - Integer.valueOf(start_hour);
		int minute = Integer.valueOf(end_minute) - Integer.valueOf(start_minute);
		int time_gap = hour * 60 + minute;

		return time_gap;
	}
	
	//#붙은 음계를 바꾸는 2가지 방법
	private static String sound_transform(String m) {
		//1. replaceAll메소드
		m = m.replaceAll("C#", "c");
		m = m.replaceAll("D#", "d");
		m = m.replaceAll("F#", "f");
		m = m.replaceAll("G#", "g");
		m = m.replaceAll("A#", "a");
		
		return m;

		//2. for문을 이용한 변환
		/*
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<m.length()-1;i++) {
			char current = m.charAt(i);
			char next = m.charAt(i+1);
			
			if(next=='#') {
				sb.append((char)(current+32));
				i++;
			}else {
				sb.append(current);
			}
		}
		
		if(m.charAt(m.length()-1)!='#') {
			sb.append(m.charAt(m.length()-1));
		}
		
		return sb.toString();
		*/
	}

}
