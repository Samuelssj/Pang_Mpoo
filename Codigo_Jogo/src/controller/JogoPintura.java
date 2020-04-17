package controller;

import java.awt.Graphics;
import java.awt.Graphics2D;

import View.Fase;
import View.Iventario;


public abstract class JogoPintura implements Runnable {

	protected Fase fase;


	protected Graphics2D graficos;
	protected Thread thread;
	private final int FPS = 30;
	private Double averageFPS;
	private Iventario iventario;
	protected static boolean loop;
	
 
	public JogoPintura(Fase fase) {
		super();
		this.fase = fase;
		
		stop();
	}
	
	public JogoPintura(Iventario iventario) {
		super();
		this.iventario = iventario;
		
	}


	public abstract void draw(Graphics g);
	public abstract void inicializar();
	public abstract void atualizar();

	@Override
	public void run() {

		inicializar();

		graficos = (Graphics2D) fase.getGraficosTela();
		fase.requestFocus();


		while(true)
		{		
	

			if(loop)
			{
				fase.repaint();	//Dedesenha o plano de fundo 				
				atualizar();//Desenha as camadas 
				draw(graficos);//Desenha a imagem do mapa
				
			}

		

			try {
				Thread.sleep(50);
			} catch (Exception e) {
			}

	
		}


	}
	public void start() {
		if(thread== null) {
			thread = new Thread(this);
			thread.start();
		}
		loop = true;
		fase.requestFocus();

	}

	public static void stop()
	{
		loop = false;
	}
	
}