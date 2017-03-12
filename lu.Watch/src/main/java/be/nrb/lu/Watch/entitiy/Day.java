package be.nrb.lu.Watch.entitiy;

import java.util.ArrayList;
import java.util.List;

public class Day {

	private String name;
	private Boolean enable;
	
	public Day(String name, Boolean enable) {
		super();
		this.name = name;
		this.enable = enable;
	}
	
	public static List<Day> getDays(Boolean monday,Boolean tuesday,Boolean wednesday,Boolean thursday,Boolean friday,Boolean saturday, Boolean sunday) {
		List<Day> days = new ArrayList<>();
		
		days.add(new Day("monday", monday));
		days.add(new Day("tuesday", tuesday));
		days.add(new Day("wednesday", wednesday));
		days.add(new Day("thursday", thursday));
		days.add(new Day("friday", friday));
		days.add(new Day("saturday", saturday));
		days.add(new Day("sunday", sunday));
		
		return days;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}
	
	
}
