package String_Review;

public class TEST05_String_2908_Review_Study {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		sb.append("자바 프로그래밍");
		System.out.println("sb.insert 전:"+sb);
		
		sb.insert(2, "(JAVA)");
		System.out.println("sb.insert 후:"+sb);
		
		sb.delete(0, 2);
		System.out.println("sb.delete 후:"+sb);
		
		sb.deleteCharAt(0);
		sb.deleteCharAt(4);
		System.out.println("sb.deleteCharAt() 후:"+sb);
		
		sb.reverse();
		System.out.println("sb.reverse() 후:"+sb);
		sb.reverse();
		System.out.println(sb);
	}

}
