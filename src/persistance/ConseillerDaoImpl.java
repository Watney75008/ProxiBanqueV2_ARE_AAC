package persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Dao Conseiller
 * @author AAC/ARE
 * @version 2.0
 */

public class ConseillerDaoImpl extends DaoJDBC implements IConseillerDao {

	@Override
	public int findConseiller(String login, String password) {
		Connection cnx = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
        int idConseiller = 0;
        
		try {
            cnx = seConnecter();
            String maRequete = "SELECT co.idConseiller"
            					+ " FROM conseiller co"
            					+ " WHERE co.login = ?"
            					+ " AND co.password = ?";
            pstmt = cnx.prepareStatement(maRequete);
            pstmt.setString(1,login);
            pstmt.setString(2,password);
            rset = pstmt.executeQuery();
            
            while (rset.next()) {
                idConseiller = rset.getInt("idConseiller");
			}
		} catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
        	seDeconnecter(cnx, pstmt, rset);
		}

		return idConseiller;
	}

}
