package mypack;

import java.util.Scanner;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class DeviceController {
	public static int getBrightnessLevelInput(Scanner scanner) {
		int brightnessLevel;
		System.out.println("set brightness level (0-100)");
		try{
			brightnessLevel = Integer.parseInt(scanner.nextLine().trim());
		}catch(Exception e) {
			brightnessLevel = -1;
		}
		return brightnessLevel;
	}
	public static void main(String[] args) {
		int brightnessLevel;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter device name: ");
		String deviceName = scanner.nextLine().trim();
		SmartBulb bulb = new SmartBulb(deviceName);
		
		do {
			brightnessLevel = getBrightnessLevelInput(scanner);
			if(brightnessLevel < 0 || brightnessLevel > 100) {
				System.out.println("Invalid brightness. Please enter a value between 0 and 100.");
			}
		}while(brightnessLevel < 0 || brightnessLevel > 100);
		
		bulb.setBrightness(brightnessLevel);
		bulb.turnOn();
		bulb.operate();
		
		DeviceChecker checker = () -> bulb.isActive();
		
		if(checker.check()) {
			System.out.println(bulb.getStatusMessage());
		}
		
		bulb.showTime();
		
		scanner.close();
	}
}

abstract class SmartDevice{
	protected String name;
	protected boolean isOn;
	
	public SmartDevice(String name) {
		this.name = name;
		this.isOn = false;
	}

	abstract void operate();

	void showTime() {
		LocalDateTime localDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss ddMMyyyy");
		System.out.println("Time logged: "+localDateTime.format(formatter));
	}
	void rename(String newName) {
		this.name = newName;
	}
	public String toString() {
		return String.format("Name: %s is %s",name,(isOn ? "ON":"OFF"));
	}
}

interface Switchable {
	void turnOn();
	void turnOff();
}

interface StatusCheckable {
	boolean isActive();
	String getStatusMessage();
}

interface DeviceChecker {
	boolean check();
}

class SmartBulb extends SmartDevice implements Switchable,StatusCheckable{

	int brightnessLevel;
	
	public SmartBulb(String name) {
		super(name);
	}

	public void setBrightness(int level) {
		this.brightnessLevel = level;
	}

	public void turnOn(){
		isOn = true;
		System.out.println("Living Room bulb is now ON");
	}
	public void turnOff() {
		isOn = false;
		System.out.println("Living Room bulb is now OFF");
	}
	public boolean isActive() {
		return isOn;
	}
	public String getStatusMessage() {
		String status = isOn? "ACTIVE": "INACTIVE";
		return "Status: " + (isOn ? "ACTIVE" : "INACTIVE") + " — Brightness: " + brightnessLevel + "%";
	}
	void operate() {
		System.out.println(name + " Bulb is now ON");
		System.out.println("Lighting at "+brightnessLevel+"% brightness");
	}
}
