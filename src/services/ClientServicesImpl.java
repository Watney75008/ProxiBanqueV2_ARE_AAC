package services;

import java.util.List;

import metier.Client;
import persistance.ClientDaoImpl;
import persistance.IClientDao;

/**
 * Implémentation de l'interface IClientServices
 * @author AAC/ARE
 * @version 2.0
 */

public class ClientServicesImpl implements IClientServices {

	private IClientDao daoClient = new ClientDaoImpl();

	@Override
	public List<Client> chercherLesClients(int idDuConseillerSaisi) {
		return daoClient.findAllClient(idDuConseillerSaisi);
	}

	@Override
	public void miseAJourClient(Client clientAMAJ) {
		daoClient.updateClient(clientAMAJ);
	}

	@Override
	public Client rechercheClient(int idClient) {
		return daoClient.findClient(idClient);
	}

}
