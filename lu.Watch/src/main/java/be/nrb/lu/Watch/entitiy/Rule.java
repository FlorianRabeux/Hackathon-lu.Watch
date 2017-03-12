package be.nrb.lu.Watch.entitiy;

import java.util.List;

public class Rule {
	private String id;
	private String name;
	private String dateFrom;
	private String dateTo;
	
	
	private List<Day> days;
	private Boolean email;
	private Boolean phone;
	private Boolean notificationEnable;
	
	  
	private String description;
	private String state;
	private Zone zone;
	private Zone userPosition;
	
	public Rule(String id,String name, String dateFrom, String dateTo, List<Day> days, Boolean email, Boolean phone,
			Boolean notificationEnable, String description, String state, Zone zone, Zone userPosition) {
		super();
		this.id = id;
		this.name = name;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.days = days;
		this.email = email;
		this.phone = phone;
		this.notificationEnable = notificationEnable;
		this.description = description;
		this.state = state;
		this.zone = zone;
		this.userPosition = userPosition;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(String dateFom) {
		this.dateFrom = dateFom;
	}

	public String getDateTo() {
		return dateTo;
	}

	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}

	public List<Day> getDays() {
		return days;
	}

	public void setDays(List<Day> days) {
		this.days = days;
	}

	public Boolean getNotificationEnable() {
		return notificationEnable;
	}

	public void setNotificationEnable(Boolean notificationEnable) {
		this.notificationEnable = notificationEnable;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

	public Boolean getEmail() {
		return email;
	}

	public void setEmail(Boolean email) {
		this.email = email;
	}

	public Boolean getPhone() {
		return phone;
	}

	public void setPhone(Boolean phone) {
		this.phone = phone;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Zone getUserPosition() {
		return userPosition;
	}

	public void setUserPosition(Zone userPosition) {
		this.userPosition = userPosition;
	}
	
	
	
	
	
	
	
	
}
