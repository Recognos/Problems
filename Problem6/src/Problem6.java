import java.util.Scanner;

public class Problem6 {

	public static void main(String[] args) {

		String romanNumber = "";
		System.out.println("Enter number:");
		Scanner scanner = new Scanner(System.in);
		String inputNumber = scanner.nextLine();
		int length = inputNumber.length();
		scanner.close();
		int number = Integer.parseInt(inputNumber);
		while (number != 0) {
			int digit = (int) (number / Math.pow(10, length - 1));
			// digit = digit * (int) (Math.pow(10, length - 1));
			number = (int) (number % Math.pow(10, length - 1));
			romanNumber = romanNumber + toRoman(digit, length);
			length--;
		}
		System.out.println(romanNumber);
	}

	public static String toRoman(int number, int length) {
		String result = "";
		switch(length) {

		case 4:
			for (int i = 0; i < number; i++) {
				result = result + "M";
			}
			break;
		case 3 :
			result = convToRoman(number, "C", "D", "M");
			break;
		case 2:
			result = convToRoman(number, "X", "L", "C");
			break;
		case 1:
			result = convToRoman(number, "I", "V", "X");
			break;
		default : break;

		}
		return result;
	}

	public static String convToRoman(int number, String low, String mid, String high) {
		String result = "";
		if (number == 9) {
			result = low + high;
		} else if (number > 5 && number < 9) {
			result = result + mid;
			for (int i = 0; i < number - 5; i++) {
				result = result + low;
			}
		} else if (number == 5) {
			result = mid;
		} else if (number == 4) {
			result = low + mid;
		} else {
			for (int i = 0; i < number; i++) {
				result = result + low;
			}
		}
		return result;
	}


}
