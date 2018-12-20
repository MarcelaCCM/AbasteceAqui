package br.com.abasteceaqui.model.implementacao;

import java.util.List;

import br.com.abasteceaqui.model.dao.PersistenciaDAO;
import br.com.abasteceaqui.model.entidades.Frentista;
import br.com.abasteceaqui.model.interfaces.InterfaceFrentistaDao;

public class FrentistaDaoImpl extends PersistenciaDAO<Frentista> implements InterfaceFrentistaDao<Frentista> {

	public Frentista buscarPorCodigo(Integer codigo) {
		@SuppressWarnings("rawtypes")
		List lista = super.listar("SELECT f FROM Frentista f WHERE f.id=" + codigo);

		if (!lista.isEmpty()) {
			return (Frentista) lista.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Frentista> listar() {
		return super.listar("SELECT f FROM Frentista f");
	}

	public Frentista buscarPorCpf(String cpf) {
		@SuppressWarnings("rawtypes")
		List lista = super.listar("SELECT f FROM Frentista f WHERE f.cpf=" + cpf);

		if (!lista.isEmpty()) {
			return (Frentista) lista.get(0);
		}
		return null;
	}

	public Frentista login(String login, String senha) {
		return (Frentista) super.autenticar("SELECT a FROM Frentista a", login, senha);

	}
}