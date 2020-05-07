package br.edu.uniateneu.bolao.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.edu.uniateneu.bolao.cartola.Clubes;
import br.edu.uniateneu.bolao.cartola.Time;
import br.edu.uniateneu.bolao.model.JogadorEntity;
import br.edu.uniateneu.bolao.model.ResponseModel;
import br.edu.uniateneu.bolao.model.TimeEntity;
import br.edu.uniateneu.bolao.repository.TimeRepository;

@RestController
@RequestMapping("/times")
public class TimeService {
	private static final String PATH_JSON = "C:\\Ateneu\\2020.1\\webservice\\workspace\\bolaows20201\\src\\main\\resources\\json\\";

	@Autowired
	private TimeRepository timeRepository;
	
	@RequestMapping(value = "/preenche", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel preenche() {
		Gson gson = new Gson();
		try {
			File f = new File(PATH_JSON + "clubes.json");

			BufferedReader br = new BufferedReader(new FileReader(f));
			String jsonTxt = "";
			String linha = "";
			while ((linha = br.readLine()) != null) {
				jsonTxt+=linha;
			}
			br.close();

			Clubes clubes = null; 
			clubes = gson.fromJson(jsonTxt, Clubes.class); 

			for (Object object : clubes.getClubes()) {
				Time time = (Time) object;
				TimeEntity timeEntity = null;
				timeEntity = time.converteTimeParaEntidade();	
				//jogadorEntity.setPosicao(posicaoRepository.getOne(jogador.getPosicao().getId()));
				//jogadorEntity.setTime(timeRepository.);
				timeRepository.save(timeEntity);
				
			}
			
			return new ResponseModel(1, "Registro salvo com sucesso!");
			
		} catch (Exception e) {
			return new ResponseModel(0, e.getMessage());
		}
	}
		
	@RequestMapping(value = "/preencher", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel preencher() {
		try {
			TimeEntity athleticoPR = new TimeEntity();
			athleticoPR.setNome("Athletico PR");
			athleticoPR.setEscudo("../../assets/icon/Athletico_Paranaense.svg");
			athleticoPR.setEstado("PR");
			//athleticoPR.setEstadio("Arena da Baixada");
			athleticoPR.setSigla("CAP");

			TimeEntity atleticoMG = new TimeEntity();
			atleticoMG.setNome("Atletico MG");
			atleticoMG.setEscudo("../../assets/icon/atletico-mg.svg");
			atleticoMG.setEstado("MG");
			//atleticoMG.setEstadio("Mineirão");
			atleticoMG.setSigla("CAM");

			TimeEntity avai = new TimeEntity();
			avai.setNome("Avai");
			avai.setEscudo("../../assets/icon/avai-futebol-clube.svg");
			avai.setEstado("SC");
			//avai.setEstadio("Ressacada");
			avai.setSigla("AVA");

			TimeEntity bahia = new TimeEntity();
			bahia.setNome("Bahia");
			bahia.setEscudo("../../assets/icon/bahia.svg");
			bahia.setEstado("BA");
			//bahia.setEstadio("Fonte Nova");
			bahia.setSigla("BAH");

			TimeEntity botafogo = new TimeEntity();
			botafogo.setNome("Botafogo");
			botafogo.setEscudo("../../assets/icon/botafogo.svg");
			botafogo.setEstado("RJ");
			//botafogo.setEstadio("Maracanã");
			botafogo.setSigla("BFG");

			TimeEntity ceara = new TimeEntity();
			ceara.setNome("Ceara");
			ceara.setEscudo("../../assets/icon/ceara.svg");
			ceara.setEstado("CE");
			//ceara.setEstadio("Castelão");
			ceara.setSigla("CEA");

			TimeEntity chapecoense = new TimeEntity();
			chapecoense.setNome("Chapecoense");
			chapecoense.setEscudo("../../assets/icon/chapecoense.svg");
			chapecoense.setEstado("SC");
			//chapecoense.setEstadio("Arena Condá");
			chapecoense.setSigla("CHA");

			TimeEntity corinthians = new TimeEntity();
			corinthians.setNome("Corinthians");
			corinthians.setEscudo("../../assets/icon/corinthians.svg");
			corinthians.setEstado("SP");
			//corinthians.setEstadio("Itaquerão");
			corinthians.setSigla("COR");

			TimeEntity cruzeiro = new TimeEntity();
			cruzeiro.setNome("Cruzeiro");
			cruzeiro.setEscudo("../../assets/icon/cruzeiro.svg");
			cruzeiro.setEstado("MG");
			//cruzeiro.setEstadio("Mineirão");
			cruzeiro.setSigla("CRU");

			TimeEntity csa = new TimeEntity();
			csa.setNome("CSA");
			csa.setEscudo("../../assets/icon/csa.svg");
			csa.setEstado("AL");
			//csa.setEstadio("Rei Pelé");
			csa.setSigla("CSA");

			TimeEntity flamengo = new TimeEntity();
			flamengo.setNome("Flamengo");
			flamengo.setEscudo("../../assets/icon/Flamengo.svg");
			flamengo.setEstado("RJ");
			//flamengo.setEstadio("Maracanã");
			flamengo.setSigla("FLA");

			TimeEntity fluminense = new TimeEntity();
			fluminense.setNome("Fluminense");
			fluminense.setEscudo("../../assets/icon/fluminense.svg");
			fluminense.setEstado("RJ");
			//fluminense.setEstadio("Maracanã");
			fluminense.setSigla("FLU");

			TimeEntity fortaleza = new TimeEntity();
			fortaleza.setNome("Fortaleza");
			fortaleza.setEscudo("../../assets/icon/fortaleza.svg");
			fortaleza.setEstado("CE");
			//fortaleza.setEstadio("Castelão");
			fortaleza.setSigla("FOR");

			TimeEntity goias = new TimeEntity();
			goias.setNome("Goiás");
			goias.setEscudo("../../assets/icon/goias.svg");
			goias.setEstado("GO");
			//goias.setEstadio("Serra Dourada");
			goias.setSigla("GOI");

			TimeEntity gremio = new TimeEntity();
			gremio.setNome("Grêmio");
			gremio.setEscudo("../../assets/icon/gremio.svg");
			gremio.setEstado("RS");
			//gremio.setEstadio("Arena do Grêmio");
			gremio.setSigla("GRE");

			TimeEntity internacional = new TimeEntity();
			internacional.setNome("Internacional");
			internacional.setEscudo("../../assets/icon/internacional.svg");
			internacional.setEstado("RS");
			//internacional.setEstadio("Beira Rio");
			internacional.setSigla("INT");

			TimeEntity palmeiras = new TimeEntity();
			palmeiras.setNome("Palmeiras");
			palmeiras.setEscudo("../../assets/icon/palmeiras.svg");
			palmeiras.setEstado("SP");
			//palmeiras.setEstadio("Allianz Parque");
			palmeiras.setSigla("PAL");

			TimeEntity santos = new TimeEntity();
			santos.setNome("Santos");
			santos.setEscudo("../../assets/icon/santos.svg");
			santos.setEstado("SP");
			//santos.setEstadio("Vila Belmiro");
			santos.setSigla("SAN");

			TimeEntity saoPaulo = new TimeEntity();
			saoPaulo.setNome("São Paulo");
			saoPaulo.setEscudo("../../assets/icon/sao-paulo.svg");
			saoPaulo.setEstado("SP");
			//saoPaulo.setEstadio("Morumbi");
			saoPaulo.setSigla("SAO");

			TimeEntity vasco = new TimeEntity();
			vasco.setNome("Vasco");
			vasco.setEscudo("../../assets/icon/vasco.svg");
			vasco.setEstado("RJ");
			//vasco.setEstadio("São Januário");
			vasco.setSigla("VAS");

			TimeEntity sport = new TimeEntity();
			sport.setNome("Sport");
			sport.setEscudo("../../assets/icon/sport.svg");
			sport.setEstado("PE");
			//sport.setEstadio("Ilha do Retiro");
			sport.setSigla("SPO");

			TimeEntity atleticoGO = new TimeEntity();
			atleticoGO.setNome("Atlético Goianiense");
			atleticoGO.setEscudo("../../assets/icon/atleticoGO.svg");
			atleticoGO.setEstado("GO");
			//atleticoGO.setEstadio("Estádio Antonio Accioly");
			atleticoGO.setSigla("ATG");

			TimeEntity coritiba = new TimeEntity();
			coritiba.setNome("Coritiba");
			coritiba.setEscudo("../../assets/icon/atleticoGO.svg");
			coritiba.setEstado("PA");
			//coritiba.setEstadio("Couto Pereira");
			coritiba.setSigla("CTB");

			TimeEntity bragantino = new TimeEntity();
			bragantino.setNome("RedBull Bragantino");
			bragantino.setEscudo("../../assets/icon/bragantino.svg");
			bragantino.setEstado("SP");
			//bragantino.setEstadio("Nabi Abi Chedid");
			bragantino.setSigla("BRA");

			timeRepository.save(athleticoPR);
			timeRepository.save(atleticoMG);
			timeRepository.save(avai);
			timeRepository.save(bahia);
			timeRepository.save(botafogo);
			timeRepository.save(ceara);
			timeRepository.save(chapecoense);
			timeRepository.save(corinthians);
			timeRepository.save(cruzeiro);
			timeRepository.save(csa);
			timeRepository.save(flamengo);
			timeRepository.save(fluminense);
			timeRepository.save(fortaleza);
			timeRepository.save(goias);
			timeRepository.save(gremio);
			timeRepository.save(internacional);
			timeRepository.save(palmeiras);
			timeRepository.save(santos);
			timeRepository.save(saoPaulo);
			timeRepository.save(vasco);
			timeRepository.save(coritiba);
			timeRepository.save(atleticoGO);
			timeRepository.save(sport);
			timeRepository.save(bragantino);

			return new ResponseModel(1, "Registro salvo com sucesso!");

		} catch (Exception e) {
			return new ResponseModel(0, e.getMessage());
		}
	}
	
	
	@RequestMapping(value = "/todos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<TimeEntity> consultar() {
		return this.timeRepository.findAll();
	}
	
}