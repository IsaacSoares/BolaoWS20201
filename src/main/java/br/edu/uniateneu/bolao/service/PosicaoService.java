package br.edu.uniateneu.bolao.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

	@Produces("application/json")
	@RequestMapping(value = "/preenche", method = RequestMethod.GET)
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


	@Consumes("application/json")
	@Produces("application/json")
	@RequestMapping(value = "/posicao", method = RequestMethod.POST)
	public @ResponseBody ResponseModel salvar(@RequestBody PosicaoEntity posicao) {

		try {

			this.posicaoRepository.save(posicao);

			return new ResponseModel(1, "Registro salvo com sucesso!");

		} catch (Exception e) {

			return new ResponseModel(0, e.getMessage());
		}
	}

	@Consumes("application/json")
	@RequestMapping(value = "/posicao", method = RequestMethod.PUT)
	public @ResponseBody ResponseModel atualizar(@RequestBody PosicaoEntity posicao) {

		try {

			this.posicaoRepository.save(posicao);

			return new ResponseModel(1, "Registro atualizado com sucesso!");

		} catch (Exception e) {

			return new ResponseModel(0, e.getMessage());
		}
	}

	@Produces("application/json")
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public @ResponseBody List<PosicaoEntity> consultar() {

		return this.posicaoRepository.findAll();
	}

	@Produces("application/json")
	@RequestMapping(value = "/posicao/{codigo}", method = RequestMethod.GET)
	public @ResponseBody PosicaoEntity buscar(@PathVariable("codigo") Long codigo) {
		return (PosicaoEntity)(this.posicaoRepository.getOne(codigo));
	}
	@Produces("application/json")
	@RequestMapping(value = "/posicao/teste", method = RequestMethod.GET)	@ResponseBody
	public String getFoos(@RequestParam String cdGlobo) {
		return " - "+ cdGlobo;
	}
	
	
	@Produces("application/json")
	@RequestMapping(value = "/posicao/{codigo}", method = RequestMethod.DELETE)
	public @ResponseBody ResponseModel excluir(@PathVariable("codigo") Long codigo) {

		PosicaoEntity posicaoEntity = posicaoRepository.getOne(codigo);

		try {

			posicaoRepository.delete(posicaoEntity);

			return new ResponseModel(1, "Registro excluido com sucesso!");

		} catch (Exception e) {
			return new ResponseModel(0, e.getMessage());
		}
	}


}
