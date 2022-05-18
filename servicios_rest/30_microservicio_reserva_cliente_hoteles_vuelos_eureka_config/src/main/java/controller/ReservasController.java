package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Reserva;
import service.ReservasService;

@CrossOrigin("*")
@RestController
public class ReservasController {
	@Autowired
	ReservasService service;
	
	@PostMapping(value="Reservar",consumes = MediaType.APPLICATION_JSON_VALUE)
	public void altaReserva(@RequestParam("idVuelo") int idVuelo, @RequestParam("idHotel") int idHotel, @RequestParam("nombre") String nombre, @RequestParam("dni") int dni, @RequestParam("totalPersonas") int totalPersonas) {
		service.altaVuelo(idVuelo, totalPersonas);
		service.altaReserva(idVuelo, idHotel, nombre, dni, totalPersonas);
	}
	
	@GetMapping(value="Reservas",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Reserva> reservas(){
		return service.reservas();
	}
	

}
