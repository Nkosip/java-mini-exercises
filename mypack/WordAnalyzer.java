package mypack;

import java.util.Scanner;

public class WordAnalyzer {
	public static void main(String[] args) {
		String sentence;
		Scanner scanner;
		//create a new Scanner object
		scanner = new Scanner(System.in);
		System.out.println("Enter a sentence e.g \"Java is Amazing\"");
		//read input as a line from the user
		sentence = scanner.nextLine().trim();
		
		sentence = sentence.toLowerCase();
		String[] words = sentence.split(" ");
		
		for(String word : words) {
			System.out.println(word);
		}
		
		System.out.println("The length of the first word is "+ words[0].length());
		System.out.println("The index of a in the first word is "+ words[0].indexOf("a"));
		System.out.println(words[0].startsWith("i") && words[0].endsWith("g"));
		System.out.println(String.valueOf(words[0].length()));
		
		System.out.println("Enter a second word");
		String secondWord = scanner.next().trim();
		
		int compare = secondWord.compareTo(words[0]);
		
		if(compare < 0) {
			System.out.println("Second word comes after the first word");
		}
		else if(compare > 0) {
			System.out.println("Second word comes before the first word");
		}
		else {
			System.out.println("Both words are the same");
		}
		
		int count = 0;
		
		for(int i=0;i<words.length;i++) {
			count++;
		}
		
		System.out.println("Original length = "+count+(count-1));
		
		for(int i=0;i<words.length;i++){
			System.out.print(words[i]+", ");
		}
		System.out.println();
		
		
		
	}
}