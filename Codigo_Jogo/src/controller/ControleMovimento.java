package controller;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import View.Iventario;
import model.Audio;
import model.Bolas;
import model.FaseModel;
import model.Personagem;
import model.Tiro;

public class ControleMovimento extends Thread {
	private Personagem sprite;
	private Personagem sprite2;
	private Map<Bolas, String> bolas;
	private boolean direcao = true;
	private Audio audio;
	private Iventario iventario;
	private ArrayList<String > questao = new ArrayList<>();
	private Map<String, Bolas> bolastring;
	private int pulaFase = 30;
	private List<Tiro> tiros;
	
	
	String[] todos = {
			"GREEN",
			"BLUE",
			"RED",
			"PURPLE",
			"GRAY",
			"PINK",
			"BLACK",
			"YELLOW"
		};
	private int index, atual;
	
	public ControleMovimento(Personagem sprite, Map<Bolas, String> bolas, Iventario iventario, Map<String,Bolas> bolastring,Personagem sprite2) {
		this.bolas = bolas;
		this.sprite = sprite;
		this.iventario = iventario;
		this.bolastring = bolastring;
		this.sprite2 = sprite2;
		audio = new Audio();
		tiros = new ArrayList<>();
		tiros.addAll(sprite.getTiros());
		tiros.addAll(sprite2.getTiros());
		start();
		
		
		index = 0; 
		
	}

	@Override
	public void run() {
		while (true) {
			
			try {
				sleep(25);

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

			for (Bolas bola : bolas.keySet()) {

				if(bola.isAtivo())
					if (sprite.getBounds().intersects(bola.getBounds())) {
						sprite.setAparencia(10);
					}
				for (Rectangle colisao : FaseModel.colisao) {
					if (bola.getBounds().intersects(colisao)) {
						if (direcao)
							direcao = false;
						else
							direcao = true; 
					//	bola.mover("Baixo");

					}
				}
				if (bola.getX() < 15 || bola.getX() > 665)
					bola.setDirecao(bola.getDirecao() * -1);
				
				bola.mover();
				//bola.pular();
			
				for (Tiro tiro : tiros) {
					if (tiro.isAtivo()) {
						
						tiro.mover("Atirar");
						
						if (tiro.getY() <= 0) {
							tiro.setAtivo(false);
							
						}
						
						
						if (bola.isAtivo()) {         // ver se a bola esta ativa

							if (tiro.getBounds().intersects(bola.getBounds())) {// colisao
								if (bola.isAtivo()) {
									
									tiro.setAtivo(false);
									int aparencia = bola.getAparencia();
									try {
										bola.setAparencia(8);
										
										sleep(100);
										bola.setAparencia(aparencia);
										
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
									
									if(bolas.get(bola).equals(questao.get(atual)))// se acertar a bola da placa
									{
										if(sprite.getTiros().contains(tiro))
										{
											iventario.setPlacar(iventario.getPlacar() + 10);
											iventario.getPlacarLb().setText(iventario.getPlacar()+"");
											iventario.setSegundos(iventario.getSegundos() + 5);		
											audio.getEstouro().play();
										}
										else if(sprite2.getTiros().contains(tiro))
										{
											iventario.setPlacar2(iventario.getPlacar2() + 10);
											iventario.getPlacarLb2().setText(iventario.getPlacar2()+"");
											iventario.setSegundos(iventario.getSegundos() + 5);
											audio.getEstouro().play();
										}
										

										if(iventario.getPlacar()>= pulaFase || iventario.getPlacar2()>=pulaFase) {
											iventario.setContadorFase(iventario.getContadorFase()+1);
											//System.out.println("Fase: "+iventario.getContadorFase());
											iventario.getFaseNumeracaoLb().setText(iventario.getContadorFase()+"");
											iventario.repaint();
											pulaFase *= 2;
											if(iventario.isBlocos()) {
												iventario.setBlocos(false);
												FaseModel.colidirBlocos(false);
											}
										
											 
											
//											if(iventario.getContadorFase()%2 == 0) {
//											iventario.setBlocos(true);
//											FaseModel.colidirBlocos(true);}
//											else {
//												iventario.setBlocos(true);
//												FaseModel.colidirBlocos(true)
//											}
//											
											
											//System.out.println("Aumentar Velocidade");
//											//aumenta a velocidade de todas as bolas
											for (Bolas b : bolas.keySet()) {
												b.setVelocidade(b.getVelocidade() + 1);
//												if(b.getDirecao() < 0)
//													b.setDirecao(bola.getDirecao()-1);	
//												else if(b.getDirecao() > 0)
//													b.setDirecao(bola.getDirecao()+1);
											}
											
											if(questao.size() != todos.length)
											{
												String cor = todos[questao.size()]; 
												questao.add(cor);
												bolastring.get(cor).setAtivo(true);
//												System.out.println(questao);
												Collections.shuffle(questao);
//												System.out.println(questao);
//												System.out.println("Bola Visivel: "+cor);
											}

										}
										
										ControleFase.cor = questao.get(index);
										atual = index;
										index++;
										
										if(index > questao.size()-1)
											index = 0;
									}
									
									
									else {
										try {
											if(iventario.getPlacar() > 0) {
												
												if(sprite.getTiros().contains(tiro))
												{
													iventario.setPlacar(iventario.getPlacar() - 10);
													iventario.getPlacarLb().setText(iventario.getPlacar()+"");
													iventario.setSegundos(iventario.getSegundos() + 5);
													sprite.setAparencia(10);
													 //audio.getEstouro().play();
												}
											}
											if(sprite2.isAtivo())
												if(iventario.getPlacar2() > 0) {
													if(sprite2.getTiros().contains(tiro))
													{
														iventario.setPlacar2(iventario.getPlacar2() - 10);
														iventario.getPlacarLb2().setText(iventario.getPlacar2()+"");
														iventario.setSegundos(iventario.getSegundos() + 5);
														sprite2.setAparencia(10);
														//audio.getEstouro().play();
													}
												}
											//iventario.setPlacar(iventario.getPlacar() - 10);
											//iventario.getPlacarLb().setText(iventario.getPlacar()+"");	
												
											
											iventario.setSegundos(iventario.getSegundos() - 10);
										//	sprite.setAparencia(10);
											sleep(100);
										
											
											

										} catch (Exception e) {
											// TODO: handle exception
										}
																			}

									
									try {
										if (bola.isAtivo()) {
											audio.getEstouro().play();
										}
										sleep(100);
									} catch (InterruptedException e) {

										e.printStackTrace();
									}
								}

								 
				

							}
						}

					}
					 
				}
			}


			}
		}

	


	public ArrayList<String> getQuestao() {
		return questao;
	}

	public String[] getTodos() {
		return todos;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getAtual() {
		return atual;
	}

	public void setAtual(int atual) {
		this.atual = atual;
	}

	public int getPulaFase() {
		return pulaFase;
	}

	public void setPulaFase(int pulaFase) {
		this.pulaFase = pulaFase;
	}

	public Personagem getSprite() {
		return sprite;
	}

	public Personagem getSprite2() {
		return sprite2;
	}

	public Map<Bolas, String> getBolas() {
		return bolas;
	}

	public boolean isDirecao() {
		return direcao;
	}

	public Audio getAudio() {
		return audio;
	}

	public Iventario getIventario() {
		return iventario;
	}

	public Map<String, Bolas> getBolastring() {
		return bolastring;
	}

	public List<Tiro> getTiros() {
		return tiros;
	}


	
	

}
