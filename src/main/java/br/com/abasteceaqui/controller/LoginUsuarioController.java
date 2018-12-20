package br.com.abasteceaqui.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import br.com.abasteceaqui.model.entidades.Usuario;
import br.com.abasteceaqui.model.implementacao.UsuarioDaoImpl;

@ManagedBean
@SessionScoped
public class LoginUsuarioController implements Serializable {

	private Usuario usuarioLogado = null;
	private String login;
	private String senha;

	public LoginUsuarioController() {
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public String loginUsuario() {
		UsuarioDaoImpl usuarioImpl = new UsuarioDaoImpl();
		usuarioLogado = usuarioImpl.login(this.login, this.senha);
		if (usuarioLogado != null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Você esta Logado!"));
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioLogado",this.usuarioLogado);
			return "perfilUsuario.xhtml?faces-redirect=true";
		}

		return "index.xhtml";
	}

	public String logout() {

		this.usuarioLogado = null;

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
		return "loginUsuario.xhtml?faces-redirect=true";
	}

	public String linkCadastrar() {
		return "cadastrarUsuario.xhtml?faces-redirect=true";
	}
}
