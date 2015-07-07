import java.util.Scanner;

public class Problem3 {

	public static void main(String[] args) {

		System.out.println("Enter number:");
		Scanner scanner = new Scanner(System.in);
		String number = scanner.nextLine();
		char[] digits = number.toCharArray();
		int newNumber = 0;
		for (int i = 0; i < digits.length; i++) {
			newNumber = (newNumber + (digits[i] - 48) * (int) Math.pow(10.0, digits.length - i - 1));
		}
		System.out.print(newNumber);
		scanner.close();
	}
}
