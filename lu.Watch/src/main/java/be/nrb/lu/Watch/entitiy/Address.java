package be.nrb.lu.Watch.entitiy;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Address {
	
	private String street;
	private String num;
	private Integer zip;
	private String locality;
	private String country;
	@JsonProperty("coordinates")
	private Zone zone;
	
	
	
	public Address(String street, String num, Integer zip, String locality, String country, Zone zone) {
		super();
		this.street = street;
		this.num = num;
		this.zip = zip;
		this.locality = locality;
		this.country = country;
		this.zone = zone;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public Integer getZip() {
		return zip;
	}
	public void setZip(Integer zip) {
		this.zip = zip;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Zone getZone() {
		return zone;
	}
	public void setZone(Zone zone) {
		this.zone = zone;
	}
	
	
}