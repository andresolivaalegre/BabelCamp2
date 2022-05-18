package service;
import java.util.List;

import org.springframework.stereotype.Service;

import dao.HotelesDao;
import model.Hotel;

@Service
public class HotelesServiceImpl implements HotelesService{

	HotelesDao hotelesDao;
	
	public HotelesServiceImpl(HotelesDao hotelesDao) {
		super();
		this.hotelesDao = hotelesDao;
	}
	
	@Override
	public List<Hotel> hoteles() {
		return hotelesDao.findAll();
	}

	@Override
	public Hotel buscarHotel(String nombre) {
		return hotelesDao.findByNombre(nombre);
	}

}
