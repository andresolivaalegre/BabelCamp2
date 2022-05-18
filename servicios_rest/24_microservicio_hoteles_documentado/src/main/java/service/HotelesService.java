package service;

import java.util.List;

import model.Hotel;

public interface HotelesService {

	List<String> hoteles();
	Hotel buscarHotel(String nombre);
	
	
}
