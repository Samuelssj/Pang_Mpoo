package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import model.Jogador;

public class Iventario extends PanelGeral {

	private JButton voltar;
	private JLabel tempo, nomeTempo, pontuacao, placarLb,faseLb,faseNumeracaoLb,objetivoLB,imagemObj,obgLB;
	private JLabel pontuacao2, placarLb2;
	private int segundos = 50;
	private int placar = 0;
	private int placar2 = 0;
	private int contadorFase = 1;
	private boolean loop = true;
	private JLabel nomeJogador;
	private JLabel nomeJogador2;
	private BufferedImage fundoBloco;
	
	private boolean blocos;
	
	public Iventario() {
		super();
		blocos = false;
		setLayout(null);
		voltar = new JButton("Sair");
		nomeTempo = new JLabel("Tempo");
		tempo = new JLabel();
		
		pontuacao = new JLabel("Pontuação: ");
		placarLb = new JLabel("0");
		
		pontuacao2 = new JLabel("Pontuação2: ");
		placarLb2 = new JLabel("0");
		

		setBackground(Color.black);
		voltar.setFont(new Font("serif", Font.BOLD, 14));
		voltar.setBackground(Color.BLACK);
		voltar.setFocusable(false);
		voltar.setBounds(40, 370, 150, 84);
		voltar.setBorder(null);
		voltar.setBorderPainted(false);
		voltar.setContentAreaFilled(false);
		voltar.setOpaque(false);
		voltar.setBackground(null);
		voltar.setBorderPainted(false);
		voltar.setForeground(Color.YELLOW);

		nomeTempo.setBounds(50, 80, 180, 200);
		nomeTempo.setFont(new Font("serif", Font.BOLD, 15));
		nomeTempo.setForeground(Color.WHITE);

		tempo.setBounds(68,80, 290, 240);
		tempo.setFont(new Font("serif", Font.BOLD, 20));
		tempo.setForeground(Color.YELLOW);

		pontuacao.setBounds(5, 40, 100, 80);
		pontuacao.setFont(new Font("serif", Font.BOLD, 15));
		pontuacao.setForeground(Color.WHITE);
		
		pontuacao2.setBounds(5, 90, 100, 80);
		pontuacao2.setFont(new Font("serif", Font.BOLD, 15));
		pontuacao2.setForeground(Color.WHITE);


		placarLb.setBounds(100, 40, 100, 80);
		placarLb.setFont(new Font("serif", Font.BOLD, 15));
		placarLb.setForeground(Color.RED);

		placarLb2.setBounds(100, 90, 100, 80);
		placarLb2.setFont(new Font("serif", Font.BOLD, 15));
		placarLb2.setForeground(Color.RED);
		
		
		faseLb = new JLabel("Fase");
		faseLb.setBounds(50,10, 100, 20);
		faseLb.setFont(new Font("serif", Font.BOLD, 20));
		faseLb.setForeground(Color.yellow);
		
		
		
		faseNumeracaoLb = new JLabel(" 1 ");
		faseNumeracaoLb.setBounds(100,10, 100, 20);
		faseNumeracaoLb.setFont(new Font("serif", Font.BOLD, 20));
		faseNumeracaoLb.setForeground(Color.MAGENTA);
		
		nomeJogador = new JLabel();
		nomeJogador.setBounds(5,50,100,20);
		nomeJogador.setFont(new Font("serif", Font.BOLD, 15));
		nomeJogador.setForeground(Color.BLUE);
		

		nomeJogador2 = new JLabel();
		nomeJogador2.setBounds(5,100,100,20);
		nomeJogador2.setFont(new Font("serif", Font.BOLD, 15));
		nomeJogador2.setForeground(Color.GREEN);
		
		
		obgLB = new JLabel();
		obgLB.setBounds(5,170,310,240);
		obgLB.setFont(new Font("serif", Font.BOLD, 15));
		obgLB.setForeground(Color.GREEN);
		
		fundoBloco = new BufferedImage(140, 133, BufferedImage.TYPE_4BYTE_ABGR);
		imagemObj = new JLabel() {;
		@Override
		protected void paintComponent(Graphics g) {
			g.drawImage(fundoBloco, 0, 0, null);
//			super.paintComponent(g);
		}};
	
		imagemObj.setBounds(5, 240, 140, 133);
		
		add(obgLB);
		add(imagemObj);
		add(voltar);
		add(nomeTempo);
		add(tempo);
		add(pontuacao);
		add(placarLb);
		add(pontuacao2);
		add(placarLb2);
		add(faseLb);
		add(faseNumeracaoLb);
		add(nomeJogador);
		add(nomeJogador2);
		//setVisible(true);

	
	}
	
	

	public BufferedImage getFundoBloco() {
		return fundoBloco;
	}

	public void setFundoBloco(BufferedImage fundoBloco) {
		this.fundoBloco = fundoBloco;
	}

	public JButton getVoltar() {
		return voltar;
	}

	public void setVoltar(JButton voltar) {
		this.voltar = voltar;
	}

	public JLabel getTempo() {
		return tempo;
	}

	public void setTempo(JLabel tempo) {
		this.tempo = tempo;
	}

	public int getSegundos() {
		return segundos;
	}

	public void setSegundos(int segundos) {
		this.segundos = segundos;
	}

	public JLabel getNomeTempo() {
		return nomeTempo;
	}

	public void setNomeTempo(JLabel nomeTempo) {
		this.nomeTempo = nomeTempo;
	}

	public JLabel getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(JLabel pontuacao) {
		this.pontuacao = pontuacao;
	}

	public JLabel getPlacarLb() {
		return placarLb;
	}

	public void setPlacarLb(JLabel placarLb) {
		this.placarLb = placarLb;
	}

	public int getPlacar() {
		return placar;
	}

	public void setPlacar(int placar) {
		this.placar = placar;
	}

	public JLabel getFaseLb() {
		return faseLb;
	}

	public void setFaseLb(JLabel faseLb) {
		this.faseLb = faseLb;
	}

	public JLabel getFaseNumeracaoLb() {
		return faseNumeracaoLb;
	}

	public void setFaseNumeracaoLb(JLabel faseNumeracaoLb) {
		this.faseNumeracaoLb = faseNumeracaoLb;
	}

	public int getContadorFase() {
		return contadorFase;
	}

	public void setContadorFase(int contadorFase) {
		this.contadorFase = contadorFase;
	}

	public boolean isLoop() {
		return loop;
	}

	public void setLoop(boolean loop) {
		this.loop = loop;
	}

	public JLabel getNomeJogador() {
		return nomeJogador;
	}

	public void setNomeJogador(JLabel nomeJogador) {
		this.nomeJogador = nomeJogador;
	}

	public JLabel getObjetivoLB() {
		return objetivoLB;
	}

	public void setObjetivoLB(JLabel objetivoLB) {
		this.objetivoLB = objetivoLB;
	}

	public JLabel getImagemObj() {
		return imagemObj;
	}

	public void setImagemObj(JLabel imagemObj) {
		this.imagemObj = imagemObj;
	}

	public JLabel getObgLB() {
		return obgLB;
	}

	public void setObgLB(JLabel obgLB) {
		this.obgLB = obgLB;
	}



	public JLabel getPontuacao2() {
		return pontuacao2;
	}



	public JLabel getPlacarLb2() {
		return placarLb2;
	}



	public JLabel getNomeJogador2() {
		return nomeJogador2;
	}



	public int getPlacar2() {
		return placar2;
	}



	public void setPlacar2(int placar2) {
		this.placar2 = placar2;
	}
	public boolean isBlocos() {
		return blocos;
	}
	public void setBlocos(boolean blocos) {
		this.blocos = blocos;
	}
	
	
	
	 
}
