package model;

import java.awt.Graphics;
import java.util.ArrayList;

import View.Fase;
import controller.ControlePesonagem;

import java.io.IOException;

public class Personagem extends Sprite {

	private ArrayList<Tiro> tiros;
	private int municao = 0;
	private int esquerda, direita;
	private boolean ativo = true;


	protected Personagem(int aparencia, int colunas, int linhas, int x, int y, String endereco, String tiro)
			throws IOException {
		super(aparencia, colunas, linhas, x, y, endereco);
		this.tiros = new ArrayList<>(5);
		for (int i = 0; i < 5; i++) {
			tiros.add(new Tiro(0, 4, 1, x, y, tiro));
		}
		// TODO Auto-generated constructor stub
	}

	@Override
	public void animar(String direcao) {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		if (ativo)
			g.drawImage(getSprites()[getAparencia()], getX(), getY(), null);

	}

	@Override
	public void mover(String direcao) {

		if (direcao.equals("esquerda")) { // index 1 referente a telca para direita

			setDirecao(-1);

			if (getX() > 5) {
				setX(getX() - 5);
			}
			switch (esquerda) {
			case 0:
				setAparencia(4);
				break; 
			case 1:
				setAparencia(6);
				break;
			case 2:
				setAparencia(8);
				break;
			case 3:
				setAparencia(2);
				break;
			}
			if (esquerda == 3)
				esquerda = 0;
			else
				esquerda++;
			setOlhandoE(1);
			setOlhandoD(0);

		} else if (direcao.equals("direita")) { // index 3 referente a telca para esquerda

			setDirecao(1);

			if (getX() < 694) {
				setX(getX() + 5);
			}
			switch (direita) {
			case 0:
				setAparencia(3);
				break;
			case 1:
				setAparencia(1);
				break;
			case 2:
				setAparencia(5);
				break;
			case 3:
				setAparencia(7);
				break;
			}
			if (direita == 3)
				direita = 0;
			else
				direita++;
			setOlhandoE(0);
			setOlhandoD(1);
		}

		// System.out.println(sprite.getX() + "," + sprite.getY()); // 694
		if (direcao.equals("atirar")) { // index 1 referente a telca para direita
	//System.out.println("Atirar");
			atirar();
			ControlePesonagem.mover1 = "";
			ControlePesonagem.mover2 = "";
			if (getOlhandoE() == 1) {
				setAparencia(11);

			} else
				setAparencia(9); 

		}
		if (direcao.equals("pular")) {
			
			pular();
		}
		
	}
	

	public void atirar() {

		if (municao < 5) {
			tiros.get(municao).setAtivo(true);
			tiros.get(municao).setX(getX());
			tiros.get(municao).setY(getY() - getLarguraPersonagem());
			municao++;
		} else if (municao >= 5) {
			municao = 0;

		}

	}

	public void cair() {

		if(getY() < 332)
			setY(getY() + getVelocidade());
		if(getY() > 332)
			setY(332);
	}

	public ArrayList<Tiro> getTiros() {
		return tiros;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public void setX(int x) {
		if (!collision(FaseModel.colisao3, x - getX(), 0))
			super.setX(x);//this.x = x;

	}

	@Override
	public void setY(int y) {
		if (!collision(FaseModel.colisao3, 0, y - getY()))
			super.setY(y);//this.y = y;
	}

	
}
