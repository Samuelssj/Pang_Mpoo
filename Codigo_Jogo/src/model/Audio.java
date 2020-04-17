package model;

import java.applet.Applet;
import java.applet.AudioClip;


public class Audio {

	private AudioClip fase1, menu, estouro, fogo;

	public Audio() {
		
		fase1 = Applet.newAudioClip(getClass().getClassLoader().getResource("Fase1.wav"));
		menu = Applet.newAudioClip(getClass().getClassLoader().getResource("MENU.wav"));
		estouro = Applet.newAudioClip(getClass().getClassLoader().getResource("BalaoEstouro.wav"));
		fogo = Applet.newAudioClip(getClass().getClassLoader().getResource("fogoSom.wav"));


	}

	public AudioClip getFase1() {
		return fase1;
	}

	public AudioClip getMenu() {
		return menu;
	}

	public AudioClip getEstouro() {
		return estouro;
	}
	
	public AudioClip getFogo() {
		return fogo;
	}

	



}
