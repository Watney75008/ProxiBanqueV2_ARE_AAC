package services;

import persistance.ConseillerDaoImpl;
import persistance.IConseillerDao;

public class ConseillerServicesImpl implements IConseillerServices {

	private IConseillerDao daoConseiller = new ConseillerDaoImpl();

	@Override
	public int rechercherIdConseiller(String login, String password) {
		return daoConseiller.findConseiller(login, password);
	}
}
