package br.com.abasteceaqui.teste;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.abasteceaqui.controller.ClienteController;
import br.com.abasteceaqui.model.entidades.Cliente;
import br.com.abasteceaqui.model.entidades.Endereco;
import br.com.abasteceaqui.model.implementacao.ClienteDaoImpl;
import br.com.abasteceaqui.util.Excecoes;

public class TesteCliente {

	private static int codigoCliente = 0;

	@BeforeClass
	public static void deveSalvarUmClienteTest() throws Excecoes {
		Cliente cliente = new Cliente();
		cliente.setCnpjCliente("111111111111");
		cliente.setRazaoSocial("Marcela Cardoso");
		cliente.setFone("11111111");

		
		
		Endereco endereco = new Endereco();
		endereco.setRua("Orestes Barbosa");
		endereco.setNumero("100");
		endereco.setBairro("Heliopolis");
		endereco.setCidade("Garanhuns");
		endereco.setCep("55290000");

		cliente.setEndereco(endereco);

		ClienteDaoImpl repCliente = new ClienteDaoImpl();
		repCliente.salvar(cliente);

		List<Cliente> clientes = repCliente.listar();

		for (Cliente lista : clientes) {
			if (lista.getRazaoSocial().equals("Marcela Cardoso")) {
				codigoCliente = lista.getId();
			}
		}

		Cliente cliente2 = repCliente.buscarPorCodigo(codigoCliente);
		Assert.assertEquals("Marcela Cardoso", cliente2.getRazaoSocial());
		repCliente.close();

	}

	@Test
	public void deveListaTodasClientesTest() {
		ClienteController repCliente = new ClienteController();
		List<Cliente> lista = repCliente.listarCliente();

		boolean listou = lista.size() > 0;
		Assert.assertTrue(listou);
		repCliente.close();
	}

	@Test
	public void deveBuscaClientePorCodigoTest() {
		ClienteController repCliente = new ClienteController();
		Cliente cliente = repCliente.buscarPorCodigo(codigoCliente);

		boolean existe = cliente != null ? true : false;
		Assert.assertTrue(existe);
		repCliente.close();
	}

	@Test
	public void deveAlterarDadosDaClienteTest() {
		ClienteController repCliente = new ClienteController();
		Cliente cliente = repCliente.buscarPorCodigo(codigoCliente);
		cliente.setRazaoSocial("Cardoso Marcela");

		repCliente.alterar();

		Cliente alteracaoDaCliente = repCliente.buscarPorCodigo(codigoCliente);

		Assert.assertEquals("Cardoso Marcela", alteracaoDaCliente.getRazaoSocial());
		repCliente.close();
	}

	@AfterClass
	public static void deveDeletarClienteTest() {
		ClienteController repCliente = new ClienteController();
		Cliente cliente = repCliente.buscarPorCodigo(codigoCliente);
		repCliente.deletar(cliente);
		repCliente.close();
	}

}
