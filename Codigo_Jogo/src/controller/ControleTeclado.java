package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import View.Fase;
import model.FaseModel;
import model.Personagem;

public class ControleTeclado implements KeyListener {
	private Personagem sprite;
	private Fase fase;
	

	public ControleTeclado(Personagem sprite, Fase fase) {
		this.sprite = sprite;
		this.fase = fase;
		// fase.requestFocus();
		fase.addKeyListener(this);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		

		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
			ControlePesonagem.mover2 = "direita";
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
			ControlePesonagem.mover2 = "esquerda";
		
		if(e.getKeyCode() == KeyEvent.VK_A)
			ControlePesonagem.mover1 = "esquerda";
		if(e.getKeyCode() == KeyEvent.VK_D)
			ControlePesonagem.mover1 = "direita";
		
		if(e.getKeyCode() == KeyEvent.VK_SPACE)
			ControlePesonagem.mover1 = "atirar";
		if(fase.getIventario().getNomeJogador2().isVisible()) {
		if(e.getKeyCode() == KeyEvent.VK_P)
			ControlePesonagem.mover2 = "atirar";
		}
		if(e.getKeyCode() == KeyEvent.VK_W)
			ControlePesonagem.mover1 = "pular"; 
		if(e.getKeyCode() == KeyEvent.VK_UP)
			ControlePesonagem.mover2 = "pular";
		
		if(e.getKeyCode() == KeyEvent.VK_B)
			if(fase.getIventario().getPlacar() >=30) {
				
			fase.getIventario().setPlacar(fase.getIventario().getPlacar()-30);
			fase.getIventario().setBlocos(true);
			FaseModel.colidirBlocos(true);
			 
			 
			}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (sprite.getDirecao() == KeyEvent.VK_SPACE) {
			if (sprite.getOlhandoE() == 1) {
				sprite.setAparencia(0);
			} else
				sprite.setAparencia(7);
		}
		
		if (e.getKeyCode() == KeyEvent.VK_D) {
			ControlePesonagem.mover1 = "";
		} else if (e.getKeyCode() == KeyEvent.VK_A)
			ControlePesonagem.mover1 = "";
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			ControlePesonagem.mover2 = "";
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
	
			ControlePesonagem.mover2 = "";
		if(e.getKeyCode() == KeyEvent.VK_SPACE)
			ControlePesonagem.mover1 = "";
		if(e.getKeyCode() == KeyEvent.VK_P)
			ControlePesonagem.mover2 = "";
		
		if(e.getKeyCode() == KeyEvent.VK_W)
			ControlePesonagem.mover1 = "";
		if(e.getKeyCode() == KeyEvent.VK_UP)
			ControlePesonagem.mover2 = "";
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
