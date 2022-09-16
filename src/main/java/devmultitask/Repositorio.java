package devmultitask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
public class Repositorio {

	public List<String> mostraSeries(int quantidade) {

		Connection conn = getConnection();
		List<String> seriados = new ArrayList<String>();
		try {
			String sql = "SELECT NOME FROM FILMES WHERE rownum <= ?";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, quantidade);
			ResultSet result = statement.executeQuery();
 
			while (result.next()) {
				String name = result.getString(1);
				seriados.add(name);
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
		return seriados;
	}

	private Connection getConnection() {

		Connection conn = null;

		try {
			String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
			String username = "devmultitask";
			String password = "devmultitask";
			conn = DriverManager.getConnection(dbURL, username, password);
			if (conn != null) {
				if (SystemFlags.DEBUG)
				 System.out.println("Conectado ao Oracle");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return conn;
	}
}