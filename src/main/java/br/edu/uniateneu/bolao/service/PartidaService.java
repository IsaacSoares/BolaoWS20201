package br.edu.uniateneu.bolao.service;

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

import br.edu.uniateneu.bolao.model.PartidaEntity;
import br.edu.uniateneu.bolao.model.ResponseModel;
import br.edu.uniateneu.bolao.repository.PartidaRepository;

@RestController
@RequestMapping("/partidas")
public class PartidaService {
	
	@Autowired
	private PartidaRepository partidaRepository;
	
	@Produces("application/json")
	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public @ResponseBody List<PartidaEntity> consultar() {
		return this.partidaRepository.findAll();
	}
	
	@Consumes("application/json")
	@Produces("application/json")
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public @ResponseBody ResponseModel salvar(@RequestBody PartidaEntity partida) {

		try {

			this.partidaRepository.save(partida);

			return new ResponseModel(1, "Registro salvo com sucesso!");

		} catch (Exception e) {

			return new ResponseModel(0, e.getMessage());
		}
	}
	
	@Produces("application/json")
	@RequestMapping(value = "/deletar/{codigo}", method = RequestMethod.DELETE)
	public @ResponseBody ResponseModel excluir(@PathVariable("codigo") Long codigo) {

		PartidaEntity partidaEntity = partidaRepository.getOne(codigo);

		try {

			partidaRepository.delete(partidaEntity);

			return new ResponseModel(1, "Registro excluido com sucesso!");

		} catch (Exception e) {
			return new ResponseModel(0, e.getMessage());
		}
	}
	
	@Consumes("application/json")
	@Produces("application/json")
	@RequestMapping(value = "/atualizar", method = RequestMethod.PUT)
	public @ResponseBody ResponseModel atualizar(@RequestBody PartidaEntity partida) {

		try {

			this.partidaRepository.save(partida);

			return new ResponseModel(1, "Registro atualizado com sucesso!");

		} catch (Exception e) {

			return new ResponseModel(0, e.getMessage());
		}
	}
}
