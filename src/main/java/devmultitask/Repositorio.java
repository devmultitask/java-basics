package devmultitask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * TODO: rever responsabilidades da classe Repositorio
 */
public class Repositorio {

	public void mostraSeries() {

		Connection conn = getConnection();
		try {
			String sql = "SELECT NOME FROM ULTIMAS_SERIES";

			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);

			int count = 0;

			while (result.next()) {
				String name = result.getString(1);

				String output = "Seriado #%d: %s";
				System.out.println(String.format(output, ++count, name));
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	private Connection getConnection() {

		Connection conn = null;

		try {
			String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
			String username = "fb";
			String password = "fb";
			conn = DriverManager.getConnection(dbURL, username, password);
			if (conn != null) {
				System.out.println("Conectado ao Oracle");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return conn;
	}
}