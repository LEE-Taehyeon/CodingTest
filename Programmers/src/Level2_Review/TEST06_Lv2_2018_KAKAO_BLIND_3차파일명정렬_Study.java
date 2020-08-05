package Level2_Review;

public class TEST06_Lv2_2018_KAKAO_BLIND_3차파일명정렬_Study {

	public static void main(String[] args) {
		String str = "sfsf12345abc";
		String[] strArr = str.split("[0-9]+");

		for (String str1 : strArr) {
			System.out.println(str1);
		}
		System.out.println(strArr.length);

		System.out.println("------------------------");
		String[] strArr1 = str.split("[0-9]");

		for (String str1 : strArr1) {
			System.out.println(str1);
		}
		System.out.println(strArr1.length);

	}

}
