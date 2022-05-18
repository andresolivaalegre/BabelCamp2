package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import model.Pais;
import service.PaisService;

@CrossOrigin("*")
@RestController
public class PaisController {
	@Autowired
	PaisService service;
	
	@ApiOperation(value="Devuelve una lista con los datos de los continentes")
	@GetMapping(value="Continentes",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> continentes() {
		return service.continentes();
	}
	
	@ApiOperation(value="Devuelve una lista con los paises de los continentes")
	@GetMapping(value="Paises/{continente}",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Pais> paisesContinente(@ApiParam("Nombre del continente a buscar")@PathVariable("continente") String continente){
		return service.paisesPorContinente(continente);
	}
	
	@ApiOperation(value="Devuelve el numero de habitantes del continente introducido")
	@GetMapping(value="Poblacion/{continente}",produces=MediaType.TEXT_PLAIN_VALUE)
	public String poblacionContinente(@PathVariable("continente") String continente){
		return String.valueOf(service.poblacionContinente(continente));
	}
}
