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

import br.edu.uniateneu.bolao.model.GolEntity;
import br.edu.uniateneu.bolao.model.ResponseModel;
import br.edu.uniateneu.bolao.repository.GolRepository;

@RestController
@RequestMapping("/gols")
public class GolService {
	
	@Autowired
	private GolRepository golRepository;
	
	@Produces("application/json")
	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public @ResponseBody List<GolEntity> consultar() {
		return this.golRepository.findAll();
	}
	
	@Consumes("application/json")
	@Produces("application/json")
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public @ResponseBody ResponseModel salvar(@RequestBody GolEntity gol) {

		try {

			this.golRepository.save(gol);

			return new ResponseModel(1, "Registro salvo com sucesso!");

		} catch (Exception e) {

			return new ResponseModel(0, e.getMessage());
		}
	}
	
	@Produces("application/json")
	@RequestMapping(value = "/deletar/{codigo}", method = RequestMethod.DELETE)
	public @ResponseBody ResponseModel excluir(@PathVariable("codigo") Long codigo) {

		GolEntity golEntity = golRepository.getOne(codigo);

		try {

			golRepository.delete(golEntity);

			return new ResponseModel(1, "Registro excluido com sucesso!");

		} catch (Exception e) {
			return new ResponseModel(0, e.getMessage());
		}
	}
	
	@Consumes("application/json")
	@Produces("application/json")
	@RequestMapping(value = "/atualizar", method = RequestMethod.PUT)
	public @ResponseBody ResponseModel atualizar(@RequestBody GolEntity gol) {

		try {

			this.golRepository.save(gol);

			return new ResponseModel(1, "Registro atualizado com sucesso!");

		} catch (Exception e) {

			return new ResponseModel(0, e.getMessage());
		}
	}

}
