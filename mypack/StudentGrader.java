package mypack;

import java.util.Scanner;

public class StudentGrader {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		char repeat = 'y';
		
		while(repeat == 'Y' || repeat == 'y') {
			System.out.println("Enter your exam score");
			int score = input.nextInt();
			int originalScore = score;
		
			score = score + 5;
			if (originalScore < 40)
				score = score - 2;
			if (score >= 50) {
				System.out.println("Pass");
			}else {
				System.out.println("Fail");
			}
		
			String status = (score >= 80)? "Excellent": ((score >= 60 && score <=79)? "Good":"Needs Improvement");
		
			System.out.printf("Your score is %d: %s",score,status);
		
			int lastDigit = score%10;
		
			switch(lastDigit) {
				case 0: 
				case 5:
					System.out.println("Nice round number");
					break;
				case 1:
				case 2:
				case 3:
				case 4:
					System.out.println("Low tail");
					break;
				case 6:
				case 7:
				case 8:
				case 9:
					System.out.println("High tail");
					break;
				default:
					System.out.println("Interesting score");
					break;
			}
		
			System.out.println("Do you want to retry grading process (y or n)? ");
			char r = input.next().trim().charAt(0);
			repeat = r;
			
		}//end while loop
		String userInput;
		do {
			System.out.println("Do you want to exit the program? ");
			userInput = input.next().trim();
		}while(userInput == "no" || userInput == "No" || userInput == "NO");
		
	}//end main
}//end class