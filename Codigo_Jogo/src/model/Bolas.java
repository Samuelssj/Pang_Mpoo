package model;

import java.awt.Graphics;
import java.io.IOException;
import java.util.Random;

public class Bolas extends Sprite {
	private boolean ativo = true;
	private int ativob = 0;
	private int velocidade = 1;
	
	protected Bolas(int aparencia, int colunas, int linhas, int x, int y,boolean ativo, String endereco)
			throws IOException {
		super(aparencia, colunas, linhas, x, y, endereco);
		
		this.ativo = ativo;
		
		if(new Random().nextBoolean())
			setDirecao(-1);
		else
			setDirecao(1);
	}
 
	@Override
	public void animar(String direcao) {
		
	}

	@Override
	public void draw(Graphics g) {
		if(ativo == true) {
			g.drawImage(getSprites()[getAparencia()], getX(),getY(), null);
		}
	}
		
	public void mover() {
		setX((int) (getX()+ (velocidade * super.getDirecao())));
	}
	
	public void pular() {
		int anguloDoPulo = 45;
		int anguloCorrente = anguloDoPulo;
		int aux = getDirecao();
		int x = getX();
		int y = getY();
		
		while(anguloCorrente != 300) {
			if(anguloCorrente == 0)
				anguloCorrente = 360;
			anguloCorrente--;
			y -= (int) (velocidade * Math.sin(Math.toRadians(anguloCorrente)));
			x += (int) (velocidade * Math.cos(Math.toRadians(anguloCorrente)) * aux);
			setY(y);
			setX(x);
//			try {
//				Thread.sleep(10);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}
	}
	
	@Override
	public void mover(String direcao) {
		
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public int getAtivob() {
		return ativob;
	}

	public void setAtivob(int ativob) {
		this.ativob = ativob;
	}

	public int getVelocidade() {
		return this.velocidade;
	}

	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}
	

	
	
}
