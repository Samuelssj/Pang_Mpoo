package model;

import java.awt.Color;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FaseModel {
	
	private TileMap Camada_detalhe;
	private TileMap Camada_terra;
	private TileMap Camada_montanha;
	private TileMap Camada_fundo;
	private TileMap Camada_blocos;
	private Personagem boneco; 
	private Personagem boneco2; 
	private Map<Bolas, String> bolas;
	private Map<String, Bolas> bolastring;
	public static ArrayList<Rectangle> colisao;
	public static ArrayList<Rectangle> colisao2;
	public static ArrayList<Rectangle> colisao3;
	
	public FaseModel() {
		super(); 
		
		
		Camada_detalhe = new TileMap(25, 25, 30, 30, "tileset.png", "Camada_detalhe.txt");
		Camada_terra = new TileMap(25, 25, 30, 30, "tileset.png", "Camada_terra.txt");
		Camada_montanha = new TileMap(25, 25, 30, 30, "tileset.png", "Camada_montanha.txt");
		Camada_fundo = new TileMap(25, 25, 30, 30, "tileset.png", "Camada_fundo.txt");
		Camada_blocos = new TileMap(25, 25, 30, 30, "tileset.png", "Blocos.txt");
		colisao = (ArrayList<Rectangle>) Camada_detalhe.montarColisao();
		colisao2 = (ArrayList<Rectangle>) Camada_blocos.montarColisao();
	
		colisao3 = new ArrayList<>();
		colisao3.addAll(colisao);
		
		try {
			
			Bolas green = new Bolas(0, 3, 3,  150, 0, true,"bolaG.png"); 
			Bolas red = new Bolas(6, 3, 3,  165, 50, true,"bolaG.png");
			Bolas purple = new Bolas(1, 3, 3,  300, 200,false, "bolaG.png");
			Bolas gray = new Bolas(2, 3, 3,  450, 150,false, "bolaG.png");
			Bolas  blue = new Bolas(3, 3, 3,  10, 100,true,"bolaG.png");
			Bolas pink= new Bolas(4, 3, 3,  300, 200, false,"bolaG.png");
			Bolas black = new Bolas(5, 3, 3,  100, 150, false,"bolaG.png");
			Bolas yellow = new Bolas(7, 3, 3, 0, 0, false,"bolaG.png");
			
			bolas = new HashMap<>();
			bolas.put(green, "GREEN");
			bolas.put(purple, "PURPLE");
			bolas.put(gray, "GRAY");
			bolas.put(blue, "BLUE");
			bolas.put(pink, "PINK");
			bolas.put(black, "BLACK");
			bolas.put(red, "RED");
			bolas.put(yellow, "YELLOW");
			
			boneco = new Personagem(0, 6, 2, 400, 332, "boneco.png", "FOGO.png");
			boneco2 = new Personagem(0, 6, 2, 430, 332, "boneco2.png","FOGO2.png");

	
			bolastring = new HashMap<>();
			bolastring.put("GREEN", green);
			bolastring.put("PURPLE", purple);
			bolastring.put("GRAY", gray);
			bolastring.put("BLUE", blue);
			bolastring.put("PINK",pink);
			bolastring.put("BLACK", black);
			bolastring.put("RED", red);
			bolastring.put("YELLOW", yellow);
					
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void colidirBlocos(boolean ativo)
	{
		if(ativo)
		{
			colisao3.addAll(colisao2);
		}
		else
		{
			colisao3.removeAll(colisao2);
		}
	}
	
	public TileMap getCamada_detalhe() {
		return Camada_detalhe;
	}

	public void setCamada_detalhe(TileMap camada_detalhe) {
		Camada_detalhe = camada_detalhe;
	}

	public TileMap getCamada_terra() {
		return Camada_terra;
	}

	public void setCamada_terra(TileMap camada_terra) {
		Camada_terra = camada_terra;
	}

	public TileMap getCamada_montanha() {
		return Camada_montanha;
	}

	public void setCamada_montanha(TileMap camada_montanha) {
		Camada_montanha = camada_montanha;
	}

	public TileMap getCamada_fundo() {
		return Camada_fundo;
	}

	public void setCamada_fundo(TileMap camada_fundo) {
		Camada_fundo = camada_fundo;
	}

	public Personagem getBoneco() {
		return boneco;
	}

	public void setBoneco(Personagem boneco) {
		this.boneco = boneco;
	}

	public Map<Bolas, String> getBolas() {
		return bolas;
	}

	public void setBolas(Map<Bolas, String> bolas) {
		this.bolas = bolas;
	}

	public static ArrayList<Rectangle> getColisao() {
		return colisao;
	}

	public static void setColisao(ArrayList<Rectangle> colisao) {
		FaseModel.colisao = colisao;
	}

	public Map<String, Bolas> getBolastring() {
		return bolastring;
	}

	public void setBolastring(Map<String, Bolas> bolastring) {
		this.bolastring = bolastring;
	}

	public TileMap getCamada_blocos() {
		return Camada_blocos;
	}

	public Personagem getBoneco2() {
		return boneco2;
	}

	public void setBoneco2(Personagem boneco2) {
		this.boneco2 = boneco2;
	}

	public void setCamada_blocos(TileMap camada_blocos) {
		Camada_blocos = camada_blocos;
	}

	




	

}
