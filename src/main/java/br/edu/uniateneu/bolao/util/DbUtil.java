package br.edu.uniateneu.bolao.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.uniateneu.bolao.model.JogadorEntity;
import br.edu.uniateneu.bolao.model.PartidaEntity;
import br.edu.uniateneu.bolao.model.PosicaoEntity;
import br.edu.uniateneu.bolao.model.RodadaEntity;
import br.edu.uniateneu.bolao.model.TimeEntity;
import br.edu.uniateneu.bolao.repository.JogadorRepository;
import br.edu.uniateneu.bolao.repository.RodadaRepository;
import br.edu.uniateneu.bolao.repository.TimeRepository;

public class DbUtil {
/*	@Autowired
	private static TimeRepository timeDAO;
	@Autowired
	private static JogadorRepository jogadorDAO;
	@Autowired
	private static RodadaRepository rodadaDAO;

	public static JogadorEntity novoJogador(String nome, PosicaoEntity posicao, int idade, Double peso,
			int numeroCamisa, double altura, TimeEntity time) {
		JogadorEntity jogador = new JogadorEntity();
		jogador.setNome(nome);
		jogador.setPosicao(posicao);
		jogador.setIdade(idade);
		jogador.setPeso(peso);
		jogador.setNumeroCamisa(numeroCamisa);
		jogador.setAltura(altura);
		jogador.setTime(time);
		return jogador;
	}

	public static List<RodadaEntity> criaRodadas() {
		List<RodadaEntity> rodadas = new ArrayList<RodadaEntity>();
		for (int j = 1; j < 39; j++) {
			RodadaEntity rodada = new RodadaEntity();
			rodada.setNumero(j);
			rodadas.add(rodada);
		}
		return rodadas;
	}

	public static PartidaEntity novaPartida(TimeEntity mandante, TimeEntity visitante, Date data) {
		PartidaEntity partidaEntity = new PartidaEntity();
		partidaEntity.setMandante(mandante);
		partidaEntity.setVisitante(visitante);
		partidaEntity.setData(data);
		partidaEntity.setLocal(mandante.getEstadio());
		return partidaEntity;
	}

	public static void preencheEntidadaes() {

	
		List<JogadorEntity> elencoCAP = new ArrayList<JogadorEntity>();
		List<JogadorEntity> elencoCAM = new ArrayList<JogadorEntity>();
		List<JogadorEntity> elencoAVA = new ArrayList<JogadorEntity>();
		List<JogadorEntity> elencoBAH = new ArrayList<JogadorEntity>();
		List<JogadorEntity> elencoBFG = new ArrayList<JogadorEntity>();
		List<JogadorEntity> elencoCEA = new ArrayList<JogadorEntity>();
		List<JogadorEntity> elencoCHA = new ArrayList<JogadorEntity>();
		List<JogadorEntity> elencoCOR = new ArrayList<JogadorEntity>();
		List<JogadorEntity> elencoCRU = new ArrayList<JogadorEntity>();
		List<JogadorEntity> elencoCSA = new ArrayList<JogadorEntity>();
		List<JogadorEntity> elencoFLA = new ArrayList<JogadorEntity>();
		List<JogadorEntity> elencoFLU = new ArrayList<JogadorEntity>();
		List<JogadorEntity> elencoFOR = new ArrayList<JogadorEntity>();
		List<JogadorEntity> elencoGOI = new ArrayList<JogadorEntity>();
		List<JogadorEntity> elencoGRE = new ArrayList<JogadorEntity>();
		List<JogadorEntity> elencoINT = new ArrayList<JogadorEntity>();
		List<JogadorEntity> elencoPAL = new ArrayList<JogadorEntity>();
		List<JogadorEntity> elencoSAN = new ArrayList<JogadorEntity>();
		List<JogadorEntity> elencoSAO = new ArrayList<JogadorEntity>();
		List<JogadorEntity> elencoVAS = new ArrayList<JogadorEntity>();

		TimeEntity athleticoPR = new TimeEntity();
		athleticoPR.setNome("Athletico PR");
		athleticoPR.setEscudo("../../assets/icon/Athletico_Paranaense.svg");
		athleticoPR.setEstado("PR");
		athleticoPR.setEstadio("Arena da Baixada");
		athleticoPR.setSigla("CAP");
		athleticoPR.setElenco(elencoCAP);

		TimeEntity atleticoMG = new TimeEntity();
		atleticoMG.setNome("Atletico MG");
		atleticoMG.setEscudo("../../assets/icon/atletico-mg.svg");
		atleticoMG.setEstado("MG");
		atleticoMG.setEstadio("Mineirão");
		atleticoMG.setSigla("CAM");
		atleticoMG.setElenco(elencoCAM);

		TimeEntity avai = new TimeEntity();
		avai.setNome("Avai");
		avai.setEscudo("../../assets/icon/avai-futebol-clube.svg");
		avai.setEstado("SC");
		avai.setEstadio("Ressacada");
		avai.setSigla("AVA");
		avai.setElenco(elencoAVA);

		TimeEntity bahia = new TimeEntity();
		bahia.setNome("Bahia");
		bahia.setEscudo("../../assets/icon/bahia.svg");
		bahia.setEstado("BA");
		bahia.setEstadio("Fonte Nova");
		bahia.setSigla("BAH");
		bahia.setElenco(elencoBAH);

		TimeEntity botafogo = new TimeEntity();
		botafogo.setNome("Botafogo");
		botafogo.setEscudo("../../assets/icon/botafogo.svg");
		botafogo.setEstado("RJ");
		botafogo.setEstadio("Maracanã");
		botafogo.setSigla("BFG");
		botafogo.setElenco(elencoBFG);

		TimeEntity ceara = new TimeEntity();
		ceara.setNome("Ceara");
		ceara.setEscudo("../../assets/icon/ceara.svg");
		ceara.setEstado("CE");
		ceara.setEstadio("Castelão");
		ceara.setSigla("CEA");
		ceara.setElenco(elencoCEA);

		TimeEntity chapecoense = new TimeEntity();
		chapecoense.setNome("Chapecoense");
		chapecoense.setEscudo("../../assets/icon/chapecoense.svg");
		chapecoense.setEstado("SC");
		chapecoense.setEstadio("Arena Condá");
		chapecoense.setSigla("CHA");
		chapecoense.setElenco(elencoCHA);

		TimeEntity corinthians = new TimeEntity();
		corinthians.setNome("Corinthians");
		corinthians.setEscudo("../../assets/icon/corinthians.svg");
		corinthians.setEstado("SP");
		corinthians.setEstadio("Itaquerão");
		corinthians.setSigla("COR");
		corinthians.setElenco(elencoCOR);

		TimeEntity cruzeiro = new TimeEntity();
		cruzeiro.setNome("Cruzeiro");
		cruzeiro.setEscudo("../../assets/icon/cruzeiro.svg");
		cruzeiro.setEstado("MG");
		cruzeiro.setEstadio("Mineirão");
		cruzeiro.setSigla("CRU");
		cruzeiro.setElenco(elencoCRU);

		TimeEntity csa = new TimeEntity();
		csa.setNome("CSA");
		csa.setEscudo("../../assets/icon/csa.svg");
		csa.setEstado("AL");
		csa.setEstadio("Rei Pelé");
		csa.setSigla("CSA");
		csa.setElenco(elencoCSA);

		TimeEntity flamengo = new TimeEntity();
		flamengo.setNome("Flamengo");
		flamengo.setEscudo("../../assets/icon/Flamengo.svg");
		flamengo.setEstado("RJ");
		flamengo.setEstadio("Maracanã");
		flamengo.setSigla("FLA");
		flamengo.setElenco(elencoFLA);

		TimeEntity fluminense = new TimeEntity();
		fluminense.setNome("Fluminense");
		fluminense.setEscudo("../../assets/icon/fluminense.svg");
		fluminense.setEstado("RJ");
		fluminense.setEstadio("Maracanã");
		fluminense.setSigla("FLU");
		fluminense.setElenco(elencoFLU);

		TimeEntity fortaleza = new TimeEntity();
		fortaleza.setNome("Fortaleza");
		fortaleza.setEscudo("../../assets/icon/fortaleza.svg");
		fortaleza.setEstado("CE");
		fortaleza.setEstadio("Castelão");
		fortaleza.setSigla("FOR");
		fortaleza.setElenco(elencoFOR);

		TimeEntity goias = new TimeEntity();
		goias.setNome("Goiás");
		goias.setEscudo("../../assets/icon/goias.svg");
		goias.setEstado("GO");
		goias.setEstadio("Serra Dourada");
		goias.setSigla("GOI");
		goias.setElenco(elencoGOI);

		TimeEntity gremio = new TimeEntity();
		gremio.setNome("Grêmio");
		gremio.setEscudo("../../assets/icon/gremio.svg");
		gremio.setEstado("RS");
		gremio.setEstadio("Arena do Grêmio");
		gremio.setSigla("GRE");
		gremio.setElenco(elencoGRE);

		TimeEntity internacional = new TimeEntity();
		internacional.setNome("Internacional");
		internacional.setEscudo("../../assets/icon/internacional.svg");
		internacional.setEstado("RS");
		internacional.setEstadio("Beira Rio");
		internacional.setSigla("INT");
		internacional.setElenco(elencoINT);

		TimeEntity palmeiras = new TimeEntity();
		palmeiras.setNome("Palmeiras");
		palmeiras.setEscudo("../../assets/icon/palmeiras.svg");
		palmeiras.setEstado("SP");
		palmeiras.setEstadio("Allianz Parque");
		palmeiras.setSigla("PAL");
		palmeiras.setElenco(elencoPAL);

		TimeEntity santos = new TimeEntity();
		santos.setNome("Santos");
		santos.setEscudo("../../assets/icon/santos.svg");
		santos.setEstado("SP");
		santos.setEstadio("Vila Belmiro");
		santos.setSigla("SAN");
		santos.setElenco(elencoSAN);

		TimeEntity saoPaulo = new TimeEntity();
		saoPaulo.setNome("São Paulo");
		saoPaulo.setEscudo("../../assets/icon/sao-paulo.svg");
		saoPaulo.setEstado("SP");
		saoPaulo.setEstadio("Morumbi");
		saoPaulo.setSigla("SAO");
		saoPaulo.setElenco(elencoSAO);

		TimeEntity vasco = new TimeEntity();
		vasco.setNome("Vasco");
		vasco.setEscudo("../../assets/icon/vasco.svg");
		vasco.setEstado("RJ");
		vasco.setEstadio("São Januário");
		vasco.setSigla("VAS");
		vasco.setElenco(elencoVAS);

		timeDAO.save(athleticoPR);
		timeDAO.save(atleticoMG);
		timeDAO.save(avai);
		timeDAO.save(bahia);
		timeDAO.save(botafogo);
		timeDAO.save(ceara);
		timeDAO.save(chapecoense);
		timeDAO.save(corinthians);
		timeDAO.save(cruzeiro);
		timeDAO.save(csa);
		timeDAO.save(flamengo);
		timeDAO.save(fluminense);
		timeDAO.save(fortaleza);
		timeDAO.save(goias);
		timeDAO.save(gremio);
		timeDAO.save(internacional);
		timeDAO.save(palmeiras);
		timeDAO.save(santos);
		timeDAO.save(saoPaulo);
		timeDAO.save(vasco);
	}

	public static void main(String[] args) {

		DbUtil.preencheEntidadaes();
	}
*/
}
