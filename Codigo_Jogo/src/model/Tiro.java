package model;

import java.awt.Graphics;
import java.io.IOException;

public class Tiro extends Sprite {

	private boolean ativo;

	protected Tiro(int aparencia, int colunas, int linhas, int x, int y, String endereco)
			throws IOException {
		super(aparencia, colunas, linhas, x, y, endereco);
		ativo = false;
		
	}

	@Override
	public void animar(String direcao) {
		
		setAparencia(getAparencia() + 1);
		if (getAparencia() > 3) {
			setAparencia(0);
		}
	}

	@Override
	public void draw(Graphics g) {
		if (ativo == true) {
			g.drawImage(getSprites()[getAparencia()], getX(), getY(), null);
		}

	}

	@Override
	public void mover(String direcao) {
			setY(getY()-2);

		
	}

	public boolean isAtivo() {
		return ativo;
	}

	
	
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	
}
