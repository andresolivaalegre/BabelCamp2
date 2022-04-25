package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.Producto;

@Service
public class ProductosServiceImpl implements ProductosService {
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<Producto> productosSeccion(String seccion) {
			
		String jpql="select p from Producto p where p.seccion=?1";	
		TypedQuery <Producto> query;
		query = entityManager.createQuery(jpql , Producto.class);
		query.setParameter(1, seccion);
		return query.getResultList();
		
	}

	
	@Transactional
	@Override
	public void altaProducto(Producto producto) {
		entityManager.persist(producto);
		
	}

	@Transactional
	@Override
	public void eliminarProducto(String nombre) {
		String jpql="delete from Producto p where p.nombre=?1";
		Query query = entityManager.createQuery(jpql);
		query.setParameter(1, nombre);
		query.executeUpdate();
		
	}


	@Transactional
	@Override
	public void modificarPrecioProducto(String nombre, double nuevoPrecio) {
		Producto p = buscarPorNombre(nombre);
		if(p!=null) {
		p.setPrecio(nuevoPrecio);
		entityManager.merge(p);
		}	
	}
	
	public Producto buscarPorNombre(String nombre) {
		String jpql="select p from Producto p where p.seccion=?1";	
		TypedQuery <Producto> query;
		query = entityManager.createQuery(jpql , Producto.class);
		query.setParameter(1, nombre);
		List<Producto> resultado = query.getResultList();
		return resultado.size()>0 ? resultado.get(0) : null;
	}

	@Override
	public Producto buscarProducto(int idProducto) {
		return entityManager.find(Producto.class, idProducto);
	}


	
}
