package persistance;

import metier.Conseiller;

public interface IConseillerDao {
	public int findConseiller(String login, String password);
}
