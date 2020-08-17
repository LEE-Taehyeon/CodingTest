package Level3;

import java.util.ArrayList;
import java.util.List;

//프로그래머스(방문길이) : V02 깔끔하게 정리한 버젼
public class TEST01_SummerWinter_Coding_방문길이_S01_V03 {
	static List<Direc2> line = new ArrayList<Direc2>();
	static List<Direc2> visitLine = new ArrayList<Direc2>();
	static int x = 0;
	static int y = 0;
	public static void main(String[] args) {
		String dirs = "UDDUU";
		int result = solution(dirs);
		System.out.println(result);

	}

	public static int solution(String dirs) {
		line.add(new Direc2(x, y));
		visitLine.add(new Direc2(x, y));
		
		for (int i = 0; i < dirs.length(); i++) {
			char direction = dirs.charAt(i);

			switch (direction) {
			case 'U': {
				int dx = x;
				int dy = y+1;
				check(x, y, dx, dy);
				break;
			}
			case 'D': {
				int dx = x;
				int dy = y-1;
				check(x, y, dx, dy);
				break;
			}
			case 'R': {
				int dx = x+1;
				int dy = y;
				check(x, y, dx, dy);
				break;
			}
			case 'L': {
				int dx = x-1;
				int dy = y;
				check(x, y, dx, dy);
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

	private static void check(int x2, int y2, int dx, int dy) {
		if(isRange(dx, dy)) {
			if(isFirstLine(x, y, dx, dy)) {
				visitLine.add(new Direc2(dx, dy));
			}
			line.add(new Direc2(dx, dy));
			x = dx;
			y = dy;
		}
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
class Direc2{
	public int x;
	public int y;
	
	public Direc2(int x, int y) {
		this.x = x;
		this.y = y;
	}
}