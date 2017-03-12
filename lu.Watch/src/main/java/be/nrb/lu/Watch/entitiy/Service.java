package be.nrb.lu.Watch.entitiy;

public class Service {

	private String name;
	private String category;
	private Address address;
	
	
	
	public Service(String name, String category, Address address) {
		super();
		this.name = name;
		this.category = category;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}
