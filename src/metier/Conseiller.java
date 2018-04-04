package metier;

/**
 * 
 * @author AAC/ARE
 * @version 2.0
 * @category Classe métier Conseiller
 */

public class Conseiller {

	private int idConseiller;
	private String nom;
	private String prenom;
	private String login;
	private String password;
	
	/**
	 * @param idConseiller
	 * @param nom
	 * @param prenom
	 * @param login
	 * @param password
	 */
	// Constructeur
	public Conseiller(int idConseiller, String nom, String prenom, String login, String password) {
		this.idConseiller = idConseiller;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
	}

	// Getters et Setters
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getIdConseiller() {
		return idConseiller;
	}

	public void setIdConseiller(int idConseiller) {
		this.idConseiller = idConseiller;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
}
