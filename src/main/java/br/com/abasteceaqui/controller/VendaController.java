package br.com.abasteceaqui.controller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.abasteceaqui.model.entidades.Venda;
import br.com.abasteceaqui.model.implementacao.VendaDaoImpl;

@ManagedBean
@SessionScoped
public class VendaController implements Serializable  {
	
	private VendaDaoImpl vendaDaoImpl = null;
	private Venda venda;
	private Venda selectedVenda;

	public VendaController() {
		this.vendaDaoImpl = new VendaDaoImpl();
		this.venda = new Venda();
		
	}

	public void salvar() {
		vendaDaoImpl.salvar(venda);
		this.venda = new Venda();
	}

	public Venda buscarPorCodigo(Integer codigo) {
		return vendaDaoImpl.buscarPorCodigo(codigo);
	}

	public Venda buscarPorId(Integer id) {
		return vendaDaoImpl.buscarPorId(id);
	}

	public void alterar(Venda venda) {
		vendaDaoImpl.atualizar(venda);
	}

	public void deletar(Venda venda) {
		vendaDaoImpl.deletar(venda);
	}

	public List<Venda> listarVenda() {
		return vendaDaoImpl.listar();
	}
	
	public Venda getVenda() {
		return venda;
	}
	
	public void setVenda(Venda venda) {
		this.venda = venda;
	}
	
	public Venda getSelectedVenda() {
		return selectedVenda;
	}
	
	public void setSelectedVenda(Venda selectedVenda) {
		this.selectedVenda = selectedVenda;
	}
	
	public String total() {
		BigDecimal desconto = new BigDecimal(venda.getDesconto());
		return venda.getValor().subtract(venda.getCupom().getValorDesconto()).toString();
	}
	public String linkVenda(){
		return "venda.xhtml?faces-redirect=true";
		
	}
}
