package br.edu.uniateneu.bolao.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.edu.uniateneu.bolao.cartola.Atletas;
import br.edu.uniateneu.bolao.cartola.Jogador;
import br.edu.uniateneu.bolao.cartola.Partida;
import br.edu.uniateneu.bolao.model.JogadorEntity;
import br.edu.uniateneu.bolao.model.PosicaoEntity;
import br.edu.uniateneu.bolao.repository.JogadorRepository;
import br.edu.uniateneu.bolao.repository.PosicaoRepository;
import br.edu.uniateneu.bolao.repository.RodadaRepository;
import br.edu.uniateneu.bolao.repository.TimeRepository;


public class Json2Java {

	@Autowired
	private TimeRepository timeDAO;
	@Autowired
	private JogadorRepository jogadorDAO;
	@Autowired
	private RodadaRepository rodadaDAO;
	@Autowired
	private PosicaoRepository posicaoDAO;
	
	
	
	public static String PATH_JSON = "C:\\Users\\loja\\git\\bolaows20201\\src\\main\\resources\\";
	public static String PATH_RODADAS_JSON = "C:\\Users\\loja\\git\\bolaows20201\\src\\main\\resources\\rodadas\\";
	
	public static void transformaPartida() {
		Gson gson = new Gson();
		for (int i = 0; i < 38; i++) {
			
		}
		File f = new File(
				"C:\\Users\\loja\\git\\bolaows20201\\src\\main\\resources\\rodadas\\2019\\1.json");
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(f));

			String jsonTxt = "";
			String linha = "";
			while ((linha = br.readLine()) != null) {
				jsonTxt += linha;
			}
			br.close();


			jsonTxt = StringUtil.decodificar(jsonTxt);
			List<Partida> partidasObj;
			Type usuariosListType = new TypeToken<ArrayList<Partida>>(){}.getType(); 
			partidasObj = gson.fromJson(jsonTxt, usuariosListType);

			for (Partida partida : partidasObj) {
				System.out.println("****************");
				System.out.println(partida.getEquipes().getMandante().getNome_popular());
				System.out.println(partida.getSede().getNome_popular());
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	public void preenchePosicoes() {
		PosicaoEntity p1 = new PosicaoEntity();
		p1.setAbreviacao("gol");
		p1.setNome("Goleiro");
		posicaoDAO.save(p1);
		PosicaoEntity p2 = new PosicaoEntity();
		p2.setAbreviacao("lat");
		p2.setNome("Lateral");
		posicaoDAO.save(p2);
		PosicaoEntity p3 = new PosicaoEntity();
		p3.setAbreviacao("zag");
		p3.setNome("Zagueiro");
		posicaoDAO.save(p3);
		PosicaoEntity p4 = new PosicaoEntity();
		p4.setAbreviacao("mei");
		p4.setNome("Meia");
		posicaoDAO.save(p4);
		PosicaoEntity p5 = new PosicaoEntity();
		p5.setAbreviacao("ata");
		p5.setNome("Atacante");
		posicaoDAO.save(p5);
		PosicaoEntity p6 = new PosicaoEntity();
		p6.setAbreviacao("tec");
		p6.setNome("Técnico");
		posicaoDAO.save(p6);	
	}
	
	public void preencheTimes() {
		
	}
	
	public void preencheJogador() {
		Gson gson = new Gson();
		try {
			File f = new File(PATH_JSON+"jogador.json");
		
			BufferedReader br = new BufferedReader(new FileReader(f));
			String jsonTxt = "";
			String linha = "";
			while ((linha = br.readLine()) != null) {
				jsonTxt+=linha;
			}
			br.close();

			Atletas atletas = null; 
			atletas = gson.fromJson(jsonTxt, Atletas.class); 
			
			for (Object object : atletas.getAtletas()) {
				Jogador jogador = (Jogador) object;
				JogadorEntity jogadorEntity = null;
				jogadorEntity = jogador.converteJogadorParaEntidade();
				jogadorEntity.setPosicao(posicaoDAO.getOne(jogador.getPosicao()));
				//jogador.setIdade(idade);
				//jogador.setPeso(peso);
				//jogador.setNumeroCamisa(numeroCamisa);
				//jogador.setAltura(altura);
				//jogador.setTime(time);*/
			}
		} catch (Exception e) {

		}
	}

	public static void main(String[] args) {
		Json2Java j2j = new Json2Java();
		j2j.preenchePosicoes();
	}


}
