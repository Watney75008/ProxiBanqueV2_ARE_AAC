package services;

import java.util.List;

import metier.Client;

public interface IClientServices {
	public List<Client> chercherLesClients(int idDuConseillerSaisi);
	public void miseAJourClient (Client clientAMAJ);
	public Client rechercheClient(int idClient);
}
