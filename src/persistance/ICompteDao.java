package persistance;

import metier.Compte;

public interface ICompteDao {
	public double virementCompteACompte(Compte compteSource, Compte compteDestinataire);
}
