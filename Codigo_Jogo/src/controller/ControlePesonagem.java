package controller;

import model.Personagem;

public class ControlePesonagem implements Runnable{

	private Personagem personagem;
	public static String mover1, mover2;
	private int player;
	
		
	public ControlePesonagem(Personagem personagem, int player) {
		super();
		this.personagem = personagem;
		this.player = player;
		mover1 = "";
		mover2 = "";
		new Thread(this).start();;
	}

	@Override
	public void run() {
		while(true) {
			
			if(player == 1) {
				personagem.mover(mover1); 
			
			}else if(player == 2){
				personagem.mover(mover2);
		

			}
			personagem.cair();
		
			try {
				Thread.sleep(50);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}

}
