package mypack;

import java.util.Scanner;
import java.util.Arrays;

public class PasswordPuzzleGenerator {
	
	public static void main(String[] args) {
		Scanner scanner;
		String[] words;
		int size;
		char response = 'y';
		
		do{
			
			scanner = new Scanner(System.in);
			System.out.println("Enter the number of words you want to use (3-5) >> ");
			size = scanner.nextInt();
	
			words = new String[size];
	
			for(int i=0;i<words.length;i++) {
				switch(i) {
					case 0:
						System.out.println("Enter the 1st word >>");
						words[0] = scanner.next();
						break;
					case 1:
						System.out.println("Enter the 2nd word >>");
						words[1] = scanner.next();
						break;
					case 2:
						System.out.println("Enter the 3rd word >> ");
						words[2] = scanner.next();
						break;
					default :
						System.out.println("Enter the "+(i+1)+"th"+" word >> ");
						words[i] = scanner.next();
						break;
				}
			}
			
			Arrays.sort(words);
			for(int i=0;i<words.length;i++) {
				System.out.println(words[i]);
			}
	
			for(int i=0;i<words.length;i++) {
				words[i] = words[i].trim();
				String lower = words[i].toLowerCase();
				words[i] = lower.substring(0,1).toUpperCase().concat(lower.substring(1,words[i].length()));
				System.out.println("word "+(i+1)+": "+words[i]);
			}
		
			System.out.println("Choose a number between (1 & "+words.length+")");
			int num1 = scanner.nextInt();
			System.out.println();
			System.out.println("Choose a another number between (1 &"+words.length+")");
			int num2 = scanner.nextInt();
			System.out.println();
		
			StringBuilder first = new StringBuilder(words[num1-1]);
			first.reverse();
			String second = words[num2-1].substring(0,3);
		
			System.out.println("Choose a special character (! or @ or #) that you want to use >> ");
			char c = scanner.next().trim().charAt(0);
			first.append(" "+second).setCharAt(words[num1-1].length(),c);
			int len = first.length();
			String password = first.toString().concat(""+len);
		
			if(password.startsWith("[aeiouAEIOU]")){
				System.out.println("Your password starts with a vowel! ");
			}
		
			String message = String.format("Your generated password is: %s\nStarts with a vowel? %s",password,password.startsWith("[aeiouAEIOU]")?"Yes":"No");
			System.out.println(message);
			
			System.out.println("are you happy with your password?");
			response = scanner.next().trim().toLowerCase().charAt(0);
		}while(response == 'n');
	

		
		
		scanner.close();
	} //end main

}