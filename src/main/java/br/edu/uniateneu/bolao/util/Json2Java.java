package br.edu.uniateneu.bolao.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.edu.uniateneu.bolao.cartola.Atletas;
import br.edu.uniateneu.bolao.cartola.Jogador;
import br.edu.uniateneu.bolao.cartola.Partida;

public class Json2Java {


	public static void transformaPartida() {
		Gson gson = new Gson();

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

	public void preencheJogador() {
		Gson gson = new Gson();
		try {

			File f = new File("C:/Ateneu/2019.2/Webservices/workspace/git/BolaoWS/src/main/java/br/edu/uniateneu/BolaoWS/cartola/jogador.json");
			//if (f.exists()){System.out.println("tem");}
			BufferedReader br = new BufferedReader(new FileReader(f));
			String jsonTxt = "";
			String linha = "";
			while ((linha = br.readLine()) != null) {
				//System.out.println(linha);
				jsonTxt+=linha;
			}
			br.close();

			Atletas atletas;// = new ArrayList<Jogador>(); 
			atletas = gson.fromJson(jsonTxt, Atletas.class); 
			
			/*for (Object object : atletas.getAtletas()) {
			Jogador jogador = (Jogador) object;
			//if (jogador.getApelido().equals("Yago Pikachu"))
			System.out.println(jogador.getNome());
		}*/
		} catch (Exception e) {

		}
	}

	public static void main(String[] args) {
		transformaPartida();
	}


}
