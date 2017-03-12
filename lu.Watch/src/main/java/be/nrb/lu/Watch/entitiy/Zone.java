package be.nrb.lu.Watch.entitiy;

public class Zone {

	private String Lat;
	private String Lng;
	private String radius;

	
	public Zone(String lat, String lng) {
		super();
		Lat = lat;
		Lng = lng;
	}
	
	public Zone(String lat, String lng, String radius) {
		super();
		Lat = lat;
		Lng = lng;
		this.radius = radius;
	}
	
	public String getLat() {
		return Lat;
	}
	public void setLat(String lat) {
		Lat = lat;
	}
	public String getLng() {
		return Lng;
	}
	public void setLng(String lng) {
		Lng = lng;
	}

	public String getRadius() {
		return radius;
	}

	public void setRadius(String radius) {
		this.radius = radius;
	}
	
	
	
	
}
