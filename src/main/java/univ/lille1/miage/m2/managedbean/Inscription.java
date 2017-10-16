package univ.lille1.miage.m2.managedbean;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import univ.lille1.miage.m2.service.MetierPersonnes;

@ManagedBean(name = "inscription")
@SessionScoped
public class Inscription {

	private String nom;
	private String prenom;
	private String login;
	private String password;
	private boolean droitImage;
	private Date dateDeNaissance;
	private int civilite;

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

	public boolean getDroitImage() {
		return droitImage;
	}

	public void setDroitImage(boolean droitImage) {
		this.droitImage = droitImage;
	}

	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public int getCivilite() {
		return civilite;
	}

	public void setCivilite(int civilite) {
		this.civilite = civilite;
	}

	public long getAge() {
		return getTimeDiff(new Date(), this.dateDeNaissance);
//		return 10;
	}

	public long getTimeDiff(Date dateOne, Date dateTwo) {
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		
		c1.setTime(dateOne);
		c2.setTime(dateTwo);
		return c1.get(Calendar.YEAR) - c2.get(Calendar.YEAR);
	}

	public String validate() {
		if (MetierPersonnes.getPersonne(login, password) == null) {
			MetierPersonnes.inscription(login, password, nom, prenom, droitImage, dateDeNaissance, civilite, getAge());
			return "success";
		}

		return "error";
	}

}
