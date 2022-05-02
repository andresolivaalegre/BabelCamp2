package dao;



import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Curso;

public interface CursosDao extends JpaRepository<Curso, Integer>{
	@Query("select c from Curso c join c.alumnos a where a.usuario=?1")
	List <Curso> findByAlumno(String usuario);
	
	Curso findByNombre(String nombre);
	
	@Query("select c from Curso c where c Not in(select c from Curso c join c.alumnos a where a.usuario=?1) ")
	List<Curso> findCursoNoAlumno(String usuario);
	
	List<Curso> findByFechaInicioBetween(Date desde, Date hasta);
	
}
