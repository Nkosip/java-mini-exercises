package mypack;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class TimeCapsule {
	private String title;
	private String message;
	private LocalDate date;
	private LocalTime time;
	private ZoneId zone;
	private Boolean reminderSet;
	
	public TimeCapsule(String title,String message,String date,String time,
				String zone,boolean reminderSet) {
					this.title = title;
					this.message = message;
					this.date = LocalDate.parse(date);
					this.time = LocalTime.parse(time);
					this.zone = ZoneId.of(zone);
					this.reminderSet = Boolean.valueOf(reminderSet);
	}
	
	
	public void setTitle(String title) {
		this.title = title;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	public void setZone(ZoneId zone) {
		this.zone = zone;
	}
	public void setReminderSet(Boolean reminderSet) {
		this.reminderSet = reminderSet;
	}
	
	
	public String getTitle() {
		return title;
	}
	public String getMessage() {
		return message;
	}
	public LocalDate getDate() {
		return date;
	}
	public LocalTime getTime() {
		return time;
	}
	public ZoneId getZone() {
		return zone;
	}
	public Boolean getReminderSet() {
		return reminderSet;
	}
	
	public String toFormattedString() {
		LocalDateTime dateTime = LocalDateTime.of(date,time);
		ZonedDateTime zonedDateTime = ZonedDateTime.of(date,time,zone);
		String formattedLocalDateTime = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		String formattedZonedDateTime = zonedDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		String formattedString = String.format("Title: %s\nMessage: %s\nDate: %s\nTime: %s\nZone: %s\nReminder? %b\nCapsule set for %s\n%s",title,message,date.toString(),time.toString(),zone.toString(),reminderSet,formattedZonedDateTime,formattedLocalDateTime);
		
		return formattedString;
	}
	
	public static void main(String[] args) {
		Scanner input;
		ArrayList<TimeCapsule> capsules;
		int numOfCapsules;
		
		input = new Scanner(System.in);
		capsules = new ArrayList<TimeCapsule>();
		
		System.out.println("How many capsules do you want to create? ");
		numOfCapsules = Integer.parseInt(input.next());
		input.nextLine();
		
		for(int i=0;i<numOfCapsules;i++) {
			System.out.println("Enter title: ");
			String title = input.nextLine().trim();
			System.out.println("Enter message: ");
			String message = input.nextLine().trim();
			System.out.println("Enter date(yyyy-MM-dd): ");
			String date = input.nextLine().trim();
			System.out.println("Enter time(HH:mm): ");
			String time = input.nextLine().trim();
			System.out.println("Enter zone(e.g Europe/Paris): ");
			String zone = input.nextLine().trim();
			System.out.println("Enter reminder(Boolean): ");
			boolean reminder = input.nextBoolean();
			
			input.nextLine();
			
			capsules.add(new TimeCapsule(title,message,date,time,zone,reminder));
			
		}
		
		System.out.println("Choose a locale (e.g FRANCE, JAPAN, etc)");
		String locale = input.nextLine().trim();
		
		ListIterator<TimeCapsule> timeCapsuleIterator = capsules.listIterator();
		while(timeCapsuleIterator.hasNext()) {
			TimeCapsule capsule = timeCapsuleIterator.next();
			System.out.println(capsule.toFormattedString());
			System.out.println();
			System.out.println();
		}
		
	}
}