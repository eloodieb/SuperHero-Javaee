package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Stack;

import java.math.BigDecimal;
import java.math.MathContext;

import com.mysql.jdbc.Statement;

import controler.GPSCoordinates;
import entity.Hero;



public class HeroRepository {
	private Connection connection;
	private GPSCoordinates gps;
	private IncidentHeroReportRepository incidentHeroReportRepository;
	
	public HeroRepository() {
		connection = Connexion.getInstance();
		incidentHeroReportRepository = new IncidentHeroReportRepository();
		gps = new GPSCoordinates();
	}
	
	public int create(Hero hero) {
		int id=0;
		try {
			PreparedStatement prepare = this.connection.prepareStatement(
                      	"INSERT INTO hero (name, mobile, adress, longitude, latitude) "+
                      	"VALUES (?, ?, ?, ?, ?)" ,
            Statement.RETURN_GENERATED_KEYS
                      );
			prepare.setString(1, hero.getName());
			prepare.setString(2, hero.getMobile());
			prepare.setString(3, hero.getAdress());
			prepare.setDouble(4, hero.getLongitude());
			prepare.setDouble(5, hero.getLatitude());
			
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
				hero.setAdress(result.getString("adress"));
				hero.setLongitude(result.getDouble("longitude"));
				hero.setLatitude(result.getDouble("latitude"));
				heros.add(hero);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return heros;
	}
	
	public ArrayList<Hero> findHerosDispo(double latitude, double longitude, String idIncident) {
		ArrayList<Hero> heros = new ArrayList<>(); 
		Hero hero;
		ResultSet result;
		try {
			result = this.connection.createStatement().executeQuery("SELECT * FROM hero");
			while (result.next()) {
				hero = new Hero();
				hero.setId(result.getLong("id"));
				Stack<String> idsArray = incidentHeroReportRepository.findByHero((int) result.getLong("id"));
				hero.setName(result.getString("name"));
				hero.setMobile(result.getString("mobile"));
				hero.setAdress(result.getString("adress"));
				hero.setLongitude(result.getDouble("longitude"));
				hero.setLatitude(result.getDouble("latitude"));
				double distance = gps.calculateDistance(new BigDecimal(hero.getLatitude(), MathContext.DECIMAL64), new BigDecimal(hero.getLongitude(), MathContext.DECIMAL64), new BigDecimal(latitude, MathContext.DECIMAL64), new BigDecimal(longitude, MathContext.DECIMAL64) );
				
				if(distance < 50000 && idsArray.contains(idIncident)) {
					heros.add(hero);
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return heros;
	}
	
}
