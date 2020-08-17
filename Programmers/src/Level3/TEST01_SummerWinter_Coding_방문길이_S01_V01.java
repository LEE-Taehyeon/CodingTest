package Level3;

import java.util.ArrayList;
import java.util.List;

//프로그래머스(방문길이)  --  35.0(실패)
public class TEST01_SummerWinter_Coding_방문길이_S01_V01 {
	static List<Direc> visitLine = new ArrayList<Direc>();
	public static void main(String[] args) {
		String dirs = "LULLLLLLU";
		int result = solution(dirs);
		System.out.println(result);

	}

	public static int solution(String dirs) {
		int x = 0;
		int y = 0;
		visitLine.add(new Direc(x, y));
		
		for (int i = 0; i < dirs.length(); i++) {
			char direction = dirs.charAt(i);

			switch (direction) {
			case 'U': {
				int dx = x;
				int dy = y+1;
				if(isRange(dx, dy)) {
					if(isFirstLine(x, y, dx, dy)) {
						visitLine.add(new Direc(dx, dy));
					}
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
						visitLine.add(new Direc(dx, dy));
					}
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
						visitLine.add(new Direc(dx, dy));
					}
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
						visitLine.add(new Direc(dx, dy));
					}
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

		return visitLine.size()-1;
	}

	private static boolean isFirstLine(int x, int y, int dx, int dy) {
		for(int i=0;i<visitLine.size()-1;i++) {
			if((visitLine.get(i).x==x && visitLine.get(i).y==y) && (visitLine.get(i+1).x==dx && visitLine.get(i+1).y==dy)) {
				return false;
			}
		}
		return true;
	}

	private static boolean isRange(int dx, int dy) {
		if(dx>=-5 && dx<=5 && dy>=-5 && dy<=5) {
			return true;
		}
		return false;
	}
}
class Direc{
	public int x;
	public int y;
	
	public Direc(int x, int y) {
		this.x = x;
		this.y = y;
	}
}