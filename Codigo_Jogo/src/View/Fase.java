package View;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import View.Iventario;
public class Fase extends PanelGeral {

	private BufferedImage fundo;
	private Graphics2D graficosTela;
	private Iventario iventario;
	

	public Fase() {
		super();
		setLayout(null); 
		
		fundo = new BufferedImage(TelaGeral.LARGURA, TelaGeral.ALTURA, BufferedImage.TYPE_4BYTE_ABGR);
		iventario = new Iventario();
		add(iventario);
		iventario.setBounds(750,0, 200, TelaGeral.ALTURA);
		iventario.setVisible(false);
		graficosTela = (Graphics2D) fundo.getGraphics();
		
	}
//			liga o iventario com a fase visibilidade igual
	@Override
	public void setVisible(boolean aFlag) {
		if(iventario != null)
			iventario.setVisible(aFlag);
		super.setVisible(aFlag);
	}
	
	public BufferedImage getFundo() {
		return fundo;
	}

	public Graphics2D getGraficosTela() {
		return graficosTela;
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(fundo, 0, 0, null);
		//iventario.repaint();
	}

	public Iventario getIventario() {
		return iventario;
	}
	

}
