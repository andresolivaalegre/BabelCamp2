package service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.AlumnosDao;
import dao.CursosDao;
import model.Alumno;
import model.Curso;
@Service
public class FormacionServiceImpl implements FormacionService {
	

	AlumnosDao alumnosDao;
	CursosDao cursosDao;
	
	public FormacionServiceImpl(@Autowired AlumnosDao alumnosDao, CursosDao cursosDao) {
		this.alumnosDao=alumnosDao;
		this.cursosDao=cursosDao;
	}
	
	@Override
	public boolean altaAlumno(Alumno alumno) {
		Optional <Alumno> alumnoEncontrado = alumnosDao.findById(alumno.getUsuario());
		if(alumnoEncontrado.isEmpty()) {
			alumnosDao.save(alumno);
			return true;
		}
		return false;
	}
	
	@Override
	public boolean altaCurso(Curso curso) {
		Curso cursoEncontrado = cursosDao.findByNombre(curso.getNombre());
		if(cursoEncontrado==null) {
			cursosDao.save(curso);
			return true;
		}
		return false;
	}

	@Override
	public Alumno validarUsuario(String usuario, String password) {
		return alumnosDao.findByUsuarioAndPassword(usuario, password);
	}

	@Override
	public List<Curso> cursosAlumno(String usuario) {
		return cursosDao.findByAlumno(usuario);
	}

	@Override
	public List<Curso> cursos() {
		return cursosDao.findAll();
	}
	
	@Override
	public Alumno buscarAlumno(String usuario) {
		return alumnosDao.findById(usuario).orElse(null);
	}
	
	@Override
	public Curso buscarCurso(int idCurso) {
		return cursosDao.findById(idCurso).orElse(null);
	}

	@Override
	public List<Alumno> alumnosCurso(String nombreCurso) {
		return alumnosDao.findByCurso(nombreCurso);
	}

	@Override
	public boolean matricularAlumno(String usuario, int idCurso) {
		Optional <Curso> curso = cursosDao.findById(idCurso);
		Optional <Alumno> alumno = alumnosDao.findById(usuario);
		if(curso.isPresent()&&alumno.isPresent()) {
			Alumno al=alumno.get();
			al.getCursos().add(curso.get());
			alumnosDao.save(al);
			return true;
		}
		return false;
	}

	@Override
	public List<Alumno> alumnos() {
		return alumnosDao.findAll();
	}

	@Override
	public List<Curso> consultarMatriculas(Date f1, Date f2) {
		return cursosDao.findByFechaInicioBetween(f1, f2);
	}

	@Override
	public List<Curso> cursosPosiblesMatricularAlumno(String usuario) {
		return cursosDao.findCursoNoAlumno(usuario);
	}


}
