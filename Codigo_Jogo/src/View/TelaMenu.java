package View;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.UIManager;

public class TelaMenu  extends PanelGeral{
	
	private JButton btJoga,btContinuar, btSair, btPontuacao;
	private JLabel img;
	public TelaMenu() {
		
		setLayout(null);
		 
		btJoga = new JButton(new ImageIcon(getClass().getClassLoader().getResource("balaoRed.png")));
		btJoga.setBounds(548, 200, 156, 200);
		btJoga.setBorder(null);
		btJoga.setBorderPainted(false);
		btJoga.setContentAreaFilled(false);
		btJoga.setOpaque(false);
		btJoga.setBackground(null);
		add(btJoga);
		
		btPontuacao = new JButton(new ImageIcon(getClass().getClassLoader().getResource("balaoAzul.png")));
		btPontuacao.setBounds(740, 220, 120, 200);
		btPontuacao.setBorderPainted(false);
		btPontuacao.setContentAreaFilled(false);
		btPontuacao.setOpaque(false);
		btPontuacao.setBackground(null);
		add(btPontuacao);
		
		

		btSair = new JButton(new ImageIcon(getClass().getClassLoader().getResource("balaoVerde.png")));
		btSair.setBounds(680, 300, 75, 125);
		btSair.setBorder(null);
		btSair.setBorderPainted(false);
		btSair.setOpaque(false);
		btSair.setContentAreaFilled(false);
		btSair.setBackground(null);
		add(btSair);
		
		btContinuar = new JButton("Creditos");
		btContinuar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btContinuar.setBounds(263, 203, 161, 49);
		//add(btContinuar);
		
		
		
		img = new JLabel( new ImageIcon(getClass().getClassLoader().getResource("menu.jpg")));
		img.setBounds(0, 0, 900, 480);
		add(img);
		
		
	}

	public JButton getBtJoga() {
		return btJoga;
	}

	public JButton getBtContinuar() {
		return btContinuar;
	}

	public JButton getBtSair() {
		return btSair;
	}

	public JButton getBtPontuacao() {
		return btPontuacao;
	}

	public void setBtPontuacao(JButton btPontuacao) {
		this.btPontuacao = btPontuacao;
	}

	public JLabel getImg() {
		return img;
	}
	 
	

}
