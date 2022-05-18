package service;

import java.util.List;

import model.Reserva;

public interface ReservasService {

	void altaReserva(int idVuelo, int idHotel, String nombre, int dni, int totalPersonas);
	void altaVuelo(int idVuelo, int numPersonas);
	List<Reserva> reservas();
}
