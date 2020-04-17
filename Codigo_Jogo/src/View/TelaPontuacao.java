package View;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TelaPontuacao extends PanelGeral{

	private JButton voltarBT;
	private JTextArea area;
	private JLabel img, img2;
	
	
	
	public TelaPontuacao() {
		
		voltarBT = new JButton(new ImageIcon(getClass().getClassLoader().getResource("balaoRoxo.png")));
		area = new JTextArea();
		setLayout(null);
		JScrollPane scrollPane = new JScrollPane(area);
		
		add(scrollPane).setBounds(190, 270,300, 170);
		area.setBounds(20, 10,500, 500);
		
		
		voltarBT.setBorder(null);
		voltarBT.setBorderPainted(false);
		voltarBT.setContentAreaFilled(false);
		voltarBT.setOpaque(false);
		voltarBT.setBackground(null);
		add(voltarBT).setBounds(520,280, 156, 200); 
		
		img2 = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("Pontua.png")));
		add(img2).setBounds(145, 140, 425, 150);
		
		
		img = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("FundoPT.png")));
		add(img).setBounds(0, 0, 900, 480);
	}




	public JButton getVoltarBT() {
		return voltarBT;
	}




	public void setVoltarBT(JButton voltarBT) {
		this.voltarBT = voltarBT;
	}




	public JTextArea getArea() {
		return area;
	}




	public void setArea(JTextArea area) {
		this.area = area;
	}
	
	
	
	
}
