package br.com.abasteceaqui.teste;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.abasteceaqui.controller.UsuarioController;
import br.com.abasteceaqui.model.entidades.Endereco;
import br.com.abasteceaqui.model.entidades.Usuario;
import br.com.abasteceaqui.model.implementacao.UsuarioDaoImpl;
import br.com.abasteceaqui.util.Excecoes;

public class TesteUsuario {

	private static int codigoUsuario = 0;

	@BeforeClass
	public static void deveSalvarUmUsuarioTest() throws Excecoes  {

		Usuario usuario = new Usuario();
		usuario.setNome("Marcela");
		usuario.setCpfUsuario("22222222222");
		usuario.setFone("22222222");

		Endereco endereco = new Endereco();
		endereco.setRua("Av Caruaru");
		endereco.setNumero("50");
		endereco.setBairro("Vila do Quartel");
		endereco.setCidade("Garanhuns");
		endereco.setCep("casa");

		usuario.setEndereco(endereco);

		UsuarioDaoImpl repUsuario = new UsuarioDaoImpl();
		repUsuario.salvar(usuario);

		List<Usuario> usuarios = repUsuario.listar();

		for (Usuario lista : usuarios) {
			if (lista.getNome().equals("Marcela")) {
				codigoUsuario = lista.getId();
			}
		}

		Usuario usuario2 = repUsuario.buscarPorCodigo(codigoUsuario);
		Assert.assertEquals("Marcela", usuario2.getNome());
	}

	@Test
	public void deveBuscaUsuarioPorCodigoTest() {
		UsuarioController repUsuario = new UsuarioController();
		Usuario usuario = repUsuario.buscarPorCodigo(codigoUsuario);

		boolean existe = usuario != null ? true : false;
		Assert.assertTrue(existe);
	}

	@Test
	public void deveAlterarDadosDaUsuarioTest() {
		UsuarioController repUsuario = new UsuarioController();
		Usuario usuario = repUsuario.buscarPorCodigo(codigoUsuario);
		usuario.setNome("Marcelo");

		//repUsuario.alterar(usuario);

		Usuario alteracaoDoUsuario = repUsuario.buscarPorCodigo(codigoUsuario);

		Assert.assertEquals("Marcelo", alteracaoDoUsuario.getNome());
	}

	@AfterClass
	public static void deveDeletarUsuarioTest() {
		UsuarioController repUsuario = new UsuarioController();
		Usuario usuario = repUsuario.buscarPorCodigo(codigoUsuario);
		repUsuario.deletar(usuario);
	}

}
