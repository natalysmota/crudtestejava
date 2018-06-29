package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

	public static Connection getConnection() {

		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_cadastro",
					"root", "jsfprimefaces3306");
		} catch (SQLException e) {
			throw new RuntimeException(e); //Relança a exception
		}
	}
}