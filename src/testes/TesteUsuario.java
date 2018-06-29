package testes;

import entidades.Usuario;
import persistencia.UsuarioDAO;

public class TesteUsuario {

	public static void main(String[] args) {
		salvar();
	}

	public static void alterar(){
		Usuario usu = new Usuario();

		usu.setNome("Nataly Mota");
		usu.setProfissao("Programadora");
		usu.setEndereco("Av. Japão");
		usu.setEstado("São Paulo");
		usu.setCidade("Carapicuíba");
		usu.setLogin("natalysmota");
		usu.setSenha("123");

		UsuarioDAO  usuDAO = new UsuarioDAO();
		usuDAO.alterar(usu);

		System.out.println("Alterado com sucesso!");
	}

	public static void cadastrar(){
		Usuario usu = new Usuario();

		usu.setNome("Nataly S. Mota");
		usu.setProfissao("Analista de Sistemas");
		usu.setEndereco("Rua Odilon");
		usu.setEstado("Paraíba");
		usu.setCidade("Campina Grande");
		usu.setLogin("natalysmota");
		usu.setSenha("123456");

		UsuarioDAO  usuDAO = new UsuarioDAO();
		usuDAO.cadastrar(usu);

		System.out.println("Cadastrado com sucesso!");
	}

	public static void excluir() {
		Usuario usu = new Usuario();
		usu.setLogin("natalysmota");

		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.excluir(usu);

		System.out.println("Excluído com sucesso!");
	}
	
	public static void salvar() {
		Usuario usu = new Usuario();
		usu.setNome("Nataly Soares");
		usu.setProfissao("Programadora");
		usu.setEndereco("Rua Odilon");
		usu.setEstado("São Paulo");
		usu.setCidade("São Paulo");
		usu.setLogin("naty");
		usu.setSenha("123");
		
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.salvar(usu);
		
		System.out.println("Salvo com sucesso!");
	}
}