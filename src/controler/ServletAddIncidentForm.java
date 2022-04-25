package controler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Hero;
import entity.Incident;
import entity.TypeIncident;
import model.HeroRepository;
import model.IncidentRepository;
import model.TypeIncidentRepository;


/**
 * Servlet implementation class ServletAddIncidentForm
 */

@WebServlet("/addIncident")
public class ServletAddIncidentForm extends HttpServlet {
	private TypeIncidentRepository typeIncidentRepository;
	private IncidentRepository incidentRepository;
	private HeroRepository heroRepository;
	

	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAddIncidentForm() {
    	typeIncidentRepository = new TypeIncidentRepository();
    	incidentRepository = new IncidentRepository();
    	heroRepository = new HeroRepository();
        // TODO Auto-generated constructor stub
    
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void  doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<TypeIncident> incidents = typeIncidentRepository.findAll();
		request.setAttribute("incidents", incidents);
		String urlVue = "addincident.jsp";
		request.getRequestDispatcher(urlVue).forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost");
		String urlVue = "resultlisthero.jsp";
		
		if(request.getParameter("submit_add_incident") != null){
			String city = request.getParameter("city");
			GPSCoordinates gpsVille = GPSCoordinates.getGpsCoordinatesByAddress(city);
			double latitude = gpsVille.getLatitude().doubleValue(); 
			double longitude =  gpsVille.getLongitude().doubleValue();
			String id_type_incident = request.getParameter("incident");  
			int id_incident = Integer.parseInt(id_type_incident);
			Incident incident = new Incident(city, longitude, latitude, id_incident);
			incidentRepository.create(incident);
			
			
			
			
			ArrayList<Hero> heros = heroRepository.findHerosDispo(latitude, longitude, id_type_incident);
			request.setAttribute("heros", heros);
			urlVue = "resultlisthero.jsp";
			System.out.println(heros);
		}
		
		request.getRequestDispatcher(urlVue).forward(request, response); 
	
	}
	


}
