package service;

import java.util.List;

import model.Hotel;

public interface HotelesService {

	List<Hotel> hoteles();
	Hotel buscarHotel(String nombre);
	
	
}
