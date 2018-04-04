package persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.Client;

/**
 * Dao Client
 * @author AAC/ARE
 * @version 2.0
 */

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
					+ " FROM client cl, conseiller co" + " WHERE cl.idConseiller = co.idConseiller"
					+ " AND cl.idConseiller = ?";
			pstmt = cnx.prepareStatement(maRequete);
			pstmt.setInt(1, idDuConseillerSaisi);
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
		Connection cnx = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
        try {
            String requeteUpdate = "UPDATE client SET nom=?, prenom=?, adresse=?, ville=?, email=? WHERE idclient = ?";
            cnx = seConnecter();
			pstmt = cnx.prepareStatement(requeteUpdate);
            pstmt.setString(1, clientAMAJ.getNom());
            pstmt.setString(2, clientAMAJ.getPrenom());
            pstmt.setString(3, clientAMAJ.getAdresse());
            pstmt.setString(4, clientAMAJ.getVille());
            pstmt.setString(5, clientAMAJ.getEmail());
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			seDeconnecter(cnx, pstmt, rset);
		}
	}

	@Override
	public Client findClient(int idClient) {
		Connection cnx = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		Client clientCherche = null;

		try {
			cnx = seConnecter();
			String maRequete = "SELECT cl.nom a, cl.prenom b, cl.adresse c, cl.ville d, cl.email e " + " FROM client cl"
					+ " WHERE cl.idClient = ?";
			pstmt = cnx.prepareStatement(maRequete);
			pstmt.setInt(1, idClient);
			rset = pstmt.executeQuery();

			String nom;
			String prenom;
			String adresse;
			String ville;
			String email;

			while (rset.next()) {
				nom = rset.getString("a");
				prenom = rset.getString("b");
				adresse = rset.getString("c");
				ville = rset.getString("d");
				email = rset.getString("e");

				clientCherche = new Client(idClient, nom, prenom, adresse, ville, email);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			seDeconnecter(cnx, pstmt, rset);
		}

		return clientCherche;
	}

}
