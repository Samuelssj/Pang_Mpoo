package View;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class TelaJogador extends PanelGeral {

	private JLabel nomeLb, nomeLb2, avisoLB, imagemLB;
	private JTextField nomeTx, nomeTx2;
	private JButton iniciarBt, sairBt, hardBT, easyBT,medioBT;
	private ButtonGroup tempoGrup;
	private JRadioButton hardRadio, meioRadio, easyRadio;

	public TelaJogador() {
		setSize(TelaGeral.LARGURA, TelaGeral.ALTURA);
		setLayout(null);

		hardBT = new JButton(new ImageIcon(getClass().getClassLoader().getResource("Hard.png")));
		hardBT.setBounds(500, 10, 60, 40);
		hardBT.setBorder(null);
		hardBT.setBorderPainted(false);
		hardBT.setContentAreaFilled(false);
		hardBT.setFocusPainted(false);
		
		hardBT.setOpaque(false);
		hardBT.setBackground(null);
		add(hardBT);

		hardRadio = new JRadioButton("Tempo 30s");
		tempoGrup = new ButtonGroup();
		tempoGrup.add(hardRadio);
		hardRadio.setBounds(500, 50, 100, 20);
		hardRadio.setBorder(null);
		hardRadio.setBorderPainted(false);
		hardRadio.setContentAreaFilled(false);
		hardRadio.setFocusPainted(false);
		;
		hardRadio.setOpaque(false);
		hardRadio.setBackground(null);
		add(hardRadio);
		
		
		medioBT = new JButton(new ImageIcon(getClass().getClassLoader().getResource("Medio.png")));
		medioBT.setBounds(400, 10, 60, 40);
		medioBT.setBorder(null);
		medioBT.setBorderPainted(false);
		medioBT.setContentAreaFilled(false);
		medioBT.setFocusPainted(false);
		
		medioBT.setOpaque(false);
		medioBT.setBackground(null);
		add(medioBT);
		

		meioRadio = new JRadioButton("Tempo 50s",true);
		tempoGrup.add(meioRadio);
		meioRadio.setBounds(400, 50, 100, 20);
		meioRadio.setBorder(null);
		meioRadio.setBorderPainted(false);
		meioRadio.setContentAreaFilled(false);
		meioRadio.setFocusPainted(false);
	
		meioRadio.setOpaque(false);
		meioRadio.setBackground(null);
		add(meioRadio);

		easyBT = new JButton(new ImageIcon(getClass().getClassLoader().getResource("Easy.png")));
		easyBT.setBounds(300, 10, 60, 40);
		easyBT.setBorder(null);
		easyBT.setBorderPainted(false);
		easyBT.setContentAreaFilled(false);
		easyBT.setFocusPainted(false);
		
		easyBT.setOpaque(false);
		easyBT.setBackground(null);
		add(easyBT);

		easyRadio = new JRadioButton("Tempo 100s");
		tempoGrup.add(easyRadio);
		easyRadio.setBounds(300, 50, 100, 20);
		easyRadio.setBorder(null);
		easyRadio.setBorderPainted(false);
		easyRadio.setContentAreaFilled(false);
		easyRadio.setFocusPainted(false);
		;
		easyRadio.setOpaque(false);
		easyRadio.setBackground(null);
		add(easyRadio);

		nomeLb = new JLabel("1 Jogador");
		nomeLb.setFont(new Font("Tahoma", Font.BOLD, 20));

		avisoLB = new JLabel("Nome de jogador vazio!!");
		avisoLB.setFont(new Font("Tahoma", Font.BOLD, 20));
		avisoLB.setForeground(Color.RED);

		nomeLb2 = new JLabel("2 Jogadores");
		nomeLb2.setFont(new Font("Tahoma", Font.BOLD, 20));

		nomeTx = new JTextField(8);
		nomeTx2 = new JTextField(8);

		sairBt = new JButton(new ImageIcon(getClass().getClassLoader().getResource("balaoRoxo.png")));
//		iniciarBt = new JButton("Iniciar");

		iniciarBt = new JButton(new ImageIcon(getClass().getClassLoader().getResource("JOGAR.png")));
		iniciarBt.setBounds(365, 30, 157, 250);
		iniciarBt.setBorder(null);
		iniciarBt.setBorderPainted(false);
		iniciarBt.setContentAreaFilled(false);
		iniciarBt.setFocusPainted(false);
		;
		iniciarBt.setOpaque(false);
		iniciarBt.setBackground(null);

		imagemLB = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("Jogador.png")));
		imagemLB.setBounds(0, 0, 900, 480);

		add(nomeLb).setBounds(200, 180, 150, 30);
		add(nomeLb2).setBounds(580, 180, 150, 30);
		add(nomeTx).setBounds(200, 210, 100, 30);
		add(nomeTx2).setBounds(580, 210, 100, 30);
		add(sairBt).setBounds(10, 300, 156, 200);
		sairBt.setBorder(null);
		sairBt.setBorderPainted(false);
		sairBt.setContentAreaFilled(false);
		sairBt.setOpaque(false);
		sairBt.setBackground(null);

		add(avisoLB).setBounds(320, 285, 300, 30);
		avisoLB.setVisible(false);

		add(iniciarBt);
		add(imagemLB);

		setVisible(false);
	}

	public JLabel getNomeLb() {
		return nomeLb;
	}

	public void setNomeLb(JLabel nomeLb) {
		this.nomeLb = nomeLb;
	}

	public JLabel getImagemLB() {
		return imagemLB;
	}

	public void setImagemLB(JLabel imagemLB) {
		this.imagemLB = imagemLB;
	}

	public JTextField getNomeTx() {
		return nomeTx;
	}

	public void setNomeTx(JTextField nomeTx) {
		this.nomeTx = nomeTx;
	}

	public JButton getIniciarBt() {
		return iniciarBt;
	}

	public void setIniciarBt(JButton iniciarBt) {
		this.iniciarBt = iniciarBt;
	}

	public JButton getSairBt() {
		return sairBt;
	}

	public void setSairBt(JButton sairBt) {
		this.sairBt = sairBt;
	}

	public JLabel getNomeLb2() {
		return nomeLb2;
	}

	public JLabel getAvisoLB() {
		return avisoLB;
	}

	public JTextField getNomeTx2() {
		return nomeTx2;
	}

	public JRadioButton getHardRadio() {
		return hardRadio;
	}

	public void setHardRadio(JRadioButton hardRadio) {
		this.hardRadio = hardRadio;
	}

	public JRadioButton getMeioRadio() {
		return meioRadio;
	}

	public void setMeioRadio(JRadioButton meioRadio) {
		this.meioRadio = meioRadio;
	}

	public JRadioButton getEasyRadio() {
		return easyRadio;
	}

	public void setEasyRadio(JRadioButton easyRadio) {
		this.easyRadio = easyRadio;
	}

	

}
