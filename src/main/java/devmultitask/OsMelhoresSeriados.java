package devmultitask;

import java.sql.SQLException;
import java.util.List;

public class OsMelhoresSeriados {

	public static void main(String[] args) throws SQLException {
		
		System.out.println(" **** Os Melhores Seriados **** ");
		
		/* TODO: tratar parâmetro para quantidade de seriados (se não informado, exibir todos) */
		
		/* TODO: usar listas para controlar o resultado */
		
		/* TODO: orderar o resultado */
		
		/* TODO: tratar erro de banco */
		
		/* TODO: melhorar o empacotamento */
		
		/* TODO: gravar saida em texto */
		
		Repositorio repositorio = new Repositorio();
		List<String> seriados = repositorio.mostraSeries();
		
		String output = "seriado #%d: %s";
		int count = 0;
		for (String seriado : seriados) {
		 System.out.println(String.format(output, ++count, seriado));
		} 
	}
}
