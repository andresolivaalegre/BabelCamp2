package service;

import java.util.List;

import model.Producto;

public interface ProductosService {

	void altaProducto(Producto p);
	List<Producto> productos();
	void actualizarProducto(int codigoProducto, int unidades);
	Producto buscarProducto(int codigoProducto);
	double precioProducto(int codigoProducto);
}
