package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Stack;

import entity.Hero;
import entity.IncidentHeroReport;


public class IncidentHeroReportRepository {
	private Connection connection;
	public IncidentHeroReportRepository() {
		connection = Connexion.getInstance();
	}
	
	public void create(IncidentHeroReport incidentHeroReport) {
		try {
			PreparedStatement prepare = this.connection.prepareStatement(
                      	"INSERT INTO incident_hero_report (idIncident, idHero) "+
                      	"VALUES (?, ?)" 
                      );
			
			prepare.setInt(1, incidentHeroReport.getIdIncident());
			prepare.setInt(2, incidentHeroReport.getIdHero());
			prepare.executeUpdate();
			prepare.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<IncidentHeroReport> findAll(Long idHero) {
		ArrayList<IncidentHeroReport> incidentReports = new ArrayList<IncidentHeroReport>(); 
		IncidentHeroReport incidentReport;
		ResultSet result;
		try {
			Statement st = this.connection.createStatement();
			result = st.executeQuery("SELECT * FROM hero INNER JOIN incident_hero_report ON hero.id = incident_hero_report.idHero WHERE idHero ='" + idHero + "'");
			while (result.next()) {
				incidentReport = new IncidentHeroReport();
				incidentReport.setIdIncident(result.getInt("idIncident"));
				incidentReport.setIdHero(result.getInt("idHero"));
				incidentReports.add(incidentReport);
			}
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return incidentReports;
	}
	
    public Stack<String> findByHero(int idHero) {
    	Stack<String> idsArray = new Stack<String>();
		ResultSet result;
		try {
			Statement st = this.connection.createStatement();
			result = st.executeQuery("SELECT * FROM incident_hero_report where idHero =" + idHero);
			while (result.next()) {
				idsArray.push(result.getString("idIncident"));
			}
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return idsArray;
    }
}


