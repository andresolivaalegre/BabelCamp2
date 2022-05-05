package service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import dao.ProductosDao;
import model.Producto;

@Service
public class ProductosServiceImpl implements ProductosService {

	ProductosDao productosDao;
	
	public ProductosServiceImpl(ProductosDao productosDao) {
		super();
		this.productosDao = productosDao;
	}
	
	@Override
	public void altaProducto(Producto producto) {
		productosDao.save(producto);
	}
	
	@Override
	public Producto buscarProducto(int idProducto) {
		return productosDao.findById(idProducto).orElse(null);
	}
	
	@Override
	public boolean eliminarProducto(int idProducto) {
		if(buscarProducto(idProducto)!=null) {
			productosDao.deleteById(idProducto);
			return true;
		}
		return false;
	}
	
	@Override
	public List<Producto> todosProductos(){
		return productosDao.findAll();
	}
	
	@Override
	public List<Producto> productosSeccion(String seccion) {
		return productosDao.findAll()
		.stream()
		.filter(p->p.getSeccion().equals(seccion))
		.collect(Collectors.toList()); //Stream sin duplicados
	}
	
	
	


	
}
