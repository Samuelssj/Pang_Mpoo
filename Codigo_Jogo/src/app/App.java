package app;

import java.util.ArrayList;
import java.util.List;

import View.Fase;
import View.Iventario;
import View.Tela;
import View.TelaJogador;
import controller.ControleBotao;
import controller.ControleFase;
import controller.ControleMovimento;
import controller.ControlePesonagem;
import controller.ControleTeclado;
import model.FaseModel;
import model.Jogador;
import model.TileMap;
 
public class App {

	public static void main(String[] args) {
		///Samuel Junior
		FaseModel faseModel = new FaseModel();
		
		List<TileMap>listaCamada = new ArrayList<>();
		
		listaCamada.add(faseModel.getCamada_fundo());
		listaCamada.add(faseModel.getCamada_montanha());
		listaCamada.add(faseModel.getCamada_terra());
		listaCamada.add(faseModel.getCamada_detalhe());
		listaCamada.add(faseModel.getCamada_blocos());
		
		Tela tela = new Tela();
		Fase fase = tela.getFase();
		tela.setVisible(true);
		fase.setVisible(true);
		fase.getIventario().setVisible(false);
		
		ControleFase controleFase = new ControleFase(fase, listaCamada,faseModel.getBoneco(),faseModel.getBoneco2(),faseModel.getBolas());
		new ControleTeclado(faseModel.getBoneco(),fase);
		ControleMovimento movimentocontrole = new ControleMovimento(faseModel.getBoneco(),faseModel.getBolas(),fase.getIventario(),faseModel.getBolastring(),faseModel.getBoneco2());
		new ControleBotao(controleFase, tela, fase.getIventario(),movimentocontrole);
        new ControlePesonagem(faseModel.getBoneco(), 1); 
        new ControlePesonagem(faseModel.getBoneco2(), 2);
		
	}
	
}
