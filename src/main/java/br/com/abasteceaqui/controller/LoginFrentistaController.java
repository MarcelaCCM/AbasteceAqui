package br.com.abasteceaqui.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.abasteceaqui.model.entidades.Frentista;
import br.com.abasteceaqui.model.implementacao.FrentistaDaoImpl;

@ManagedBean
@SessionScoped
public class LoginFrentistaController implements Serializable {

	private Frentista frentistaLogado = null;
	private String login;
	private String senha;

	public LoginFrentistaController() {
	}

	public Frentista getFrentistaLogado() {
		return frentistaLogado;
	}

	public void setFrentistaLogado(Frentista frentistaLogado) {
		this.frentistaLogado = frentistaLogado;
	}

	public String loginFrentista() {
		FrentistaDaoImpl frentistaImpl = new FrentistaDaoImpl();
		frentistaLogado = frentistaImpl.login(this.login, this.senha);
		if (frentistaLogado != null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Você esta Logado!"));
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("frentistaLogado",
					this.frentistaLogado);
			return "perfilFrentista.xhtml?faces-redirect=true";
		}

		return "index.xhtml";
	}

	public String logout() {

		this.frentistaLogado = null;

		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

		return "";
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String linkLogin() {
		return "loginFrentista.xhtml?faces-redirect=true";
	}
	
	public String linkCadastrar() {
		return "cadastrarFrentista.xhtml?faces-redirect=true";
	}

}
