package persistance;

/**
 * Interface IConseillerDao
 * @author AAC/ARE
 * @version 2.0
 */

import metier.Conseiller;

public interface IConseillerDao {
	public int findConseiller(String login, String password);
}
