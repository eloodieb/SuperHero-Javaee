package entity;

public class IncidentHeroReport {
	private int idIncident;
	private int idHero;
	
	public IncidentHeroReport() {
	}
	
	public IncidentHeroReport(int idIncident, int idHero) {
		this.idIncident = idIncident;
		this.idHero = idHero;
	}
	
	public int getIdHero() {
		return idHero;
	}
	
	public int getIdIncident() {
		return idIncident;
	}
	public void setIdIncident(int idIncident) {
		this.idIncident = idIncident;
	}
	
	public void setIdHero(int idHero) {
		this.idHero = idHero;
	}


}
