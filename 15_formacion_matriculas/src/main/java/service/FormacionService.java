package service;

import java.util.Date;
import java.util.List;

import dto.AlumnoDto;
import dto.CursoDto;
import dto.MatriculaDto;

public interface FormacionService 
{
	AlumnoDto validarUsuario(String usuario, String password);
	List<CursoDto> cursosAlumno(String usuario);
	List<CursoDto> cursos();
	List<AlumnoDto> alumnos();
	List<AlumnoDto> alumnosCurso(String nombre);
	boolean matricularAlumno(String usuario, int idCurso);
	
	boolean altaAlumno(AlumnoDto alumno);
	boolean altaCurso(CursoDto curso);
	List<MatriculaDto> consultarMatriculas(Date f1, Date f2);
	List<CursoDto> cursosPosiblesMatricularAlumno(String usuario);
}
