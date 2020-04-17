package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

import javax.swing.JOptionPane;
import javax.swing.Timer;

import View.Fase;
import View.Iventario;
import View.Tela;
import View.TelaJogador;
import View.TelaMenu;
import View.TelaPontuacao;
import model.Audio;
import model.Bolas;
import model.FaseModel;
import model.Jogador;
import model.Personagem;
import model.Xml;


public class ControleBotao implements ActionListener {
	private TelaMenu menu;
	private ControleFase fase;
	private Tela tela;
	private TelaPontuacao telaPontuacao;
	private Iventario iventario;
	private Audio audio;
	private Timer timer;
	private TelaJogador telaJogador;
	private Jogador jogador,jogador2;
	private Xml arquivo;
	private ControleMovimento controleMovimento;
	
	

	public ControleBotao(ControleFase fase, Tela tela, Iventario iventario, ControleMovimento controleMovimento) {
		super();
		this.menu = tela.getTelaMenu();
		this.fase = fase;
		this.tela= tela;
		this.iventario = iventario;
		this.telaJogador = tela.getTelaJogador();
		this.telaPontuacao = tela.getTelaPontuacao();
		this.controleMovimento = controleMovimento;
	
		
		arquivo = new Xml();
		audio = new Audio();
		menu.getBtJoga().addActionListener(this);
		menu.getBtSair().addActionListener(this);
		iventario.getVoltar().addActionListener(this);
		telaJogador.getIniciarBt().addActionListener(this);
		menu.getBtPontuacao().addActionListener(this);
		telaPontuacao.getVoltarBT().addActionListener(this);
		telaJogador.getSairBt().addActionListener(this);
		
		
		
		timer = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (iventario.getSegundos() > 0) {
					iventario.setSegundos(iventario.getSegundos()-1);
					iventario.getTempo().setText(iventario.getSegundos() + "");
				} else {
					JOptionPane.showMessageDialog(null, "O tempo acabou");
					timer.stop();
					tela.getCardlayout().show(tela.getContentPane(), "m");	
					audio.getFase1().stop();
					audio.getMenu().loop();
					JogoPintura.stop();
					iventario.setSegundos(50);
					iventario.getTempo().setText("50");
					if(jogador != null) {
						jogador.setPlacar(iventario.getPlacar());
						arquivo.salvar(jogador);
					}
					if(jogador2 != null) {
						jogador2.setPlacar(iventario.getPlacar2());
						arquivo.salvar(jogador2);
					}
				}

			}
		});
		
		audio.getMenu().loop();
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == telaJogador.getIniciarBt()) {
			if(!telaJogador.getNomeTx().getText().trim().isEmpty()) {
			tela.getCardlayout().show(tela.getContentPane(), "f");
			jogador = new Jogador(0, telaJogador.getNomeTx().getText());
			iventario.getNomeJogador().setText("Jogador: "+jogador.getNome());
			fase.start();
			telaJogador.getNomeTx().setText("");
			audio.getMenu().stop();
			audio.getFase1().loop();
			
			iventario.setPlacar(0);
			
			iventario.getPlacarLb().setText("0");
			iventario.setContadorFase(1);
			iventario.getFaseNumeracaoLb().setText((iventario.getContadorFase()+ ""));
			telaJogador.setVisible(false);
			FaseModel.colidirBlocos(false);
			iventario.setBlocos(false);
			if(telaJogador.getHardRadio().isSelected()) {
				iventario.getTempo().setText("30");
				iventario.setSegundos(30);
			}else if(telaJogador.getMeioRadio().isSelected()) {
				iventario.getTempo().setText("50");
				iventario.setSegundos(50);
			}else {
				iventario.getTempo().setText("100");
				iventario.setSegundos(100);
			}

			//retorna a lista aos valores iniciais 
			controleMovimento.getQuestao().clear();
			for (int i = 0; i < 3; i++) {
				controleMovimento.getQuestao().add(controleMovimento.getTodos()[i]);
				
			}	
			
			
			Collections.shuffle(controleMovimento.getQuestao());
			controleMovimento.setAtual(0);
			ControleFase.cor = controleMovimento.getQuestao().get(0);
			controleMovimento.setIndex(1);
			controleMovimento.setPulaFase(30);
			
			int i = 1;
			for (Bolas bolas : fase.getBolas().keySet()) {
				bolas.setVelocidade(1);
				bolas.setX(80*i);
				i++;
				if(fase.getBolas().get(bolas).equals("GREEN") || fase.getBolas().get(bolas).equals("BLUE") || fase.getBolas().get(bolas).equals("RED"))
					bolas.setAtivo(true);
				
				else
					bolas.setAtivo(false);
			}
			
			
			timer.start();
			menu.setVisible(false);
			telaJogador.setVisible(false);
			iventario.setVisible(true);
		}
			else
				//JOptionPane.showMessageDialog(null, "Insira um nome de jogador", "Nome vazio",JOptionPane.OK_OPTION);
				telaJogador.getAvisoLB().setVisible(true);
			
			//quando tem jogador 2
			if(!telaJogador.getNomeTx2().getText().trim().isEmpty()) {
				
				jogador2 = new Jogador(0, telaJogador.getNomeTx2().getText());
				iventario.getNomeJogador2().setText("Jogador2: "+jogador2.getNome());
				telaJogador.getNomeTx2().setText("");
				iventario.setPlacar2(0);
				iventario.getPlacarLb2().setText("0");
				iventario.getNomeJogador2().setVisible(true);
				iventario.getPontuacao2().setVisible(true);
				iventario.getPlacarLb2().setVisible(true);
				controleMovimento.getSprite2().setAtivo(true);
				
				
		
			}else { // quando jogador2 n tiver
				iventario.getNomeJogador2().setVisible(false);
				iventario.getPontuacao2().setVisible(false);
				iventario.getPlacarLb2().setVisible(false);
				controleMovimento.getSprite2().setAtivo(false);
			
				
			}
		}
		
		
		if(e.getSource() == telaJogador.getSairBt()) {
			iventario.setVisible(false);
			telaJogador.setVisible(false);
			tela.getCardlayout().show(tela.getContentPane(), "m");
		}
		if(e.getSource() == iventario.getVoltar()) {
			tela.getCardlayout().show(tela.getContentPane(), "m");	
			audio.getFase1().stop();
			audio.getMenu().loop();
			JogoPintura.stop();
			menu.requestFocus();
			timer.stop();
			
			if(jogador != null) {
				jogador.setPlacar(iventario.getPlacar());
				arquivo.salvar(jogador);
			}
			if(jogador2 != null) {
				jogador2.setPlacar(iventario.getPlacar2());
				arquivo.salvar(jogador2);
			}
			iventario.setVisible(false);
			
		}
		
		if(e.getSource() == menu.getBtJoga()) {
			tela.getCardlayout().show(tela.getContentPane(), "j");
			iventario.setVisible(false);
			
		}
		if(e.getSource() == menu.getBtPontuacao()) {
			tela.getCardlayout().show(tela.getContentPane(), "p");
			String elemento = "";
			for (Jogador jog : arquivo.getJogadores()) {
				elemento += "Nome: "+ jog.getNome() + " pontuação: " + jog.getPlacar()+ "\n";
			}
			telaPontuacao.getArea().setText(elemento);
			iventario.setVisible(false);
		}
		if(e.getSource() == telaPontuacao.getVoltarBT()) {
			tela.getCardlayout().show(tela.getContentPane(), "m");
			telaPontuacao.setVisible(false);
			timer.stop();
			  
			
		}
		
		
		if(e.getSource() == menu.getBtSair()) {
			JogoPintura.stop();
			System.exit(0);
			timer.stop();
		}
	}
	
	
	
	
	

}
