import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem4 {

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

		for (String word : wordList) {
			int[] firstWord = new int[32];
			char[] letters = word.toCharArray();
			for (char letter : letters) {
				firstWord[letter - 97]++;
			}
			for (String annagram : wordList) {
				if (annagram != word) {
					int[] secondWord = new int[32];
					boolean check = true;
					char[] leters = annagram.toCharArray();
					for (char letter : leters) {
						secondWord[letter - 97]++;
					}
					for (int i = 0; i < 32; i++) {
						if (firstWord[i] != secondWord[i]) {
							check = false;
						}
					}
					if (check) {
						System.out.println(word + " " + annagram);
					}
				}
			}


		}

	}
}
