package View;

import java.awt.CardLayout;

import javax.swing.JFrame;

public abstract class TelaGeral extends JFrame {
	
	public static final int LARGURA = 900, ALTURA = 450; 
	private CardLayout cardlayout;
	public TelaGeral() {
		super("Estoure A Bola!!");
	
		cardlayout = new CardLayout();
		setSize(LARGURA, ALTURA);
		setLayout(cardlayout);
		
		setUndecorated(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLocationRelativeTo(null);
		
		setVisible(false);
	}
	public CardLayout getCardlayout() {
		return cardlayout;
	}
	
	
}
