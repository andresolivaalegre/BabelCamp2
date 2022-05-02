package dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Curso;

public interface CursosDao extends JpaRepository<Curso, Integer>{
	@Query("select c from Curso c join c.alumnos a where a.usuario=?1")
	List <Curso> findByAlumno(String usuario);
	
	@Query("select  c from curso c where c.fechaInicio between ?1 and  ?2")
	List <Curso> findByFechaRango(Date inicio, Date fin);
	
	@Query("select c from Curso c join c.alumnos a where a.usuario!=?1")
	List<Curso> findByAlumnoNoMatriculado(String usuario);
}
