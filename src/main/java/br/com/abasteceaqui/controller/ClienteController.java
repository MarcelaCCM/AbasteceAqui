package br.com.abasteceaqui.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.abasteceaqui.model.entidades.Cliente;
import br.com.abasteceaqui.model.implementacao.ClienteDaoImpl;
import br.com.abasteceaqui.util.Excecoes;

@SuppressWarnings("serial")
@ManagedBean
@SessionScoped
public class ClienteController implements Serializable {

	private ClienteDaoImpl clienteDaoImpl = null;
	private Cliente cliente;
	private Cliente selectedCliente;
	 

	public ClienteController() {
		this.clienteDaoImpl = new ClienteDaoImpl();
		limpar();
		this.selectedCliente = (Cliente) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("clienteLogado");
	}

	public void salvar() throws Excecoes {
		try {
			if (cliente != null)
				clienteDaoImpl.salvar(cliente);
		} catch (Exception e) {
			throw new Excecoes("Error ao Salvar");
		}
		limpar();
	}

	public void limpar() {
		this.cliente = new Cliente();
	}

	public Cliente buscarPorCodigo(Integer codigo) {
		return clienteDaoImpl.buscarPorCodigo(codigo);
	}

	public Cliente buscarPorCnpj(Integer codigo) {
		return clienteDaoImpl.buscarPorCodigo(codigo);
	}

	public void alterar() {
		clienteDaoImpl.atualizar(this.selectedCliente);
	}

	public void deletar(Cliente cliente) {
		clienteDaoImpl.deletar(cliente);
	}

	public List<Cliente> listarCliente() {
		return clienteDaoImpl.listar();
	}

	public ClienteDaoImpl getClienteDaoImpl() {
		return clienteDaoImpl;
	}

	public void setClienteDaoImpl(ClienteDaoImpl clienteDaoImpl) {
		this.clienteDaoImpl = clienteDaoImpl;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
		
	public Cliente getSelectedCliente() {
		return selectedCliente;
	}
	
	public void setSelectedCliente(Cliente selectedCliente) {
		this.selectedCliente = selectedCliente;
	}
	
	public void close() {
		this.clienteDaoImpl.close();

	}
	
	public String linkAlterar(){
		return "alterarCliente.xhtml?faces-redirect=true";
}
	
	public String linkSair() {
		return "perfilCliente.xhtml?faces-redirect=true";
	}
}
