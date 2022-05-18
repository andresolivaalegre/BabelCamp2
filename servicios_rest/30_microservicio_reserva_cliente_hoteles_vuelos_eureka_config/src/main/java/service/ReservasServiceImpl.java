package service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dao.ReservasDao;
import model.Reserva;
import model.Vuelo;

@Service
public class ReservasServiceImpl implements ReservasService{
	
	RestTemplate template;
	String urlBase="http://servicio-vuelos/";
	ReservasDao reservasDao;
	
	public ReservasServiceImpl(@Autowired RestTemplate template, ReservasDao reservasDao) {
		super();
		this.reservasDao=reservasDao;
		this.template = template;
	}

	@Override
	public void altaReserva(int idVuelo, int idHotel, String nombre, int dni, int totalPersonas) {
		Reserva reserva=new Reserva(nombre, dni, idVuelo, idHotel);
		reservasDao.save(reserva);
	}

	@Override
	public List<Reserva> reservas() {
		return reservasDao.findAll()
				.stream()
				.collect(Collectors.toList()); //Stream sin duplicados
	}

	@Override
	public void altaVuelo(int idVuelo, int numPlazas) {
		template.put(urlBase+"/ActualizarVuelo?idVuelo="+idVuelo+"&numPlazas="+numPlazas, Vuelo.class);
		
	}

}
