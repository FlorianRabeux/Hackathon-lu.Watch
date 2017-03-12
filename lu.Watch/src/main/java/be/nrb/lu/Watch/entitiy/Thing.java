package be.nrb.lu.Watch.entitiy;

public class Thing {

	private String id;
	private String name;
	private String isSecure;
	private String currentRule;
	private String timeFrom;
	private String timeTo;
	private String img;
	private String description;
	
	public Thing(String id, String name, String isSecure, String currentRule, String timeFrom, String timeTo,String description, String img) {
		super();
		this.id = id;
		this.name = name;
		this.isSecure = isSecure;
		this.currentRule = currentRule;
		this.timeFrom = timeFrom;
		this.timeTo = timeTo;
		this.description = description;
		this.img = img;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIsSecure() {
		return isSecure;
	}
	public void setIsSecure(String isSecure) {
		this.isSecure = isSecure;
	}
	public String getCurrentRule() {
		return currentRule;
	}
	public void setCurrentRule(String currentRule) {
		this.currentRule = currentRule;
	}
	public String getTimeFrom() {
		return timeFrom;
	}
	public void setTimeFrom(String timeFrom) {
		this.timeFrom = timeFrom;
	}
	public String getTimeTo() {
		return timeTo;
	}
	public void setTimeTo(String timeTo) {
		this.timeTo = timeTo;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	
	
	
	
}
