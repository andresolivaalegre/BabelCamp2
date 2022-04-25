package service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import model.Producto;

@Service
public class ProductosServiceImpl implements ProductosService {
	static List<Producto> productos=new ArrayList<>(List.of(new Producto("vino","alimentaci�n",8.4,25),
			new Producto("leche","alimentaci�n",1.2,70),
			new Producto("cable usb","inform�tica",5.6,30),
			new Producto("arroz","alimentaci�n",3.1,16),
			new Producto("silla","hogar",30.6,10),
			new Producto("monitor","inform�tica",125.0,5),
			new Producto("escritorio","hogar",230,4)
			));
	//devuelve la lista de productos de la secci�n que le llegue como par�metro
	@Override
	public List<Producto> productosSeccion(String seccion){
		return productos.stream()
				.filter(p->p.getSeccion().equals(seccion))
				.collect(Collectors.toList());
	}
	//el m�todo recibe los datos de un producto y lo da de alta en la lista
	@Override
	public void altaProducto(Producto producto) {
		
		productos.add(producto);
	}
	//localiza la posici�n del producto que tiene ese nombre
	//y lo borra por posici�n
	@Override
	public void eliminarProducto(String nombre) {
		/*for(int i=0;i<productos.size();i++) {
			if(productos.get(i).getNombre().equals(nombre)) {
				productos.remove(i);
				break;
			}
		}*/
		productos.removeIf(p->p.getNombre().equals(nombre));
	}
	//localizar el producto por su nombre y establecerle el nuevo precio
	@Override
	public void modificarPrecioProducto(String nombre, double nuevoPrecio) {
		
		productos.forEach(p->{
			if(p.getNombre().equals(nombre)) {
				p.setPrecio(nuevoPrecio);
			}
		});
	}
}
