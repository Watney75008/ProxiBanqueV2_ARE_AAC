package presentation;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.Client;
import services.ClientServicesImpl;
import services.ConseillerServicesImpl;
import services.IClientServices;
import services.IConseillerServices;

/**
 * Servlet permettant de modifier les informations d'un client
 * @author AAC/ARE
 * @version 2.0
 */

@WebServlet("/ServletModifierClient")
public class ServletModifierClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletModifierClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Récupération du client depuis la base
		String idClient = request.getParameter("idClient");
		IClientServices serviceClient = new ClientServicesImpl();
		Client clientAModifier = null;

		try {
			clientAModifier = serviceClient.rechercheClient(Integer.parseInt(idClient));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		RequestDispatcher dispatcher = null;
		HttpSession session = request.getSession();

		// 3. Traitement des modifications éventuelles du client
		String nomModifie = null;
		String prenomModifie = null;
		String adresseModifie = null;
		String villeModifie = null;
		String emailModifie = null;
		
		if (request.getParameter("fnom") != null && !(request.getParameter("fnom").equals(""))) {
			nomModifie = request.getParameter("fnom");
			clientAModifier.setNom(nomModifie);
		}
		
		if (request.getParameter("fprenom") != null && !(request.getParameter("fprenom").equals(""))) {
			prenomModifie = request.getParameter("fprenom");
			clientAModifier.setPrenom(prenomModifie);
		}

		if (request.getParameter("fadresse") != null && !(request.getParameter("fadresse").equals(""))) {
			adresseModifie = request.getParameter("fadresse");
			clientAModifier.setAdresse(adresseModifie);
		}

		if (request.getParameter("fville") != null && !(request.getParameter("fville").equals(""))) {
			villeModifie = request.getParameter("fville");
			clientAModifier.setVille(villeModifie);
		}

		if (request.getParameter("femail") != null && !(request.getParameter("femail").equals(""))) {
			emailModifie = request.getParameter("femail");
			clientAModifier.setEmail(emailModifie);
		}

		serviceClient.miseAJourClient(clientAModifier);
		
//		session.setAttribute("sClientModifie", clientAModifier);
		
		dispatcher = request.getRequestDispatcher("./WEB-INF/results/editionClient.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		dispatcher = request.getRequestDispatcher("./WEB-INF/results/editionClient.jsp");
		dispatcher.forward(request, response);
	}

}
