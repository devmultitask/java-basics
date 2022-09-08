package devmultitask;

import java.sql.SQLException;
import java.util.List;

public class OsMelhoresSeriados {

	public static void main(String[] args) throws SQLException {

		System.out.println(" **** Os Melhores Seriados **** ");

		boolean exibirTodos = false;

		System.out.println("tamanho do args = " + args.length);

		if (args.length == 0) {
			System.out.println("exibir todos");
			exibirTodos = true;
		} else if (args.length > 1) {
			System.out.println("argumentos inválidos");
			System.exit(0);
		}

		for (String arg : args) {
			System.out.println(arg);
		}

		int quantidade = 0;
		if (!exibirTodos) {
			quantidade = Integer.parseInt(args[0]);
		}
		System.out.println("quantidade = " + quantidade);

		/*
		 * TODO: tratar parâmetro para quantidade de seriados (se não informado, exibir
		 * todos)
		 */

		/* TODO: usar listas para controlar o resultado */

		/* TODO: orderar o resultado */

		/* TODO: tratar erro de banco */

		/* TODO: melhorar o empacotamento */

		/* TODO: gravar saida em texto */

		Repositorio repositorio = new Repositorio();
		List<String> seriados = repositorio.mostraSeries();

		String output = "seriado #%d: %s";
		int count = 0;

		if (exibirTodos) {
			for (String seriado : seriados) {
				System.out.println(String.format(output, ++count, seriado));
			}
		} else {
			while (count < quantidade) {
				String seriado = seriados.get(count);
				System.out.println(String.format(output, ++count, seriado));
			}
		}
	}
}
