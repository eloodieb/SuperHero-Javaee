package model;

import entity.TypeIncident;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class TypeIncidentRepository {
		private Connection connection;
		public TypeIncidentRepository() {
			connection = Connexion.getInstance();
		}

		public ArrayList<TypeIncident> findAll() {
			ArrayList<TypeIncident> typeIncidents = new ArrayList<TypeIncident>(); 
			TypeIncident typeIncident;
			ResultSet result;
			try {
				Statement st = this.connection.createStatement();
				result = st.executeQuery("SELECT * FROM type_incident");
				while (result.next()) {
					System.out.println(result.getString("name"));
					typeIncident = new TypeIncident();
					typeIncident.setId(result.getLong("id"));
					typeIncident.setName(result.getString("name"));
					typeIncidents.add(typeIncident);
				}
				st.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return typeIncidents;
		}
		
		
}

