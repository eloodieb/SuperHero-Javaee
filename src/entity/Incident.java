package entity;

import java.util.List;

public class Incident {
	private int id;
	private String city;
	private Double longitude;
	private Double latitude;
	private int id_type_incident;
	public Incident() {}
	public Incident(String city, Double longitude, Double latitude, int id_type_incident) {
		this.city = city;
		this.longitude = longitude;
		this.latitude = latitude;
		this.id_type_incident = id_type_incident;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
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
	public int getId_type_incident() {
		return id_type_incident;
	}
	public void setId_type_incident(int id_type_incident) {
		this.id_type_incident = id_type_incident;
	}
}
