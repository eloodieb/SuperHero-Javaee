package entity;

import java.util.List;


public class Hero {
	private Long id;
	private String name;
	private String mobile;
	private Double longitude;
	private Double latitude;
	private List<IncidentHeroReport> incidents;
	public Hero() {}
	public Hero(String name, String mobile, Double longitude, Double latitude) {
		this.name = name;
		this.mobile = mobile;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	
	public List<IncidentHeroReport> getIncidents() {
		return incidents;
	}
	public void setIncidents(List<IncidentHeroReport> incidents) {
		this.incidents = incidents;
	}
}
