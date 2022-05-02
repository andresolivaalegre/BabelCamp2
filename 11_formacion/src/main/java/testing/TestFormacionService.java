package testing;



import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import config.ServiceConfig;
import service.FormacionService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ServiceConfig.class})

public class TestFormacionService {
	@Autowired 
	FormacionService service;
	
	@Test
	void testValidarUsuario() {
		assertEquals("tomates", service.validarUsuario("admin","a").getNombre());
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
	void testMatricularAlumno() {
		service.matricularAlumno("test1", 1);
		assertEquals(9, service.alumnosCurso("java 10").size());
		assertEquals(1, service.cursosAlumno("test1").size());		
	}
	
	
	
	
}
