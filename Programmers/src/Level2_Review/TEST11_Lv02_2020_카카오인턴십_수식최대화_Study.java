package Level2_Review;

//프로그래머스(수식최대화)
public class TEST11_Lv02_2020_카카오인턴십_수식최대화_Study {
	public static void main(String[] args) {
		String expression = "5*100+35-8*20-2";
		String[] nums = expression.split("[^0-9]");//0~9사이의 문자열은 제외하고 split
		String[] signs = expression.split("[0-9]+");//0~9사이 중 하나 이상 포함한 문장열로 split
		
		for(String str:nums) {
			System.out.print(str+" ");
		}
		
		System.out.println();
		
		for(String str:signs) {
			System.out.print(str+" ");
		}
		
		System.out.println();
		
		System.out.println(nums.length);
		System.out.println(signs[0]);
		System.out.println(signs.length);
		
	}
}
