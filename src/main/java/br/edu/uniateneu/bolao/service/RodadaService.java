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

import br.edu.uniateneu.bolao.cartola.Partida;
import br.edu.uniateneu.bolao.cartola.Rodada;
import br.edu.uniateneu.bolao.model.PartidaEntity;
import br.edu.uniateneu.bolao.model.ResponseModel;
import br.edu.uniateneu.bolao.model.RodadaEntity;
import br.edu.uniateneu.bolao.repository.PartidaRepository;
import br.edu.uniateneu.bolao.repository.RodadaRepository;
import br.edu.uniateneu.bolao.repository.TimeRepository;
import br.edu.uniateneu.bolao.util.Constantes;

@RestController
@RequestMapping("/rodadas")
public class RodadaService {

	@Autowired
	private RodadaRepository rodadaRepository;
	@Autowired
	private TimeRepository timeRepository;
	@Autowired
	private PartidaRepository partidaRepository;
	

	@RequestMapping(value = "/preenche", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel preencher() {
		
		for (int i = 1; i < 39; i++) {
			RodadaEntity rodadaEntity = new RodadaEntity();
			rodadaEntity.setNumero(i);
			rodadaRepository.save(rodadaEntity);
		}
		
		Gson gson = new Gson();
		try {

			for (int i = 1; i < 39; i++) {

				File f = new File(Constantes.PATH_JSON_RODADAS_2019 + i+".json");

				BufferedReader br = new BufferedReader(new FileReader(f));
				String jsonTxt = "";
				String linha = "";
				while ((linha = br.readLine()) != null) {
					jsonTxt += linha;
				}
				br.close();

			    Rodada rodada = null;
				rodada = gson.fromJson(jsonTxt, Rodada.class);
				
				for (Object object : rodada.getPartidas()) {
					Partida partida = (Partida) object;
					PartidaEntity entidade = partida.convertePartidaParaEntidade();
					entidade.setMandante(timeRepository.findTimeBySigla(partida.getEquipes().getMandante().getSigla()));;
					entidade.setVisitante(timeRepository.findTimeBySigla(partida.getEquipes().getVisitante().getSigla()));;
					/*partidas += "Adicionada a partida " + 
					partida.getEquipes().getMandante().getNome_popular() + " x " + 
					partida.getEquipes().getVisitante().getNome_popular() +"; \n";*/
					entidade.setRodada(rodadaRepository.findRodadaByNmRodada(i));
					partidaRepository.save(entidade);
				}
			}
			return new ResponseModel(1, "Registro salvo com sucesso!");

		} catch (Exception e) {
			return new ResponseModel(0, e.getMessage());
		}

	}

}
