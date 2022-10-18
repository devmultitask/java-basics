package devmultitask;

import java.nio.file.Path;
import java.time.Duration;
import java.time.Instant;
import java.util.Collections;
import java.util.List;

public class OsMelhoresSeriados {

	private static final String ARQUIVO="melhores-series.txt";
	
	public static void main(String[] args)  {

		Instant inicio = Instant.now();
		Path caminhoDoArquivo = Path.of(ARQUIVO);
		
		FileUtil.deleteFile(caminhoDoArquivo);
		
		String titulo = " **** Os Melhores Seriados **** \n";
		System.out.print(titulo);
		FileUtil.writeFile(caminhoDoArquivo,titulo);

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
      
		Repositorio repositorio = new Repositorio();
		List<Seriado> seriados;
		try {
			seriados = repositorio.mostraSeries(quantidade);
			
			Collections.sort(seriados);
			
			String output = "seriado #%d: %s - %d";
			int count = 0;
			
			if (exibirTodos) {
				for (Seriado seriado : seriados) {
					String descSeriado = String.format(output, ++count, seriado.getNome(), seriado.getAno());
					System.out.println(descSeriado);
					FileUtil.writeFile(caminhoDoArquivo,descSeriado+"\n");
				}
			} else {
				while (count < quantidade) {
					if (count == seriados.size()) break;
					Seriado seriado = seriados.get(count);
					String descSeriado = String.format(output, ++count, seriado.getNome(), seriado.getAno());
					System.out.println(descSeriado);
					FileUtil.writeFile(caminhoDoArquivo,descSeriado+"\n");
				}
			}
		} catch (DatabaseException e) {
			System.out.println("Erro na conexão do banco de dados. Tente mais tarde.");
			System.exit(0);
		}
		Instant fim = Instant.now();
		long duracao = Duration.between(inicio, fim).toMillis();
		if (SystemFlags.DEBUG)
		 System.out.println("Tempo de processamento: "+duracao+"ms");
		
	}
}
