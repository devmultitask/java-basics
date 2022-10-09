package devmultitask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
public class Repositorio {

	public List<Seriado> mostraSeries(int quantidade) throws DatabaseException {

		Connection conn = getConnection();
		List<Seriado> seriados = new ArrayList<Seriado>();
		try {
			String sql = "SELECT NM_SERIE ,ANO  FROM SERIE WHERE rownum <= ?";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, quantidade);
			ResultSet result = statement.executeQuery();
 
			while (result.next()) {
				String nome = result.getString(1);
				int ano = result.getInt(2);
				seriados.add( new Seriado(ano,nome));
			}

		} catch (Exception ex) {
			if (SystemFlags.DEBUG)
			 ex.printStackTrace();
			throw new DatabaseException();
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException ex) {
				if (SystemFlags.DEBUG)
				 ex.printStackTrace();
			}
		}
		return seriados;
	}

	private Connection getConnection() throws DatabaseException {

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
		} catch (Exception ex) {
			if (SystemFlags.DEBUG)
			 ex.printStackTrace();
			throw new DatabaseException();
		}
		return conn;
	}
}