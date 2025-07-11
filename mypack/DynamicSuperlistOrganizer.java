package mypack;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Arrays;
import java.util.HashSet;

public class DynamicSuperlistOrganizer {
	public static void main(String[] args) {
		Scanner scanner; 
		String category;
		String taskCategory;
		ArrayList<String> taskCategories;
		
		scanner = new Scanner(System.in);
		taskCategories = new ArrayList<>();
		
		do{
			System.out.println("Enter category name (or type done): ");
			category = scanner.next().trim();
			if(category.equalsIgnoreCase("done")) {
				break;
			}
			scanner.nextLine();
			System.out.println("Enter tasks (comma-separated): ");
			String[] tasks = scanner.nextLine().trim().split(",");
			Arrays.sort(tasks);
			HashSet<String> tasksSet = new HashSet<>(); 
			for(String task : tasks) {
				tasksSet.add(task);
			}
			tasks = tasksSet.toArray(new String[0]);
			
			taskCategory = addTasks(category,tasks);
			if(!taskCategories.contains(taskCategory))
				taskCategories.add(taskCategory);
			
		}while(true);
		
		ListIterator<String> taskCategoryIterator = taskCategories.listIterator();
		while(taskCategoryIterator.hasNext()) {
			System.out.println(taskCategoryIterator.next());
		}
		
	}
	//a method to store the category and tasks
	public static String addTasks(String category, String...tasks) {
		String categoryTask = "Category: "+category;
		for(String task : tasks) {
			categoryTask = String.format("%s\n- %s",categoryTask,task);
		}
		return categoryTask;
	}
	
}