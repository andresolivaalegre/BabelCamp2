package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Producto;
import service.ProductosService;

@Controller
public class ProductosController {
	@Autowired
	ProductosService productosService;
	
	@PostMapping("Alta")
	public String alta(@ModelAttribute Producto producto)  {
		productosService.altaProducto(producto);
		return "alta";
	}
	
	@GetMapping("Eliminar")
	public String eliminar(@RequestParam("nombre") String nombre)  {	
		productosService.eliminarProducto(nombre);
		return "inicio";
	}
	@GetMapping("Buscador")	
	public String buscar(HttpServletRequest request, @RequestParam("seccion") String seccion)  {		
		List<Producto> prods=productosService.productosSeccion(seccion);
		request.setAttribute("productos", prods);
		return "listado";		
	}
	
	@GetMapping("Modificar")
	public String modif(@RequestParam("nombre") String nombre, 
			@RequestParam("precio") double precio) {		 
		productosService.modificarPrecioProducto(nombre,precio);
		return "inicio";
	}
}
