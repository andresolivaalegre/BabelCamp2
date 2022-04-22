package service;

import java.util.List;

import org.springframework.web.bind.annotation.ResponseBody;

import model.Alumno;

public interface AlumnosService {

	List<Alumno> alumnosCurso(String curso);
	void altaAlumno(Alumno alumno);
	boolean existeAlumno(String nombre);
	public List<String> cursos();


}