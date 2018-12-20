package br.com.abasteceaqui.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.abasteceaqui.model.entidades.Posto;
import br.com.abasteceaqui.model.implementacao.PostoDaoImpl;
import br.com.abasteceaqui.util.Excecoes;


@SuppressWarnings("serial")
@ManagedBean
@SessionScoped
public class PostoController implements Serializable {
	private Posto posto;
	private Posto selectedPosto;
	private PostoDaoImpl postoDaoImpl = null;

	public PostoController() {
		this.postoDaoImpl = new PostoDaoImpl();
		posto = new Posto();
	}

	public void salvar() throws Excecoes {
		try {
			if (posto != null)
				postoDaoImpl.salvar(posto);
		} catch (Exception e) {
			throw new Excecoes("Error ao Salvar");
		}
		limpar();
	}

	public void limpar() {
		posto = new Posto();
	}

	public Posto buscarPorCodigo(Integer codigo) {
		return postoDaoImpl.buscarPorCodigo(codigo);
	}

	public Posto buscarPorCnpj(Integer codigo) {
		return postoDaoImpl.buscarPorCodigo(codigo);
	}

	public void alterar() {
		postoDaoImpl.atualizar(this.selectedPosto);
	}

	public void deletar() {
		postoDaoImpl.deletar(this.selectedPosto);
	}

	public List<Posto> listarPosto() {
		return postoDaoImpl.listar();
	}

	public PostoDaoImpl getPostoDaoImpl() {
		return postoDaoImpl;
	}

	public void setPostoDaoImpl(PostoDaoImpl postoDaoImpl) {
		this.postoDaoImpl = postoDaoImpl;
	}

	public Posto getPosto() {
		return posto;
	}

	public void setPosto(Posto posto) {
		this.posto = posto;
	}
	
	public Posto getSelectedPosto() {
		return selectedPosto;
	}
	
	public void setSelectedPosto(Posto selectedPosto) {
		this.selectedPosto = selectedPosto;
	}

	public void close() {
		this.postoDaoImpl.close();

	}
	
	public String linkListarPostos() {
		return "listar-postos.xhtml?faces-redirect=true";
		
	}
		public String linkCadastrarPosto() {
			return "cadastrarPosto.xhtml?faces-redirect=true";
	}
	
}

