package persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class DaoJDBC {
	private static String login = "root";
	private static String password = "";

	public static Connection seConnecter() throws ClassNotFoundException, SQLException {
		// Chargement Driver
		Class.forName("com.mysql.jdbc.Driver");
		// Création d'une Connection
		Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost/ProxiBanqueV2", login, password);
		return cnx;
	}

	public static void seDeconnecter(Connection cnx, PreparedStatement st, ResultSet rs) {

		try {
			if (cnx != null) cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (st != null) st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (rs != null) rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Getters et setters
	public static String getLogin() {
		return login;
	}

	public static void setLogin(String login) {
		DaoJDBC.login = login;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		DaoJDBC.password = password;
	}

}
