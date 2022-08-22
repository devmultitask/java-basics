package devmultitask;

public class Seriado {
	
	private int ano;
	private String nome;
	private String categoria;

	public int getAno() {
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

	public Seriado(int ano, String nome, String categoria) {
		this.ano = ano;
		this.nome = nome;
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return nome + " (" + ano + ") - " + categoria;
	}
}