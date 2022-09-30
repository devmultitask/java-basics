package devmultitask;

public class Seriado implements Comparable<Seriado> {
	
	private Integer ano;
	private String nome;
	private String categoria;

	public Integer getAno() {
		return ano;
	}

	public String getNome() {
		return nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public Seriado() {
	}

	public Seriado(int ano, String nome) {
		this.ano = ano;
		this.nome = nome; 
	}
	
	public Seriado(int ano, String nome, String categoria) {
		this.ano = ano;
		this.nome = nome;
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return nome + " (" + ano + ") - " + categoria;
	}

	@Override
	public int compareTo(Seriado outroSeriado) {
		
//		int comparador = this.getNome().compareTo(outroSeriado.getNome());
//		int comparador = this.getAno().compareTo(outroSeriado.getAno());
		int comparador = outroSeriado.getAno().compareTo(this.getAno());
		
		if (SystemFlags.DEBUG)
			 System.out.println("comparando: ["+this+ "] com [" + outroSeriado +"]: "+comparador);
		
		return comparador;
	}
}