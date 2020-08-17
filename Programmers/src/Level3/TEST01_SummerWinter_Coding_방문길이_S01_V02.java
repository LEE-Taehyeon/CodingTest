package Level3;

import java.util.ArrayList;
import java.util.List;

//프로그래머스(방문길이) -- UDDUU같은 케이스 문제가 해결 안되었다. -> 비교하는 부분에서 잘못했음. 일단 이동한 거리를 모두 저장하고 있는 list가 있어서
//                                                  그 list의 원소를 비교해야하는데 올바른 길의 원소와 비교하니 안되었다.
public class TEST01_SummerWinter_Coding_방문길이_S01_V02 {
	static List<Direc1> line = new ArrayList<Direc1>();
	static List<Direc1> visitLine = new ArrayList<Direc1>();
	public static void main(String[] args) {
		String dirs = "UDDUU";
		int result = solution(dirs);
		System.out.println(result);

	}

	public static int solution(String dirs) {
		int x = 0;
		int y = 0;
		line.add(new Direc1(x, y));
		visitLine.add(new Direc1(x, y));
		
		for (int i = 0; i < dirs.length(); i++) {
			char direction = dirs.charAt(i);

			switch (direction) {
			case 'U': {
				int dx = x;
				int dy = y+1;
				if(isRange(dx, dy)) {
					if(isFirstLine(x, y, dx, dy)) {
						visitLine.add(new Direc1(dx, dy));
					}
					line.add(new Direc1(dx, dy));
					x = dx;
					y = dy;
				}
				break;
			}
			case 'D': {
				int dx = x;
				int dy = y-1;
				if(isRange(dx, dy)) {
					if(isFirstLine(x, y, dx, dy)) {
						visitLine.add(new Direc1(dx, dy));
					}
					line.add(new Direc1(dx, dy));
					x = dx;
					y = dy;
				}
				break;
			}
			case 'R': {
				int dx = x+1;
				int dy = y;
				if(isRange(dx, dy)) {
					if(isFirstLine(x, y, dx, dy)) {
						visitLine.add(new Direc1(dx, dy));
					}
					line.add(new Direc1(dx, dy));
					x = dx;
					y = dy;
				}
				break;
			}
			case 'L': {
				int dx = x-1;
				int dy = y;
				if(isRange(dx, dy)) {
					if(isFirstLine(x, y, dx, dy)) {
						visitLine.add(new Direc1(dx, dy));
					}
					line.add(new Direc1(dx, dy));
					x = dx;
					y = dy;
				}
				break;
			}
			}
		}
		for(int i=0;i<visitLine.size();i++) {
			System.out.println(visitLine.get(i).x+", "+visitLine.get(i).y);
		}
		System.out.println("x:"+x+", y:"+y);
		
		return visitLine.size()-1;
	}

	private static boolean isFirstLine(int x, int y, int dx, int dy) {
		for(int i=0;i<line.size()-1;i++) {
			if(((line.get(i).x==x && line.get(i).y==y) && (line.get(i+1).x==dx && line.get(i+1).y==dy)) || ((line.get(i).x==dx && line.get(i).y==dy) && (line.get(i+1).x==x && line.get(i+1).y==y))) {
				return false;
			}
		}
		return true;
	}

	private static boolean isRange(int dx, int dy) {
		if((dx>=-5 && dx<=5) && (dy>=-5 && dy<=5)) {
			return true;
		}
		return false;
	}
}
class Direc1{
	public int x;
	public int y;
	
	public Direc1(int x, int y) {
		this.x = x;
		this.y = y;
	}
}