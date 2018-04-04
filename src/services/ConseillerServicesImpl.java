package services;

import persistance.ConseillerDaoImpl;
import persistance.IConseillerDao;

/**
 * Implémentation de l'interface IConseillerServices
 * @author AAC/ARE
 * @version 2.0
 */

public class ConseillerServicesImpl implements IConseillerServices {

	private IConseillerDao daoConseiller = new ConseillerDaoImpl();

	@Override
	public int rechercherIdConseiller(String login, String password) {
		return daoConseiller.findConseiller(login, password);
	}
}
