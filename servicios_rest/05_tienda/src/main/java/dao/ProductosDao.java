package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Producto;

public interface ProductosDao extends JpaRepository<Producto, Integer>{
	/*Opcion1
	@Query("select distinct (a.curso) from Alumno a")
	List<String> findCursos();*/
	
	/*Opcion2:no se hace este metodo y que la capa de servicio filtre*/
}
