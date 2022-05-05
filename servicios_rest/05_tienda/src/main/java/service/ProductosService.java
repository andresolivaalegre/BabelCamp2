package service;

import java.util.List;

import model.Producto;

public interface ProductosService {

	void altaProducto(Producto producto);
	Producto buscarProducto(int idProducto);
	boolean eliminarProducto(int idProducto);
	List<Producto> todosProductos();
	List<Producto> productosSeccion(String seccion);

}