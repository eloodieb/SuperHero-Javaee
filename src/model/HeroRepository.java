package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import entity.Hero;



public class HeroRepository {
	private Connection connection;
	private IncidentHeroReportRepository incidentHeroReportRepository;
	
	public HeroRepository() {
		connection = Connexion.getInstance();
	}
	
	public int create(Hero hero) {
		int id=0;
		try {
			PreparedStatement prepare = this.connection.prepareStatement(
                      	"INSERT INTO hero (name, mobile, longitude, latitude) "+
                      	"VALUES (?, ?, ?, ?)" ,
            Statement.RETURN_GENERATED_KEYS
                      );
			prepare.setString(1, hero.getName());
			prepare.setString(2, hero.getMobile());
			prepare.setDouble(3, hero.getLongitude());
			prepare.setDouble(4, hero.getLatitude());
			prepare.executeUpdate();
		
			ResultSet rs=prepare.getGeneratedKeys();
            if(rs.next()){
                id=rs.getInt(1);
                }
            prepare.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
	}
	
	public ArrayList<Hero> findAll() {
		ArrayList<Hero> heros = new ArrayList<>(); 
		Hero hero;
		ResultSet result;
		try {
			result = this.connection.createStatement().executeQuery("SELECT * FROM hero");
			while (result.next()) {
				hero = new Hero();
				hero.setId(result.getLong("id"));
				hero.setName(result.getString("name"));
				hero.setMobile(result.getString("mobile"));
				hero.setLongitude(result.getDouble("longitude"));
				hero.setLatitude(result.getDouble("latitude"));
				heros.add(hero);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return heros;
	}
	
	public ArrayList<Hero> findHerosDispo(double latitude, double longitude, int idIncident) {
		ArrayList<Hero> heros = new ArrayList<>(); 
		Hero hero;
		ResultSet result;
		try {
			result = this.connection.createStatement().executeQuery("SELECT * FROM hero");
			while (result.next()) {
				hero = new Hero();
				hero.setId(result.getLong("id"));
				hero.setName(result.getString("name"));
				hero.setMobile(result.getString("mobile"));
				hero.setLongitude(result.getDouble("longitude"));
				hero.setLatitude(result.getDouble("latitude"));
				heros.add(hero);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return heros;
	}
	
}
