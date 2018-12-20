package br.com.abasteceaqui.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import br.com.abasteceaqui.model.entidades.Cliente;
import br.com.abasteceaqui.model.implementacao.ClienteDaoImpl;

@ManagedBean
@SessionScoped
public class LoginClienteController implements Serializable {

	private Cliente clienteLogado = null;
	private String login;
	private String senha;

	public LoginClienteController() {
	}

	public Cliente getClienteLogado() {
		return clienteLogado;
	}

	public void setClienteLogado(Cliente clienteLogado) {
		this.clienteLogado = clienteLogado;
	}

	public String loginCliente() {
		ClienteDaoImpl clienteImpl = new ClienteDaoImpl();
		clienteLogado = clienteImpl.login(this.login, this.senha);
		if (clienteLogado != null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Você esta Logado!"));
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("clienteLogado",
					this.clienteLogado);
			return "perfilCliente.xhtml?faces-redirect=true";
		}

		return "index.xhtml";
	}

	public String logout() {

		this.clienteLogado = null;

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
		return "loginCliente.xhtml?faces-redirect=true";
	}

	public String linkCadastrar() {
		return "cadastrarCliente.xhtml?faces-redirect=true";

	}
}
