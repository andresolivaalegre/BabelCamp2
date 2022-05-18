package service;
import java.util.List;
import java.util.stream.Collectors;

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
	public List<String> hoteles() {
		return hotelesDao.findAll()
				.stream()
				.map(a->a.getNombre())
				.distinct() //Stream con los nombres de hotel
				.collect(Collectors.toList()); //Stream sin duplicados
	}

	@Override
	public Hotel buscarHotel(String nombre) {
		return hotelesDao.findByNombre(nombre);
	}

}
