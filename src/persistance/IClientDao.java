package persistance;

import java.util.List;

import metier.Client;

public interface IClientDao {
	public List<Client> findAllClient(int idDuConseillerSaisi);
	public void updateClient (Client clientAMAJ);
	public Client findClient(int idClient);

}
