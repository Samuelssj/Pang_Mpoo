package View;

public class Tela extends TelaGeral {

	
	private TelaMenu telaMenu;
	private Fase fase;
	private TelaJogador telaJogador;
	private TelaPontuacao telaPontuacao;
	

	public Tela() {
		
		telaMenu = new TelaMenu();
		fase = new Fase();
		telaJogador = new TelaJogador();
		telaPontuacao = new TelaPontuacao();
		
		 add(telaMenu, "m");
		 add(fase, "f");
		 add(telaJogador, "j");
		 add(telaPontuacao ,"p");
		 
		 getCardlayout().show(getContentPane(), "m");
		 fase.getIventario().setVisible(false);
		 
		 
	}
	
	
	
	public Fase getFase() {
		return fase;
	}



	public TelaMenu getTelaMenu() {
		return telaMenu;
	}



	public TelaJogador getTelaJogador() {
		return telaJogador;
	}



	public TelaPontuacao getTelaPontuacao() {
		return telaPontuacao;
	}



	public void setTelaPontuacao(TelaPontuacao telaPontuacao) {
		this.telaPontuacao = telaPontuacao;
	}

	
	
}
