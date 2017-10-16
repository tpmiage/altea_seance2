package univ.lille1.miage.m2.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import univ.lille1.miage.m2.service.MetierPersonnes;

@ManagedBean(name="loginbean")
@SessionScoped
public class Login {
	
	private String login;
	private String password;
	
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
		return MetierPersonnes.getPersonne(login, password) != null ? "success" : "error";
	}
	
}
