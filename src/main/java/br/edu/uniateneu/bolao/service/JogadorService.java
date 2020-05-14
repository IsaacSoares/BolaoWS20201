package br.edu.uniateneu.bolao.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.edu.uniateneu.bolao.cartola.Atletas;
import br.edu.uniateneu.bolao.cartola.Jogador;
import br.edu.uniateneu.bolao.model.JogadorEntity;
import br.edu.uniateneu.bolao.model.ResponseModel;
import br.edu.uniateneu.bolao.repository.JogadorRepository;
import br.edu.uniateneu.bolao.repository.PosicaoRepository;
import br.edu.uniateneu.bolao.repository.TimeRepository;
import br.edu.uniateneu.bolao.util.Constantes;

@RestController
@RequestMapping("/jogadores")
public class JogadorService {

	@Autowired
	private JogadorRepository jogadorRepository;
	@Autowired
	private PosicaoRepository posicaoRepository;
	@Autowired
	private TimeRepository timeRepository;
	
	@RequestMapping(value = "/preenche", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel preencher() {
		Gson gson = new Gson();
		try {
			File f = new File(Constantes.PATH_JSON + "jogador.json");

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
				System.out.println(jogador.getPosicao());
				
				JogadorEntity jogadorEntity = null;
				jogadorEntity = jogador.converteJogadorParaEntidade();
				jogadorEntity.setPosicao(posicaoRepository.findPosicaoByCdGlobo(jogador.getPosicao()));
				jogadorEntity.setTime(timeRepository.findTimeByCdGlobo(jogador.getClube_id()));
			
				jogadorRepository.save(jogadorEntity);
				
			}
			
			return new ResponseModel(1, "Registro salvo com sucesso!");
		
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseModel(0, e.toString());
		}
	}
}
