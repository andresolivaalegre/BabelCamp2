package testing;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import config.ServiceConfig;
import model.Alumno;
import service.FormacionService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ServiceConfig.class})

public class TestFormacionService {
	@Autowired 
	FormacionService service;
	
	@Test
	void testValidarUsuario() {
		assertNotNull(service.validarUsuario("admin","a"));
		assertNull(service.validarUsuario("hola","adios"));
	}
	
	@Test
	void testObtenerCursos() {
		assertEquals(2, service.cursosAlumno("aaa").size());
	}
	
	@Test
	void testListaCursos() {
		assertEquals(18, service.cursos().size());
	}
	
	
	@Test
	void testNumeroAlumnos() {
		assertEquals(5, service.alumnosCurso("python").size());
	}
	
	@Test
	void testmatricularAlumno() {
		Alumno al = new Alumno("user1","pwd", "nombrecillo", "hola@mail.com", 23);
		assertEquals(true, service.altaAlumno(al));
	}
	
	@Test
	void testConsultarMatriculas() {
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.set(2020, 8 ,20);
		c2.set(2020, 8 ,20);
		Date f1=c1.getTime();
		Date f2=c2.getTime();
	}
	
	
	
	
	
	
	
	
}
