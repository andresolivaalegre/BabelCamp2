package service;

import java.util.List;

import model.Vuelo;

public interface VuelosService {

	List<Vuelo> vuelos();
	List<Vuelo> vuelosDisponibles(int numPlazas);
	boolean actualizarVuelo(int idVuelo, int numPlazas);
	Vuelo buscarVuelo(int idVuelo);
}
