package presentation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import services.ConseillerServicesImpl;
import services.IConseillerServices;

/**
 * Servlet permettant la validation de la connection au portail
 * @author AAC/ARE
 * @version 2.0
 */

@WebServlet("/ServletDispatch")
public class ServletDispatch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDispatch() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dispatchApresAuthentification(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dispatchApresAuthentification(request, response);		
	}


	private void dispatchApresAuthentification(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Récupération des paramètres de la requête
		String login = request.getParameter("flogin");
		String password = request.getParameter("fpwd");
		HttpSession maSession = request.getSession();
		maSession.setAttribute("slogin", login);
		maSession.setAttribute("spwd", password);
		
		RequestDispatcher dispatcher = null;

		// 1. Champs non saisis
		if (login == null || login.equals("") || password == null || password.equals("")) {
			dispatcher = request.getRequestDispatcher("/WEB-INF/results/erreur.jsp");
			dispatcher.forward(request, response);
		} else {
			// 2. Champs saisis : on récupère l'id du conseiller saisi
			IConseillerServices serviceConseiller = new ConseillerServicesImpl();
			int idConseiller = serviceConseiller.rechercherIdConseiller(login, password);
			maSession.setAttribute("sNomConseiller", idConseiller);

			// 2.1. Le conseiller n'existe pas
			if (idConseiller == 0) {
				dispatcher = request.getRequestDispatcher("/WEB-INF/results/erreur.jsp");
				dispatcher.forward(request, response);
			} else {
				// 2.2. Le conseiller existe ==> affichage de la liste de ses clients
				ServletListClients slc = new ServletListClients();
				slc.doPost(request, response);
			}
		}
	}
}
