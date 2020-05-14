package br.edu.uniateneu.bolao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.uniateneu.bolao.model.PosicaoEntity;
import br.edu.uniateneu.bolao.model.ResponseModel;
import br.edu.uniateneu.bolao.repository.PosicaoRepository;

@RestController
@RequestMapping("/posicoes")
public class PosicaoService {

	@Autowired
	private PosicaoRepository posicaoRepository;


	@RequestMapping(value = "/preenche", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel preencher() {
		try {
			PosicaoEntity p1 = new PosicaoEntity();
			p1.setAbreviacao("gol");
			p1.setNome("Goleiro");
			p1.setCdGlobo(1L);
			posicaoRepository.save(p1);
			PosicaoEntity p2 = new PosicaoEntity();
			p2.setAbreviacao("lat");
			p2.setNome("Lateral");
			p2.setCdGlobo(2L);
			posicaoRepository.save(p2);
			PosicaoEntity p3 = new PosicaoEntity();
			p3.setAbreviacao("zag");
			p3.setNome("Zagueiro");
			p3.setCdGlobo(3L);
			posicaoRepository.save(p3);
			PosicaoEntity p4 = new PosicaoEntity();
			p4.setAbreviacao("mei");
			p4.setNome("Meia");
			p4.setCdGlobo(4L);
			posicaoRepository.save(p4);
			PosicaoEntity p5 = new PosicaoEntity();
			p5.setAbreviacao("ata");
			p5.setNome("Atacante");
			p5.setCdGlobo(5L);
			posicaoRepository.save(p5);
			PosicaoEntity p6 = new PosicaoEntity();
			p6.setAbreviacao("tec");
			p6.setNome("Técnico");
			p6.setCdGlobo(6L);
			posicaoRepository.save(p6);

			return new ResponseModel(1, "Registro salvo com sucesso!");

		} catch (Exception e) {

			return new ResponseModel(0, e.getMessage());
		}


	}

}
