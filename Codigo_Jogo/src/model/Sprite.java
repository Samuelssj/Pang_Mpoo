package model;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

public abstract class Sprite {

	private int larguraPersonagem, alturaPersonagem;

	protected BufferedImage personagem;
	protected int largura, altura;
	protected int linhas, colunas;
	private int x, y;
	private int direcao = -1;
	private int direcaoAnterior = -1;
	int olhandoE = 0;
	int olhandoD = 0;
	private BufferedImage[] sprites;
	private int aparencia;
	private int velocidade = 3;

	protected Sprite(int aparencia, int colunas, int linhas, int x, int y, String endereco) throws IOException {

		try {

			this.personagem = ImageIO.read(getClass().getClassLoader().getResourceAsStream(endereco));
			this.aparencia = aparencia;

			this.largura = personagem.getWidth();
			this.altura = personagem.getHeight();

			this.linhas = colunas;
			this.colunas = linhas;
			this.x = x;
			this.y = y;

			sprites = new BufferedImage[colunas * linhas];

			for (int i = 0; i < colunas; i++) {
				for (int j = 0; j < linhas; j++) {
					sprites[(i * linhas) + j] = personagem.getSubimage(i * (largura / colunas), j * (altura / linhas),
							largura / colunas, altura / linhas);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Nao foi possivel carregar a Sprite");
		}

		larguraPersonagem = sprites[0].getWidth();
		alturaPersonagem = sprites[0].getHeight();
	}

	public abstract void animar(String direcao);

	public abstract void draw(Graphics g);

	public abstract void mover(String direcao);

	public void setLocale(int x, int y) {

		this.x = x;
		this.y = y;
	}

	public void pular() {

		int anguloDoPulo = 40;
		int anguloCorrente = anguloDoPulo;
		int aux = direcao;
		double dx, dy;
		//System.out.println("Direção: " + direcao);
		y -= velocidade;
		while (anguloCorrente != 300) {
			if (anguloCorrente == 0)
				anguloCorrente = 360;
			dy = velocidade * Math.sin(Math.toRadians(anguloCorrente));
			dx = (velocidade * Math.cos(Math.toRadians(anguloCorrente))) * aux;
			anguloCorrente--;

			if (!collision(FaseModel.colisao3, (int) dx, (int) dy)) {
				y -= dy;
				x += dx;
			} else {
				y += dy;
				x -= dx;
				break;
			}

			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		y -= y % velocidade;
	}

	public boolean collision(List<Rectangle> tmp, int x, int y) {

		Rectangle personagem = new Rectangle(getX() + x, getY() + y, getLarguraPersonagem(), getAlturaPersonagem());
		for (Rectangle rectangle : tmp) {
			if (rectangle.intersects(personagem)) {
				return true;
			}
		}
		return false;
	}
	
	public int getDirecaoAnterior() {
		return direcaoAnterior;
	}

	public void setDirecaoAnterior(int direcaoAnterior) {
		this.direcaoAnterior = direcaoAnterior;
	}

	public int getDirecao() {
		return direcao;
	}

	public void setDirecao(int direcao) {
		this.direcao = direcao;
	}

	public BufferedImage getPersonagem() {
		return personagem;
	}

	public int getX() {
		return x;
	}


	public int getY() {
		return y;
	}



	public int getAparencia() {
		return aparencia;
	}

	public void setAparencia(int aparencia) {
		this.aparencia = aparencia;
	}

	public BufferedImage[] getSprites() {
		return sprites;
	}

	public int getLarguraPersonagem() {
		return larguraPersonagem;
	}

	public int getAlturaPersonagem() {
		return alturaPersonagem;
	}

	public Rectangle getBounds() {
		return new Rectangle(x + 5, y + 5, larguraPersonagem - 10, alturaPersonagem - 10);
	}

	public int getLargura() {
		return largura;
	}

	public int getAltura() {
		return altura;
	}

	public int getLinhas() {
		return linhas;
	}

	public int getColunas() {
		return colunas;
	}

	public int getOlhandoE() {
		return olhandoE;
	}

	public void setOlhandoE(int olhandoE) {
		this.olhandoE = olhandoE;
	}

	public int getOlhandoD() {
		return olhandoD;
	}

	public void setOlhandoD(int olhandoD) {
		this.olhandoD = olhandoD;
	}

	public int getVelocidade() {
		return velocidade;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}


}
