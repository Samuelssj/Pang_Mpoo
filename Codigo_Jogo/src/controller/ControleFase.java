package controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;

import View.Fase;
import View.Iventario;
import model.Bolas;
import model.FaseModel;
import model.Personagem;
import model.TileMap;
import model.Tiro;

public class ControleFase extends JogoPintura {

	private BufferedImage imagemMapa;
	private Graphics2D graficosMapa;
	private List<TileMap> listaCamada;
	private Personagem boneco;
	private Personagem boneco2; 
	private Map<Bolas,String> bolas;
	private FaseModel model;
	public static String cor;
    private Color cor2;
	private static int x, y;
	
	private Graphics graficoInventario;
	private ImageIcon imagemOb;

	
	
	public ControleFase(Fase fase, List<TileMap> listaCamada, Personagem boneco, Personagem boneco2,Map<Bolas, String> bolas) {
		super(fase);
		this.listaCamada = listaCamada;
		this.boneco = boneco;
		this.boneco2 = boneco2;
		this.bolas = bolas;
		
		graficoInventario = fase.getIventario().getFundoBloco().getGraphics();
		imagemOb = new ImageIcon(getClass().getClassLoader().getResource("Objetivo.png"));
		
		cor = "";

	}
	public Color acharCor() {
		
		if(cor.equalsIgnoreCase("GREEN")) {
			
			cor2 = Color.GREEN ;
		}if(cor.equalsIgnoreCase("BLUE")) {
			cor2 = Color.BLUE ;
		}
		else if (cor.equalsIgnoreCase("RED")) {
			cor2 = Color.RED;
		}
		else if (cor.equalsIgnoreCase("PURPLE")){
			cor2 = Color.decode("#800080");
		}
		else if (cor.equalsIgnoreCase("YEllOW")){
			cor2 = Color.YELLOW;
		}
		else if (cor.equalsIgnoreCase("BLACK")) {
			cor2 = Color.BLACK;
		}
		else if (cor.equalsIgnoreCase("GRAY")) {
			cor2 = Color.GRAY;
		}
		else if (cor.equalsIgnoreCase("PINK")) {
			cor2 = Color.PINK;
		}
		return cor2;
		
	}

	@Override
	public void draw(Graphics g) {
		
		acharCor();
		g.drawImage(imagemMapa, x, y, null);
		g.setFont(new Font("serif",Font.BOLD,20));
//		passar uma string e retorna uma cor
		//g.setColor(cor2);
		//fase.getIventario().getGraphics().drawString(cor,10,20);
		//g.drawString(cor,710,320);
		graficoInventario.drawImage(imagemOb.getImage(), 0, 0, null);
		graficoInventario.setColor(cor2);
		graficoInventario.drawString(cor, 20, 90);
		graficoInventario.setFont(new Font("serif",Font.BOLD,18));
		
		
	

	}
	

	@Override
	public void inicializar() {
		// TODO Auto-generated method stub
		imagemMapa = new BufferedImage(listaCamada.get(0).getLarguraTela(),listaCamada.get(0).getAlturaTela() ,BufferedImage.TYPE_4BYTE_ABGR);
		
		graficosMapa = (Graphics2D) imagemMapa.getGraphics();
	}

	@Override
	public void atualizar() {
		// TODO Auto-generated method stub

		int i = 0;
		for (TileMap valore : listaCamada) {
			valore.montarMapa();

			if(!fase.getIventario().isBlocos())
			{
				if(i < listaCamada.size()-1)
					graficosMapa.drawImage(valore.getMapa(), 0, 0, null);				
			}
			else
				graficosMapa.drawImage(valore.getMapa(), 0, 0, null);
			
			
			i++;
		}
		

		boneco.draw(graficosMapa);
		boneco2.draw(graficosMapa);
//		
//		graficosMapa.draw(boneco.getBounds());
//		graficosMapa.draw(boneco2.getBounds());
		
		for (Bolas bola : bolas.keySet()) {
			bola.draw(graficosMapa);

		}
		for (Tiro tiros : boneco.getTiros()) {
			tiros.draw(graficosMapa);
			tiros.animar("Atirar");
		}
		for (Tiro tiros : boneco2.getTiros()) {
			tiros.draw(graficosMapa);
			tiros.animar("Atirar"); 
		}
//		
//		for(Rectangle r : FaseModel.colisao) //mostrar espaços de olisao tiled
//			graficosMapa.draw(r);
//		for(Rectangle r : FaseModel.colisao2) //mostrar espaços de olisao tiled
//			graficosMapa.draw(r);
//		
	}


	
	public Map<Bolas, String> getBolas() {
		return bolas;
	}
	
	
}
