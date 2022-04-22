package service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import model.Alumno;

@Service
public class AlumnosServiceImpl implements AlumnosService {

	
	@Autowired
	JdbcTemplate template;
	
	@Override
	public List<Alumno> alumnosCurso(String curso) {
		String sql="select * from alumnos where curso =?";
		return template.query(sql, 
				(rs, f)->new Alumno(rs.getInt("idAlumno"), 
						rs.getString("nombre"), 
						rs.getString("curso"), 
						rs.getDouble("nota")), 
				curso);
	}
	
	@Override
	public void altaAlumno(Alumno alumno) {
		if(!existeAlumno(alumno.getNombre())) {
		String sql = "insert into alumnos(nombre,curso,nota) values (?,?,?)";
		template.update(sql, alumno.getNombre(), alumno.getCurso(), alumno.getNota());
		}
	}

	@Override
	public boolean existeAlumno(String nombre) {
		String sql="select * from alumnos where nombre =?";
		List<Alumno> alumnos = template.query(sql, 
				(rs, f)->new Alumno(rs.getInt("idAlumno"), 
						rs.getString("nombre"), 
						rs.getString("curso"), 
						rs.getDouble("nota")), 
				nombre);
		return alumnos.size()>0?true:false;
	}

	@Override
	public List<String> cursos() {
		String sql="select distinct (curso) from alumnos";
		return template.query(sql, (rs, f)->rs.getString("curso"));
	}
}
