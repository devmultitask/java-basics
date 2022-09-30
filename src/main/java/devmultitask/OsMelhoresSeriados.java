package devmultitask;

import java.sql.SQLException;
import java.time.Duration;
import java.time.Instant;
import java.util.Collections;
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

		/* TODO: tratar erro de banco */

		/* TODO: melhorar o empacotamento */

		/* TODO: gravar saida em texto */

		Repositorio repositorio = new Repositorio();
		List<Seriado> seriados = repositorio.mostraSeries(quantidade);

		Collections.sort(seriados);
		
		String output = "seriado #%d: %s - %d";
		int count = 0;

		if (exibirTodos) {
			for (Seriado seriado : seriados) {
				System.out.println(String.format(output, ++count, seriado.getNome(), seriado.getAno()));
			}
		} else {
			while (count < quantidade) {
				Seriado seriado = seriados.get(count);
				System.out.println(String.format(output, ++count, seriado.getNome(), seriado.getAno()));
			}
		}
		Instant fim = Instant.now();
		long duracao = Duration.between(inicio, fim).toMillis();
		if (SystemFlags.DEBUG)
		 System.out.println("Tempo de processamento: "+duracao+"ms");
		
	}
}
