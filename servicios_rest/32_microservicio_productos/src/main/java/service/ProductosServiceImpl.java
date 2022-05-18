package service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import dao.ProductosDao;
import model.Producto;

@Service
public class ProductosServiceImpl implements ProductosService{
	ProductosDao productosDao;
	
	public ProductosServiceImpl(ProductosDao productosDao) {
		super();
		this.productosDao=productosDao;
	}


	@Override
	public void altaProducto(Producto p) {
		productosDao.save(p);
	}

	@Override
	public List<Producto> productos() {
		return productosDao.findAll()
				.stream()
				.collect(Collectors.toList()); //Stream sin duplicados
	}


	@Override
	public void actualizarProducto(int codigoProducto, int unidades) {
		Producto p=buscarProducto(codigoProducto);
		if(p!=null) {
			int stock=p.getStock()-unidades;
			p.setStock(stock);
			productosDao.save(p);
		}
	}


	@Override
	public Producto buscarProducto(int codigoProducto) {
		return productosDao.findById(codigoProducto);
	}


	@Override
	public double precioProducto(int codigoProducto) {
		return productosDao.findById(codigoProducto).getPrecioUnitario();
	}


}
