package metier;

/**
 * 
 * @author AAC/ARE
 * @version 2.0
 * @category Classe métier Client
 */

public class Client {

	private int idClient;
	private String nom;
	private String prenom;
	private String adresse;
	private String ville;
	private String email;

	/**
	 * 
	 * @param idClient
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param ville
	 * @param email
	 */
	// Constructeur
	public Client(int idClient, String nom, String prenom, String adresse, String ville, String email) {
		this(nom, prenom, adresse, ville, email);
		this.idClient = idClient;
	}

	public Client(String nom, String prenom, String adresse, String ville, String email) {
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.ville = ville;
		this.email = email;
	}

	public Client() {
	}
	// getters et Setters
	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
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

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}
