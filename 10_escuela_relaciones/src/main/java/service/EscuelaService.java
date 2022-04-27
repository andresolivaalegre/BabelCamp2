package service;

import java.util.List;

import model.Alumno;
import model.Curso;

public interface EscuelaService {
	List<Alumno> alumnosCurso(String nombre);
	List<Alumno> alumnosCursoDuracion(int duracionMax);
	Curso cursoMatriculadoAlumno(String dni);
	List<Curso> alumnosSenior(int edad); //Lista de cursos en los que estan matriculados alumnos con edad superior al valor recibido
	double edadMediaCurso(String nombreCurso);
	double precioCurso(String email);//Precio del curso en el que esta matriculado el mail

}
