package br.com.abasteceaqui.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.abasteceaqui.model.entidades.Cupom;
import br.com.abasteceaqui.model.implementacao.CupomDaoImpl;

@SuppressWarnings("serial")
@ManagedBean
@SessionScoped
public class CupomController implements Serializable {

	private CupomDaoImpl cupomDaoImpl = null;
	private Cupom cupom;
	private Cupom selectedCupom;

	public CupomController() {
		this.cupomDaoImpl = new CupomDaoImpl();
	}

	public void salvar() {
		cupomDaoImpl.salvar(this.cupom);
	}

	public Cupom buscarPorCodigo(Integer codigo) {
		return cupomDaoImpl.buscarPorCodigo(codigo);
	}

	public Cupom buscarPorId(Integer id) {
		return cupomDaoImpl.buscarPorId(id);
	}

	public void alterar(Cupom cupom) {
		cupomDaoImpl.atualizar(cupom);
	}

	public void deletar(Cupom cupom) {
		cupomDaoImpl.deletar(cupom);
	}

	public List<Cupom> listarCupom() {
		return cupomDaoImpl.listar();
	}

	public Cupom getCupom() {
		return cupom;
	}

	public void setCupom(Cupom cupom) {
		this.cupom = cupom;
	}

	public Cupom getSelectedCupom() {
		return selectedCupom;
	}

	public void setSelectedCupom(Cupom selectedCupom) {
		this.selectedCupom = selectedCupom;
	}

}
