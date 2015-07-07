import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem5 {

	private static String result = "";

	public static void main(String[] args) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(new FileReader("in.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("No file found!");
		}

		ArrayList<String> wordList = new ArrayList<String>();
		while (scanner.hasNext()) {
			String word = scanner.next();
			wordList.add(word);
		}

		System.out.println("Input word:");
		Scanner inputScanner = new Scanner(System.in);
		String inputWord = inputScanner.nextLine();
		inputScanner.close();
		if (wordBreak(inputWord, wordList)) {
			System.out.println(result);
		}

	}

	public static boolean wordBreak(String inputWord, ArrayList<String> wordList) {

		for (String word : wordList) {
			if (word.charAt(0) == inputWord.charAt(0)) {
				if (inputWord.startsWith(word)) {
					if (inputWord.equals(word)) {
						// System.out.println(inputWord);
						result = result + inputWord;
						return true;
					} else {
						// System.out.print(word + " ");
						result = result + word + " ";
						String newWord = inputWord.substring(word.length());
						return wordBreak(newWord, wordList);
					}
				}
			}

		}
		return false;
	}

}
