package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entity.Hero;
import entity.Incident;

public class IncidentRepository {
	private Connection connection;
	
	public IncidentRepository() {
		connection = Connexion.getInstance();
	}
	
	public void create(Incident incident) {
		try {
			PreparedStatement prepare = this.connection.prepareStatement(
                      	"INSERT INTO incident_report (city, longitude, latitude, id_type_incident) "+
                      	"VALUES (?, ?, ?, ?)" 
                      );
			prepare.setString(1, incident.getCity());
			prepare.setDouble(2, incident.getLongitude());
			prepare.setDouble(3, incident.getLatitude());
			prepare.setInt(4, incident.getId_type_incident());
			prepare.executeUpdate();
			prepare.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
