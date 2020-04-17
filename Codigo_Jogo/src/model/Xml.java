package model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;

public class Xml {

	private List<Jogador> jogadores;
	private XStream xStream;
	private File file;

	public Xml() {

		xStream = new XStream(new Dom4JDriver());
		xStream.alias("Jogador", Jogador.class);
		
		
		file = new File("res/ranque.xml");
		jogadores = ler();
	}

	public void salvar(Jogador jogador) {
		
		if(jogadores.size() >= 10)
			jogadores.remove(0);
		jogadores.add(jogador);

		try {
			if (!file.exists())
				file.createNewFile();
			else {
				file.delete();
				file.createNewFile();
			}
			
			OutputStream stream = new FileOutputStream(file);
			xStream.toXML(jogadores, stream);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	public List<Jogador> ler()
	{
		try {
			if (!file.exists())
				file.createNewFile();
			else {
				return (List<Jogador>) xStream.fromXML(file);				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
		
	}

	public List<Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

	public XStream getxStream() {
		return xStream;
	}

	public File getFile() {
		return file;
	}
	

	
}
