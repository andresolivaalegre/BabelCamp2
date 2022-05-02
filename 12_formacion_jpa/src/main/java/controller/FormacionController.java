package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Alumno;
import model.Curso;
import service.FormacionService;

@CrossOrigin("*")
@Controller
public class FormacionController {
	@Autowired
	FormacionService formacionService;
	
	
	@GetMapping(value="Cursos", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Curso> cursos()  {	
		return formacionService.cursos();
	}
	
	@GetMapping(value="Alumnos", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Alumno> alumnos()  {	
		return formacionService.alumnos();
	}
	
	@GetMapping(value="CursosAlumno", produces = MediaType.APPLICATION_JSON_VALUE)	
	public @ResponseBody List<Curso> cursosAlumno(@RequestParam("usuario") String usuario)  {		
		return formacionService.cursosAlumno(usuario);	
	}
	
	@GetMapping(value="AlumnosCurso", produces = MediaType.APPLICATION_JSON_VALUE)	
	public @ResponseBody List<Alumno> alumnosCurso(@RequestParam("nombreCurso") String nombreCurso)  {		
		return formacionService.alumnosCurso(nombreCurso);	
	}
	
	@PostMapping("Login")
	public String login(@RequestParam String usuario, @RequestParam String password, HttpSession sesion, HttpServletRequest request)  {
		Alumno alumno = formacionService.validarUsuario(usuario, password);
		if(alumno!=null) {
			sesion.setAttribute("alumno", alumno);
			return "menu";}
		return "loginError";
	}
	
	

}
