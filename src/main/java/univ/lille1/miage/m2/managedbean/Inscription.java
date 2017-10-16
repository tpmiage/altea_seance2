package univ.lille1.miage.m2.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import univ.lille1.miage.m2.service.MetierPersonnes;

@ManagedBean(name="inscription")
@SessionScoped
public class Inscription {
	
	private String nom;
	private String prenom;
	private String login;
	private String password;
	
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

	public String validate() {
		if(MetierPersonnes.getPersonne(login, password) == null) {
			MetierPersonnes.inscription(login, password, nom, prenom);
			return "success";
		}
		
		return "error";
	}
	
}
