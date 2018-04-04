package persistance;

import java.util.List;

import metier.Client;

/**
 * Interface IClientDao
 * @author AAC/ARE
 * @version 2.0
 */

public interface IClientDao {
	public List<Client> findAllClient(int idDuConseillerSaisi);
	public void updateClient (Client clientAMAJ);
	public Client findClient(int idClient);

}
