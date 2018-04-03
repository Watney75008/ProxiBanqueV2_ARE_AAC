package services;

import java.util.List;

import metier.Client;
import persistance.ClientDaoImpl;
import persistance.IClientDao;

public class ClientServicesImpl implements IClientServices {

	private IClientDao daoClient = new ClientDaoImpl();

	@Override
	public List<Client> chercherLesClients(int idDuConseillerSaisi) {
		return daoClient.findAllClient(idDuConseillerSaisi);
	}

	@Override
	public void miseAJourClient(Client clientAMAJ) {

	}

	@Override
	public Client rechercheClient(int idClient) {
		return null;
	}

}
