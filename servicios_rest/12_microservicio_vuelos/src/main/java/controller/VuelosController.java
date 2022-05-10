package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Vuelo;
import service.VuelosService;

@CrossOrigin("*")
@RestController
public class VuelosController {
	@Autowired
	VuelosService service;
	

	@GetMapping(value="VuelosDisponibles/{numPlazas}",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Vuelo> vuelosDisponibles(@PathVariable("numPlazas") int numPlazas){
		return service.vuelosDisponibles(numPlazas);
	}
	
	@GetMapping(value="VuelosDisponibles",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Vuelo> vuelos(){
		return service.vuelos();
	}
	
	@PutMapping(value="ActualizarVuelo",produces=MediaType.TEXT_PLAIN_VALUE)
	public String actualizar(@RequestParam("idVuelo") int idVuelo, @RequestParam("numPlazas") int numPlazas) {
		return String.valueOf(service.actualizarVuelo(idVuelo, numPlazas));
	}

}
