package ObjectSort;

public class Student implements Comparable<Student> {
	private String name;
	private int sid;
	private int koreaScore;
	private int engScore;
	private int mathScore;
	
	
	public Student(String name, int sid, int koreaScore, int engScore, int mathScore) {
		this.name = name;
		this.sid = sid;
		this.koreaScore = koreaScore;
		this.engScore = engScore;
		this.mathScore = mathScore;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getSid() {
		return sid;
	}


	public void setSid(int sid) {
		this.sid = sid;
	}


	public int getKoreaScore() {
		return koreaScore;
	}


	public void setKoreaScore(int koreaScore) {
		this.koreaScore = koreaScore;
	}


	public int getEngScore() {
		return engScore;
	}


	public void setEngScore(int engScore) {
		this.engScore = engScore;
	}


	public int getMathScore() {
		return mathScore;
	}


	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}


	@Override
	public String toString() {
		return "Student [name=" + name + ", sid=" + sid + ", koreaScore=" + koreaScore + ", engScore=" + engScore
				+ ", mathScore=" + mathScore + "]";
	}


	@Override
	public int compareTo(Student o) {
		return mathScore<o.getMathScore()?1:(mathScore==o.getMathScore()?0:-1);
	}
	
	
	
	
	
}
