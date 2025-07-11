package mypack;

import java.util.Scanner;

public class StepsGame {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String name;
		
		System.out.print("Please enter your name>> ");
		name = scanner.next().trim();
		System.out.println();
		
		if(name.isEmpty()) {
			System.out.println("Name cannot be empty!");
			scanner.close();
			System.exit(0);
		}
		
		System.out.printf("Hello %s!\n",name);
		System.out.printf("Your name has %d characters\n",name.length());
		System.out.printf("Your name starts with %c\n",name.charAt(0));
		System.out.printf("your name ends with %c\n",name.charAt(name.length()-1));
		if(name.contains("a") || name.contains("A")) {
			System.out.printf("Your name contains %c or %c\n",'a','A');
		}else {
			System.out.printf("No %c or %c was found in your name\n",'a','A');
		}
		
		String n = name.replaceAll("[aeiouAEIOU]","\'\'");
		System.out.println(n);
		
		for(int i=0;i<name.length();i++) {
			for(int j=0;j<i+1;j++) {
				System.out.print(name.charAt(j));
			}
			System.out.println();
		}
		for(int i=1;i<name.length()+1;i++) {
			if(i==3)continue; 
			System.out.print("Counting: "+i+" ");
			if(i==5)break;
		}
		System.out.println();
		System.out.printf("Thanks, %s for playing the Steps Game!\n",name);
		
		System.out.print("Please enter your second name>> ");
		String secondName = scanner.next().trim();
		System.out.println();
		
		System.out.println(name.concat(secondName));
		
		
		scanner.close();
	}//end main
}//end class