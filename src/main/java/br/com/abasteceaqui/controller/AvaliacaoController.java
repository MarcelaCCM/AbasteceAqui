package br.com.abasteceaqui.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.abasteceaqui.model.entidades.Avaliacao;
import br.com.abasteceaqui.model.implementacao.AvaliacaoDaoImpl;
import br.com.abasteceaqui.util.Excecoes;

@SuppressWarnings("serial")
@ManagedBean
@SessionScoped
public class AvaliacaoController implements Serializable {

	private AvaliacaoDaoImpl avaliacaoDaoImpl = null;
		private Avaliacao avaliacao;
	

	public AvaliacaoController() {
		this.avaliacaoDaoImpl = new AvaliacaoDaoImpl();
	}

	public void salvar() throws Excecoes {
		try {
			if (avaliacao != null)
				avaliacaoDaoImpl.salvar(avaliacao);
		} catch (Exception e) {
			throw new Excecoes("Error ao Salvar");
		}
		limpar();
	}

	public void limpar() {
		this.avaliacao = new Avaliacao();
	}

	public Avaliacao buscarPorCodigo(Integer codigo) {
		return avaliacaoDaoImpl.buscarPorCodigo(codigo);
	}

	public Avaliacao buscarPorId(Integer id) {
		return avaliacaoDaoImpl.buscarPorId(id);
	}

	public void alterar(Avaliacao avaliacao) {
		avaliacaoDaoImpl.atualizar(avaliacao);
	}

	public void deletar(Avaliacao avaliacao) {
		avaliacaoDaoImpl.deletar(avaliacao);
	}

	public List<Avaliacao> listarAvaliacao() {
		return avaliacaoDaoImpl.listar();
	}
	
	public AvaliacaoDaoImpl getAvaliacaoDaoImpl() {
		return avaliacaoDaoImpl;
	}
	
	public void setAvaliacaoDaoImpl(AvaliacaoDaoImpl avaliacaoDaoImpl) {
		this.avaliacaoDaoImpl = avaliacaoDaoImpl;
	}
	
	public Avaliacao getAvaliacao() {
		return avaliacao;
	}
	
	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}
	
	public String linkAvaliarFrentista() {
		return "avaliacao.xhtml?faces-redirect=true";
	}
}
