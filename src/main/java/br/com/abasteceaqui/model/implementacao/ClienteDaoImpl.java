package br.com.abasteceaqui.model.implementacao;

import java.util.List;

import br.com.abasteceaqui.model.dao.PersistenciaDAO;
import br.com.abasteceaqui.model.entidades.Cliente;
import br.com.abasteceaqui.model.interfaces.InterfaceClienteDao;

public class ClienteDaoImpl extends PersistenciaDAO<Cliente> implements InterfaceClienteDao<Cliente> {

	public Cliente buscarPorCodigo(Integer codigo) {
		@SuppressWarnings("rawtypes")
		List lista = super.listar("SELECT c FROM Cliente c WHERE c.id=" + codigo);

		if (!lista.isEmpty()) {
			return (Cliente) lista.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> listar() {
		return super.listar("SELECT c FROM Cliente c");
	}

	public Cliente buscarPorCnpj(String cnpj) {
		@SuppressWarnings("rawtypes")
		List lista = super.listar("SELECT c FROM Cliente c WHERE c.cnpj=" + cnpj);

		if (!lista.isEmpty()) {
			return (Cliente) lista.get(0);
		}
		return null;
	}

	public Cliente login(String login, String senha) {
		return (Cliente) super.autenticar("SELECT a FROM Cliente a", login, senha);

	}

	public void close() {
		super.close();
	}

}
