package persistance;

import metier.Compte;

/**
 * Interface ICompteDao
 * @author AAC/ARE
 * @version 2.0
 */

public interface ICompteDao {
	public double virementCompteACompte(Compte compteSource, Compte compteDestinataire);
}
