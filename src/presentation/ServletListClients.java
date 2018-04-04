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
import persistance.ConseillerDaoImpl;
import persistance.IConseillerDao;
import services.ClientServicesImpl;
import services.ConseillerServicesImpl;
import services.IClientServices;
import services.IConseillerServices;

/**
 * Servlet permettant l'affichage de la liste des clients pour le conseiller logué
 * @author AAC/ARE
 * @version 2.0
 */

@WebServlet("/ServletListClients")
public class ServletListClients extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListClients() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("flogin");
		String password = request.getParameter("fpwd");
		HttpSession session = request.getSession();
		
		// 1. Récupérer l'id du conseiller qui vient d'être saisi
		IConseillerServices serviceConseiller = new ConseillerServicesImpl();

		int idConseiller = serviceConseiller.rechercherIdConseiller(login, password);
		session.setAttribute("sNomConseiller", idConseiller);

		// 2. Récupérer les clients de ce conseiller
		IClientServices serviceClient = new ClientServicesImpl();
		List<Client> listClientDeCeConseiller = serviceClient.chercherLesClients(idConseiller);
	
		// 3. Afficher la liste des clients pour ce conseiller dans la JSP
		session.setAttribute("sListClients", listClientDeCeConseiller);
		
		RequestDispatcher dispatcher = null;
		dispatcher = request.getRequestDispatcher("/WEB-INF/results/listeClientsParConseiller.jsp");
		dispatcher.forward(request, response);
		
	}

}
