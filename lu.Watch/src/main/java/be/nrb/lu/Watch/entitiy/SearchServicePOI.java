package be.nrb.lu.Watch.entitiy;

public class SearchServicePOI {
	private String category;
	private String name;
	
	public SearchServicePOI(String category, String name) {
		super();
		this.category = category;
		this.name = name;
	}
	public SearchServicePOI() {
		super();
		category = "";
		name = "";
	}


	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
