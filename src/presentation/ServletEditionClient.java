package presentation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletEditionClient
 */
@WebServlet("/ServletEditionClient")
public class ServletEditionClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEditionClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String nom1 = request.getParameter("${clientEnCours.nom}");
//		String prenom1 = request.getParameter("${clientEnCours.prenom}");
//		String email1 = request.getParameter("${clientEnCours.email}");
		
		RequestDispatcher dispatcher = null;
		dispatcher = request.getRequestDispatcher("/WEB-INF/results/editionClient.jsp");
		dispatcher.forward(request, response);
	}

}
