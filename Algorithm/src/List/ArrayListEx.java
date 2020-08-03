package List;

import java.util.ArrayList;
import java.util.List;

public class ArrayListEx {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		
		list.add(1, 1);
		list.add(2, 2);
		list.add(5, 5);
		list.add(3, 3);
		// java.lang.IndexOutOfBoundsException 발생
		// 이유 : ArrayList에 index를 지정하여 값을 넣어줄 때, 0번부터 순서대로 넣어주어야 한다.
		
		list.add(0, 0);
		list.add(1, 1);
		list.add(2, 2);
		list.add(3, 3);
		list.add(4, 4);
		list.add(5, 5);
		//정상작동
		
		System.out.println(list);

	}

}
