package persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.Client;

public class ClientDaoImpl extends DaoJDBC implements IClientDao {

	@Override
	public List<Client> findAllClient(int idDuConseillerSaisi) {
		Connection cnx = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Client> listClientsDuConseiller = new ArrayList<>();
		
		try {
            cnx = seConnecter();
            String maRequete = "SELECT cl.idclient a, cl.nom b, cl.prenom c, cl.adresse d, cl.ville e, cl.email f "
            					+ " FROM client cl, conseiller co"
            					+ " WHERE cl.idConseiller = co.idConseiller"
            					+ " AND cl.idConseiller = ?";
            pstmt = cnx.prepareStatement(maRequete);
            pstmt.setInt(1,idDuConseillerSaisi);
            rset = pstmt.executeQuery();

            int idClient;
            String nom;
            String prenom;
            String adresse;
            String ville;
            String email;
            
            while (rset.next()) {
                idClient = rset.getInt("a");
                nom = rset.getString("b");
                prenom = rset.getString("c");
                adresse = rset.getString("d");
                ville = rset.getString("e");
                email = rset.getString("f");

                Client c = new Client(idClient, nom, prenom, adresse, ville, email);
                listClientsDuConseiller.add(c);
			}
		
		} catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
        	seDeconnecter(cnx, pstmt, rset);
		}

		return listClientsDuConseiller;
	}

	@Override
	public void updateClient(Client clientAMAJ) {

	}

	@Override
	public Client findClient(int idClient) {
		return null;
	}

}
