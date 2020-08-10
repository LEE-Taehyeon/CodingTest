package Level2;

import java.util.ArrayList;
import java.util.List;

//프로그래머스(Lv2)_방금 그곡
public class TEST09_2018_KAKAO_BLIND_방금_그곡_FailFailFail {
	public static void main(String[] args) {
		String m = "ABC";
		String[] musicinfos = { "12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF" };
		//String[] musicinfos = { "03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B" };
		String result = solution(m, musicinfos);
		
		System.out.println(result);

	}
	public static String solution(String m, String[] musicinfos) {
        String answer = "";
        int size = musicinfos.length;
        
        List<Integer> musicTimes = new ArrayList<Integer>();
        List<String> musicTitles = new ArrayList<String>();
        
        for(int i=0;i<size;i++) {
        	String[] musicInfo = musicinfos[i].split(",");
        	int timeGap = calcTimeGap(musicInfo[0], musicInfo[1]);
        	
        	String musicPlay = musicPlaySound(timeGap, musicInfo[3]);
        	//System.out.println(musicPlay);
        	
        	if(musicPlay.length()<m.length()) {
        		continue;
        	}else {
        		for(int j=0;j<musicPlay.length();j++) {
        			if(musicPlay.charAt(j)==m.charAt(0)) {
        				for(int k=1;k<m.length();k++) {
            				if(j+k<musicPlay.length() && musicPlay.charAt(j+k)!=m.charAt(k)) {
            					break;
            				}
            				if(k==m.length()-1 && j+k+1<musicPlay.length() && musicPlay.charAt(j+k+1)!='#') {
            					musicTimes.add(timeGap);
                    			musicTitles.add(musicInfo[2]);
            				}
            			}
        			}
        		}
        	}
        	
        }
        
        
        for(String str:musicTitles) {
        	System.out.println(str);
        }
        for(int i:musicTimes) {
        	System.out.println(i);
        }
        
        if(musicTitles.size()==0) {
        	answer = "(None)";
        }else if(musicTitles.size()==1) {
        	answer = musicTitles.get(0);
        }else {
        	int max = 0;
        	int idx = 0;
        	for(int i=0;i<musicTimes.size();i++) {
        		if(musicTimes.get(i)>max) {
        			max = musicTimes.get(i);
        			idx = i;
        		}
        	}
        	answer = musicTitles.get(idx);
        }
        
        return answer;
    }
	
	
	private static int calcTimeGap(String startTime, String endTime) {
		String[] start = startTime.split(":");
		String[] end = endTime.split(":");
		int timeGap = 0;
		int hour = Integer.valueOf(end[0])-Integer.valueOf(start[0]);
		int minute = Integer.valueOf(end[1])-Integer.valueOf(start[1]);
		
		timeGap = hour*60+minute;

		return timeGap;
	}
	
	private static String musicPlaySound(int timeGap, String musicPlay) {
		StringBuilder sb = new StringBuilder();
		
		String sharp = musicPlay.replace("#", "");
		//System.out.println("musicPlay:"+musicPlay+" sharp:"+sharp);
		int length = musicPlay.length() - (musicPlay.length() - sharp.length());
		int share = timeGap/length;
		int remain = timeGap%length;
		
		for(int i=0;i<share;i++) {
			sb.append(musicPlay);
		}
		
		for(int i=0;i<remain;i++) {
			sb.append(musicPlay.charAt(i));
		}
		if(musicPlay.charAt(remain)=='#') {
			sb.append("#");
		}
		
		return sb.toString();
	}
	/*
	private static boolean kmp(String parent, String pattern) {
		int[] pi = getPi(pattern);
		char[] parentCharArr = parent.toCharArray();
		char[] patternCharArr =  pattern.toCharArray();
		int j = 0;
		
		for(int i=0;i<parent.length();i++) {
			while(j>0 && patternCharArr[j]!=parentCharArr[i]) {
				j = pi[j-1];
			}
			if(patternCharArr[j]==parentCharArr[i]) {
				if(j==patternCharArr.length-1) {
					if(i+1<parent.length() && parentCharArr[i+1]=='#') {
						return false;
					}else {
						return true;
					}
				}else {
					j++;
				}
			}
		}
		return false;
	}

	private static int[] getPi(String pattern) {
		char[] patternCharArr = pattern.toCharArray();
		int[] pi = new int[pattern.length()];
		int j = 0;
		
		for(int i=1;i<patternCharArr.length;i++) {
			while(j>0 && patternCharArr[j]!=patternCharArr[i]) {
				j = pi[j-1];
			}
			if(patternCharArr[j]==patternCharArr[i]) {
				pi[i] = ++j;
			}
		}
		return pi;
	}
	*/
}
