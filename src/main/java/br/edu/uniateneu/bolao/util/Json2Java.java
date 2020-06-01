package br.edu.uniateneu.bolao.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.edu.uniateneu.bolao.cartola.Partida;


public class Json2Java {

		
	
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
		
	}
	
	public void preencheTimes() {
		
	}
	
	public void preencheJogador() {
		
	}

	public static void main(String[] args) {
		Json2Java j2j = new Json2Java();
		j2j.preenchePosicoes();
	}


}
