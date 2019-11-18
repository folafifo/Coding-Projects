

import java.util.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ChainLinks {
	public static ArrayList<String> readWorldList(Scanner input) {
		System.out.println("Please enter a list of words separated by commas(No Spaces) or an empty list to quit: ");
		String words = input.nextLine();
		if (words.isEmpty()) {
			input.close();
			return null;
		}
		String[] list = words.split(",");
		ArrayList<String> chain = new ArrayList<String>(Arrays.asList(list));
		return chain;
	}

	public static ArrayList<String> readDictionary() {
		ArrayList<String> dictionary = new ArrayList<String>();
		try {
			FileReader fileReader = new FileReader("src/words.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			boolean endOfFile = false;
			while (!endOfFile) {
				String line = bufferedReader.readLine();
				if (line != null) {
					dictionary.add(line);
				} else {
					endOfFile = true;
				}
			}
			bufferedReader.close();
		} catch (FileNotFoundException e) {
			System.err.println(e);
			System.exit(-1);
			
		} catch (IOException e) {
			System.err.println(e);
			System.exit(-1);
		}
		return dictionary;
	}

	public static boolean isUniqueList(ArrayList<String> chain) {
		for (int index = 0; index < chain.size(); index++) {
			String word = chain.get(index);
			for (int index1 = index + 1; index1 < chain.size(); index1++) {
				if (chain.get(index1).equals(word)) {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean isEnglishWord(String word, ArrayList<String> chain) {
		int index = Collections.binarySearch(chain, word);
		if (index >= 0) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isDifferentByOne(String word1, String word2) {
		if (word1.length() == word2.length()) {
			int differentBy = 0;
			for (int index = 0; index < word1.length(); index++) {
				if (word1.charAt(index) != (word2.charAt(index))) {
					differentBy++;
				}
			}
			if (differentBy >= 2) {
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}

	public static boolean isWordChain(ArrayList<String> chain) {
		ArrayList<String> dictionary = readDictionary();
		if (isUniqueList(chain)) {
			for (int index = 0; index < chain.size() - 1; index++) {
				String currentWord = chain.get(index);
				String nextWord = chain.get(index + 1);
				if ((isEnglishWord(currentWord, dictionary)) && (isEnglishWord(nextWord, dictionary))) {
					if (!isDifferentByOne(currentWord, nextWord)) {
						return false;
					}
				} else {
					return false;
				}
			}
		} else {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean finished = false;
		while (!finished) {
			ArrayList<String> chain = readWorldList(input);
			if (chain != null) {
				if (isWordChain(chain)) {
					System.out.println("Valid chain of words from Lewis Carroll's word-links game.");
				} else {
					System.out.println("Not a valid chain of words from Lewis Carroll's word-links game.");
				}
			} else {
				finished = true;
			}
		}
		System.out.println("Goodbye!");
		input.close();
	}
}
