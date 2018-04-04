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
 * Servlet permettant l'affichage du détail pour un client
 * @author AAC/ARE
 * @version 2.0
 */


@WebServlet("/ServletDetailClient")
public class ServletDetailClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDetailClient() {
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
		Client clientAAfficher = null;

		try {
			clientAAfficher = serviceClient.rechercheClient(Integer.parseInt(idClient));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		// 2. Affichage du client dans la JSP pour modification
		HttpSession session = request.getSession();
		session.setAttribute("sClient", clientAAfficher);

		RequestDispatcher dispatcher = null;
		dispatcher = request.getRequestDispatcher("/WEB-INF/results/editionClient.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		dispatcher = request.getRequestDispatcher("/WEB-INF/results/editionClient.jsp");
		dispatcher.forward(request, response);
	}

}
