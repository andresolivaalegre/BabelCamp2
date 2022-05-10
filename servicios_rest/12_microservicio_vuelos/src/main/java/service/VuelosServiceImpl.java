package service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import dao.VuelosDao;
import model.Vuelo;

@Service
public class VuelosServiceImpl implements VuelosService{


	VuelosDao vuelosDao;
	
	public VuelosServiceImpl(VuelosDao vuelosDao) {
		super();
		this.vuelosDao = vuelosDao;
	}

	@Override
	public List<Vuelo> vuelosDisponibles(int numPlazas) {
		return vuelosDao.findAll()
				.stream()
				.filter(a->a.getPlazas()>numPlazas)
				.distinct() 
				.collect(Collectors.toList()); 
	}

	@Override
	public boolean actualizarVuelo(int idVuelo, int numPlazas) {
		Vuelo vuelo=buscarVuelo(idVuelo);
		if(vuelo!=null) {
			int plazas=vuelo.getPlazas()-numPlazas;
			vuelo.setPlazas(plazas);
			vuelosDao.save(vuelo);
			return true;
		}
		return false;
	}

	@Override
	public Vuelo buscarVuelo(int idVuelo) {
		return vuelosDao.findById(idVuelo);
	}

	@Override
	public List<Vuelo> vuelos() {
		return vuelosDao.findAll()
				.stream()
				.collect(Collectors.toList()); //Stream sin duplicados
	}
	
}
