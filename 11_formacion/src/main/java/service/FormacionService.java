package service;

import java.util.List;

import model.Alumno;
import model.Curso;

public interface FormacionService {

	Alumno validarUsuario(String usuario, String contrasenia);
	List <Curso> cursosAlumno(String usuario);
	List <Curso> cursos();
	List <Alumno> alumnos();
	List <Alumno> alumnosCurso(String nombreCurso);
	boolean matricularAlumno(String usuario, int idCurso);
	
}
