package controler;

import java.awt.event.ItemEvent;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JCheckBox;

import entity.TypeIncident;
import model.HeroRepository;
import model.IncidentHeroReportRepository;
import model.TypeIncidentRepository;
import entity.Hero;
import entity.IncidentHeroReport;

/**
 * Servlet implementation class heroinscription
 */
@WebServlet("/heroinscription")
public class heroinscription extends HttpServlet {
	private TypeIncidentRepository incidentRepository;
	private HeroRepository heroRepository;
	private IncidentHeroReportRepository incidentHeroReportRepository;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public heroinscription() {
    	incidentRepository = new TypeIncidentRepository();
    	heroRepository = new HeroRepository();
    	incidentHeroReportRepository = new IncidentHeroReportRepository();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<TypeIncident> incidents = incidentRepository.findAll();
		request.setAttribute("incidents", incidents);
		String urlVue = "heroinscription.jsp";
		request.getRequestDispatcher(urlVue).forward(request, response); 
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String urlVue = "heroinscription.jsp";
		if(request.getParameter("add_hero") != null){
			String name = request.getParameter("name");
			String mobile = request.getParameter("mobile");  
			String adress = request.getParameter("adress");
			String longitude = request.getParameter("longitude");  
			String latitude = request.getParameter("latitude");  
		 
			GPSCoordinates gpsHero = GPSCoordinates.getGpsCoordinatesByAddress(adress);
			Hero hero = new Hero(name, mobile, adress, Double.parseDouble(longitude), Double.parseDouble(latitude));
		    int idHero = heroRepository.create(hero);
		    
		
		    for (int i=1; i<=10;i++) {
		    	
		    	String id_incident = request.getParameter("incident".concat(String.valueOf(i)));
		     
		    	if(id_incident != null) {
					
						IncidentHeroReport incidentreport = new IncidentHeroReport(Integer.parseInt(id_incident), idHero);
						incidentHeroReportRepository.create(incidentreport);
			
					
				}
				
		    	
		    }
		    
		   
			
			request.getRequestDispatcher(urlVue).forward(request, response); 

		}
	}

}
