package model;

public class Jogador {

	private int placar;
	private String nome;
	
	public Jogador(int placar, String nome) {
		super();
		this.placar = placar;
		this.nome = nome;
	}

	public int getPlacar() {
		return placar;
	}

	public void setPlacar(int placar) {
		this.placar = placar;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

	
}
