package br.com.abasteceaqui.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.abasteceaqui.model.entidades.Usuario;
import br.com.abasteceaqui.model.implementacao.UsuarioDaoImpl;
import br.com.abasteceaqui.util.Excecoes;


@SuppressWarnings("serial")
@ManagedBean
@SessionScoped
public class UsuarioController implements Serializable {

	private UsuarioDaoImpl usuarioDaoImpl = null;
	private Usuario usuario;
	private Usuario selectedUsuario;

	public UsuarioController() {
		this.usuarioDaoImpl = new UsuarioDaoImpl();
		limpar();
		this.selectedUsuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioLogado");

		
	}

	public void salvar() throws Excecoes {
		try {
			if (usuario != null)
				usuarioDaoImpl.salvar(usuario);
		} catch (Exception e) {
			throw new Excecoes("Error ao Salvar");
		}
		limpar();
	}
	public void limpar() {
		usuario = new Usuario();
	}

	public Usuario buscarPorCodigo(Integer codigo) {
		return usuarioDaoImpl.buscarPorCodigo(codigo);
	}

	public Usuario buscarPorCpf(Integer codigo) {
		return usuarioDaoImpl.buscarPorCodigo(codigo);
	}

	public void alterar() {
		usuarioDaoImpl.atualizar(this.selectedUsuario);
	}

	public void deletar(Usuario usuario) {
		usuarioDaoImpl.deletar(usuario);
	}

	public List<Usuario> listarUsuario() {
		return usuarioDaoImpl.listar();
	}

	public UsuarioDaoImpl getUsuarioDaoImpl() {
		return usuarioDaoImpl;
	}

	public void setUsuarioDaoImpl(UsuarioDaoImpl usuarioDaoImpl) {
		this.usuarioDaoImpl = usuarioDaoImpl;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Usuario getSelectedUsuario() {
		return selectedUsuario;
	}
	
	public void setSelectedUsuario(Usuario selectedUsuario) {
		this.selectedUsuario = selectedUsuario;
	}
	
	public String linkAlterar(){
		return "alterarUsuario.xhtml?faces-redirect=true";
	}

}
