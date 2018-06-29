package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entidades.Usuario;

public class UsuarioDAO {

	private Connection con = ConexaoFactory.getConnection();

	public void cadastrar(Usuario usu) {
		String sql = "INSERT INTO usuario (nome, profissao, endereco, cidade, estado, login, senha)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";

		try (PreparedStatement preparador = con.prepareStatement(sql)) {
			preparador.setString(1, usu.getNome()); //Substitui o ? pelo dado do usuário
			preparador.setString(2, usu.getProfissao());
			preparador.setString(3, usu.getEndereco());
			preparador.setString(4, usu.getCidade());
			preparador.setString(5, usu.getEstado());
			preparador.setString(6, usu.getLogin());
			preparador.setString(7, usu.getSenha());

			preparador.execute(); //Executa o comando SQL no banco
			preparador.close(); //Fecha o objeto preparador para liberar recurso

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void alterar(Usuario usu) {
		String sql = "UPDATE usuario SET nome=?, profissao=?, endereco=?, cidade=?, estado=?, login=?, senha=?"
				+ "WHERE login=?";

		try (PreparedStatement preparador = con.prepareStatement(sql)) {
			preparador.setString(1, usu.getNome()); //Substitui o ? pelo dado do usuário
			preparador.setString(2, usu.getProfissao());
			preparador.setString(3, usu.getEndereco());
			preparador.setString(4, usu.getCidade());
			preparador.setString(5, usu.getEstado());
			preparador.setString(6, usu.getLogin());
			preparador.setString(7, usu.getSenha());
			preparador.setString(8, usu.getLogin());

			preparador.execute(); //Executa o comando SQL no banco
			preparador.close(); //Fecha o objeto preparador para liberar recurso

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void excluir(Usuario usu) {
		String sql = "DELETE FROM usuario WHERE login=?";

		try (PreparedStatement preparador = con.prepareStatement(sql)) {
			preparador.setString(1, usu.getLogin());

			preparador.execute(); //Executa o comando SQL no banco
			preparador.close(); //Fecha o objeto preparador para liberar recurso

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void salvar(Usuario usuario) {
		if(usuario.getLogin() != null) {
			alterar(usuario);
		} else {
			cadastrar(usuario);
		}
	}
}