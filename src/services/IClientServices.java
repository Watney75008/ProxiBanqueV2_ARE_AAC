package services;

import java.util.List;

import metier.Client;

/**
 * Interface IClientServices
 * @author AAC/ARE
 * @version 2.0
 */

public interface IClientServices {
	public List<Client> chercherLesClients(int idDuConseillerSaisi);
	public void miseAJourClient (Client clientAMAJ);
	public Client rechercheClient(int idClient);
}
