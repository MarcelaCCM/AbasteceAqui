package br.com.abasteceaqui.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.abasteceaqui.model.entidades.Frentista;
import br.com.abasteceaqui.model.implementacao.FrentistaDaoImpl;
import br.com.abasteceaqui.util.Excecoes;

@SuppressWarnings("serial")
@ManagedBean
@SessionScoped

public class FrentistaController implements Serializable {
	
	private FrentistaDaoImpl frentistaDaoImpl = null;
	private Frentista frentista;
	private Frentista selectedFrentista;

	public FrentistaController() {
		this.frentistaDaoImpl = new FrentistaDaoImpl();
		this.selectedFrentista = (Frentista) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("frentistaLogado");
		limpar();
		
	}

	public void salvar() throws Excecoes {
		try {
			if (frentista != null)
				frentistaDaoImpl.salvar(frentista);
		} catch (Exception e) {
			throw new Excecoes("Error ao Salvar");
		}
		limpar();
	}

	public void limpar() {
		frentista = new Frentista();
	}
	public Frentista buscarPorCodigo(Integer codigo) {
		return frentistaDaoImpl.buscarPorCodigo(codigo);
	}

	public Frentista buscarPorCpf(Integer codigo) {
		return frentistaDaoImpl.buscarPorCodigo(codigo);
	}

	public void alterar() {
		frentistaDaoImpl.atualizar(this.selectedFrentista);
	}

	public void deletar(Frentista frentista) {
		frentistaDaoImpl.deletar(frentista);
	}

	public List<Frentista> listarFrentista() {
		return frentistaDaoImpl.listar();
	}

	public FrentistaDaoImpl getFrentistaDaoImpl() {
		return frentistaDaoImpl;
	}

	public void setFrentistaDaoImpl(FrentistaDaoImpl frentistaDaoImpl) {
		this.frentistaDaoImpl = frentistaDaoImpl;
	}

	public Frentista getFrentista() {
		return frentista;
	}

	public void setFrentista(Frentista frentista) {
		this.frentista = frentista;
	}
	
	public Frentista getSelectedFrentista() {
		return selectedFrentista;
	}
	
	public void setSelectedFrentista(Frentista selectedFrentista) {
		this.selectedFrentista = selectedFrentista;
	}

	public void close() {
		this.frentistaDaoImpl.close();

	}
	
	public String linkAlterar(){
		return "alterarFrentista.xhtml?faces-redirect=true";

}	
	
	public String linkListarFrentista(){
		return "listarFrentistas.xhtml?faces-redirect=true";
	}
}
