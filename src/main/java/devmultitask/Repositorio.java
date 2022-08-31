package devmultitask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
public class Repositorio {

	public List<String> mostraSeries() {

		Connection conn = getConnection();
		List<String> seriados = new ArrayList<String>();
		try {
			String sql = "SELECT NOME FROM ULTIMAS_SERIES";

			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
 
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
				System.out.println("Conectado ao Oracle");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return conn;
	}
}