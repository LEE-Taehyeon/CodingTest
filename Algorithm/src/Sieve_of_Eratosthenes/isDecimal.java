package Sieve_of_Eratosthenes;

public class isDecimal {
	public static void main(String[] args) {
		int number = 15;
		boolean result = isDecimalNum(number);
		System.out.println(result);

	}

	private static boolean isDecimalNum(int number) {
		for (int i = 2; i < number; i++) {
			if (number % i == 2) {
				return false;
			}
		}
		return true;
	}
}
