package String_Review;

public class StringMatch_Review {
	public static void main(String[] args) {
		String parent = "ABCAEBEAEFVSDWFAEFAREWAFVAEF";
		String pattern = "AEF";
		
		for(int i=0;i<parent.length();i++) {
			for(int j=0;j<pattern.length();j++) {
				if(parent.charAt(i+j)!=pattern.charAt(j)) {
					break;
				}
				if(j==pattern.length()-1) {
					System.out.print(i+", ");
				}
			}
		}

	}

}
