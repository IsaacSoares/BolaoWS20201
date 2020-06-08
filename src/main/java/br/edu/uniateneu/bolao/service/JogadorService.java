package br.edu.uniateneu.bolao.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
import br.edu.uniateneu.bolao.util.StringUtil;

@RestController
@RequestMapping("/jogadores")
public class JogadorService {

	@Autowired
	private JogadorRepository jogadorRepository;
	@Autowired
	private PosicaoRepository posicaoRepository;
	@Autowired
	private TimeRepository timeRepository;


	@Produces("application/json")
	@RequestMapping(value = "/preenche", method = RequestMethod.GET)
	public @ResponseBody ResponseModel preencher() {
		Gson gson = new Gson();
		try {
			File f = new File(Constantes.PATH_JSON + "jogador.json");

			BufferedReader br = new BufferedReader(new FileReader(f));
			String jsonTxt = "";
			String linha = "";
			while ((linha = br.readLine()) != null) {
				jsonTxt += linha;
			}
			br.close();
			jsonTxt = StringUtil.decodificarUTF8(jsonTxt);
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

	@Produces("application/json")
	@RequestMapping(value = "/jogadoresPorPosicaoTime/{siglaTime}/{siglaPosicao}", method = RequestMethod.GET)
	public @ResponseBody ArrayList<JogadorEntity> buscar(@PathVariable("siglaTime") String siglaTime,
			@PathVariable("siglaPosicao") String siglaPosicao) {

		return this.jogadorRepository.findJogadorBySiglaNomeTime(siglaPosicao, siglaTime);
	}
	
	@Produces("application/json")
	@RequestMapping(value = "/jogadoresPorApelido/{apelido}", method = RequestMethod.GET)
	public @ResponseBody ArrayList<JogadorEntity> buscarPorApelido(@PathVariable("apelido") String apelido) {
		List<JogadorEntity> jogadores = jogadorRepository.findAll();
		ArrayList<JogadorEntity> jogadoresEncontrados = new ArrayList<JogadorEntity>();
		for (JogadorEntity jogadorEntity : jogadores) {
			if(jogadorEntity.getApelido().toUpperCase().contains(apelido.toUpperCase())) {
				jogadoresEncontrados.add(jogadorEntity);
			}
		}
		return jogadoresEncontrados;
	}

	
	@Produces("application/json")
	@RequestMapping(value = "/jogadoresPorApelidoBanco/{apelido}", method = RequestMethod.GET)
	public @ResponseBody ArrayList<JogadorEntity> buscarPorApelidoBanco(@PathVariable("apelido") String apelido) {
		return jogadorRepository.findJogadorByApelido(apelido.toUpperCase());
	}
	
	@Consumes("application/json")
	@Produces("application/json")
	@RequestMapping(value = "/jogador", method = RequestMethod.POST)
	public @ResponseBody ResponseModel salvar(@RequestBody JogadorEntity jogador) {

		try {

			this.jogadorRepository.save(jogador);

			return new ResponseModel(1, "Registro salvo com sucesso!");

		} catch (Exception e) {

			return new ResponseModel(0, e.getMessage());
		}
	}

	@Consumes("application/json")
	@RequestMapping(value = "/jogador", method = RequestMethod.PUT)
	public @ResponseBody ResponseModel atualizar(@RequestBody JogadorEntity jogador) {

		try {

			this.jogadorRepository.save(jogador);

			return new ResponseModel(1, "Registro atualizado com sucesso!");

		} catch (Exception e) {

			return new ResponseModel(0, e.getMessage());
		}
	}

	@Produces("application/json")
	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public @ResponseBody List<JogadorEntity> consultar() {

		return this.jogadorRepository.findAll();
	}

	@Produces("application/json")
	@RequestMapping(value = "/jogador/{codigo}", method = RequestMethod.GET)
	public @ResponseBody JogadorEntity buscar(@PathVariable("codigo") Long codigo) {

		return this.jogadorRepository.getOne(codigo);
	}

	@Produces("application/json")
	@RequestMapping(value = "/jogador/{codigo}", method = RequestMethod.DELETE)
	public @ResponseBody ResponseModel excluir(@PathVariable("codigo") Long codigo) {

		JogadorEntity jogadorEntity = jogadorRepository.getOne(codigo);

		try {

			jogadorRepository.delete(jogadorEntity);

			return new ResponseModel(1, "Registro excluido com sucesso!");

		} catch (Exception e) {
			return new ResponseModel(0, e.getMessage());
		}
	}

}
