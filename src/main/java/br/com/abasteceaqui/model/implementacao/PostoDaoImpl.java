package br.com.abasteceaqui.model.implementacao;

import java.util.List;

import br.com.abasteceaqui.model.dao.PersistenciaDAO;
import br.com.abasteceaqui.model.entidades.Posto;
import br.com.abasteceaqui.model.interfaces.InterfacePostoDao;

public class PostoDaoImpl extends PersistenciaDAO<Posto> implements InterfacePostoDao<Posto> {

	public Posto buscarPorCodigo(Integer codigo) {
		@SuppressWarnings("rawtypes")
		List lista = super.listar("SELECT p FROM Posto p WHERE p.id=" + codigo);

		if (!lista.isEmpty()) {
			return (Posto) lista.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Posto> listar() {
		return super.listar("SELECT p FROM Posto p");
	}

	public Posto buscarPorCnpj(String cnpj) {
		@SuppressWarnings("rawtypes")
		List lista = super.listar("SELECT p FROM Posto p WHERE p.cnpj=" + cnpj);

		if (!lista.isEmpty()) {
			return (Posto) lista.get(0);
		}
		return null;
	}

}