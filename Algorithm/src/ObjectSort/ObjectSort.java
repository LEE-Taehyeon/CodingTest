package ObjectSort;

import java.util.Arrays;

public class ObjectSort {
	public static void main(String[] args) {
		Student[] students = new Student[5];
		students[0] = new Student("홍길동", 2020001, 95, 75, 90);
		students[1] = new Student("마준규", 2020005, 77, 65, 100);
		students[2] = new Student("이순신", 2020004, 85, 88, 97);
		students[3] = new Student("강감찬", 2020002, 90, 78, 96);
		students[4] = new Student("이재룡", 2020003, 75, 83, 82);
		
		Arrays.sort(students);
		for(int i=0;i<students.length;i++) {
			System.out.println(students[i]);
		}

	}

}
