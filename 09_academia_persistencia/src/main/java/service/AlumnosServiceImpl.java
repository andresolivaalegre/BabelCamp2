package service;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import model.Alumno;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AlumnosServiceImpl implements AlumnosService {

	@PersistenceContext
	EntityManager entityManager;
	@Autowired
	JdbcTemplate template;
	
	@Override
	public List<Alumno> alumnosCurso(String curso) {
		String jpql="select a from Alumno a where a.curso=?1";	
		TypedQuery <Alumno> query;
		query = entityManager.createQuery(jpql , Alumno.class);
		query.setParameter(1, curso);
		return query.getResultList();
	}
	
	@Transactional
	@Override
	public void altaAlumno(Alumno alumno) {
		entityManager.persist(alumno);
	}
	
	@Transactional
	@Override
	public void eliminarAlumno(String nombre) {
		String jpql="delete from Alumno a where a.nombre=?1";
		Query query = entityManager.createQuery(jpql);
		query.setParameter(1, nombre);
		query.executeUpdate();
	}

	@Override
	public boolean existeAlumno(String nombre) {
		String jpql="select p from Producto p where p.seccion=?1";	
		TypedQuery <Alumno> query;
		query = entityManager.createQuery(jpql , Alumno.class);
		query.setParameter(1, nombre);
		List<Alumno> resultado = query.getResultList();
		return resultado.size()>0 ? true : false;
	}

	@Override
	public List<String> cursos() {	
		String jpql="select distinct (curso) from alumnos";	
		TypedQuery <String> query;
		query = entityManager.createQuery(jpql , String.class);
		return query.getResultList();
	}
}
