package testing;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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
	
	
	
	
	
	
}
