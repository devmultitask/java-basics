package devmultitask;

import java.sql.SQLException;
import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class OsMelhoresSeriados {

	public static void main(String[] args) throws SQLException {

		Instant inicio = Instant.now();
		
		System.out.println(" **** Os Melhores Seriados **** ");

		boolean exibirTodos = false;

		if (args.length == 0) {
			if (SystemFlags.DEBUG)
			 System.out.println("exibir todos");
			exibirTodos = true;
		} else if (args.length > 1 && args[1].equalsIgnoreCase("debug")) {
			SystemFlags.DEBUG=true;
		} else if (args.length > 2) {
			System.out.println("argumentos inválidos");
			System.exit(0);
		}

		if (SystemFlags.DEBUG) 
		System.out.println("tamanho do args = " + args.length);
		
		if (SystemFlags.DEBUG) {
		 for (String arg : args) {
			System.out.println(arg);
		 }
		}

		int quantidade = 0;
		if (!exibirTodos) {
			quantidade = Integer.parseInt(args[0]);
		}
		
		if (SystemFlags.DEBUG)
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
		List<String> seriados = repositorio.mostraSeries(quantidade);

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
		Instant fim = Instant.now();
		long duracao = Duration.between(inicio, fim).toMillis();
		if (SystemFlags.DEBUG)
		 System.out.println("Tempo de processamento: "+duracao+"ms");
		
	}
}
