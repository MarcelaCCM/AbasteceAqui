package br.com.abasteceaqui.model.implementacao;

import java.util.List;

import br.com.abasteceaqui.model.dao.PersistenciaDAO;

import br.com.abasteceaqui.model.entidades.Usuario;
import br.com.abasteceaqui.model.interfaces.InterfaceUsuarioDao;

public class UsuarioDaoImpl extends PersistenciaDAO<Usuario> implements InterfaceUsuarioDao<Usuario> {

	public Usuario buscarPorCodigo(Integer codigo) {
		@SuppressWarnings("rawtypes")
		List lista = super.listar("SELECT u FROM Usuario u WHERE u.id=" + codigo);

		if (!lista.isEmpty()) {
			return (Usuario) lista.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> listar() {
		return super.listar("SELECT u FROM Usuario u");
	}

	public Usuario buscarPorCpf(String cpf) {
		@SuppressWarnings("rawtypes")
		List lista = super.listar("SELECT u FROM Usuario u WHERE u.cpf=" + cpf);

		if (!lista.isEmpty()) {
			return (Usuario) lista.get(0);
		}
		return null;
	}

	public Usuario login(String login, String senha) {
		return (Usuario) super.autenticar("SELECT a FROM Usuario a", login, senha);

	}
}
