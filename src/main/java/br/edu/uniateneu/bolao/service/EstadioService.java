package br.edu.uniateneu.bolao.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.edu.uniateneu.bolao.cartola.Estadio;
import br.edu.uniateneu.bolao.cartola.Estadios;
import br.edu.uniateneu.bolao.model.EstadioEntity;
import br.edu.uniateneu.bolao.model.ResponseModel;
import br.edu.uniateneu.bolao.repository.EstadioRepository;
import br.edu.uniateneu.bolao.util.Constantes;

@RestController
@RequestMapping("/estadios")
public class EstadioService {
	
	@Autowired
	private EstadioRepository estadioRepository;
	
	@RequestMapping(value = "/preenche", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseModel preenche() {
		Gson gson = new Gson();
		try {
			File f = new File(Constantes.PATH_JSON + "estadios.json");

			BufferedReader br = new BufferedReader(new FileReader(f));
			String jsonTxt = "";
			String linha = "";
			while ((linha = br.readLine()) != null) {
				jsonTxt+=linha;
			}
			br.close();

			Estadios estadios = null; 
			estadios = gson.fromJson(jsonTxt, Estadios.class); 

			for (Object object : estadios.getEstadios()) {
				Estadio estadio = (Estadio) object;
				EstadioEntity estadioEntity = null;
				estadioEntity = estadio.converteEstadioParaEntidade();
				estadioRepository.save(estadioEntity);
				
			}
			
			return new ResponseModel(1, "Registro salvo com sucesso!");
			
		} catch (Exception e) {
			return new ResponseModel(0, e.getMessage());
		}
		
	}

}
